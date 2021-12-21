package com.pjj.case2;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author 潘俊杰
 * @date 2021年10月20日 22:34
 */
public class DistributeLock {
    private ZooKeeper zooKeeper;
    private String connectString = "zookeeper102:2181";
    private int sessionTimeout = 3000;
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    private CountDownLatch waitLatch = new CountDownLatch(1);
    //前一个节点
    private String preNode;
    private String currentMode;

    public DistributeLock() throws IOException, KeeperException, InterruptedException {
        //获取连接
        getConnection();
        //判断根节点/locks是否存在
        if (!isExistLocks()){
            createLocks();
        }
    }

    private void createLocks() throws KeeperException, InterruptedException {
        zooKeeper.create("/locks", "locks".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    private boolean isExistLocks() throws KeeperException, InterruptedException {
        Stat stat = zooKeeper.exists("/locks", false);
        if (stat == null){
            return false;
        }else {
            return true;
        }
    }

    private void getConnection() throws IOException, InterruptedException {
        zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //countDownLatch 如果连接上zk 释放
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected){
                    countDownLatch.countDown();
                }
                //waitLatch 如果前一个节点不存在，放弃监听，释放
                if (watchedEvent.getType() == Event.EventType.NodeDeleted && watchedEvent.getPath().equals(preNode)){
                    waitLatch.countDown();
                }
            }
        });
        //等待zk连接后才会继续执行
        countDownLatch.await();
    }

    /**
     * 加锁操作
     */
    public void zkLock()  {
        try {
            //创建对应的带序号的临时节点
            currentMode = zooKeeper.create("/locks/seq-", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            //判断创建的节点是否是最小的节点，如果不是就监听前一个节点，如果是就获取锁
            List<String> children = zooKeeper.getChildren("/locks", false);
            if (children.size() == 1 ){
                return;
            }else {
                //对集合排序
                Collections.sort(children);
                //获取节点名称
                String node = currentMode.substring("/locks/".length());
                //节点在集合中的位置
                int index = children.indexOf(node);
                if (index ==0 ){
                    //为第一个节点
                    return;
                }else {
                    preNode = "/locks/" + children.get(index - 1 );
                    zooKeeper.getData(preNode, true, null);
                    waitLatch.await();
                    return;
                }
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 释放锁
     */
    public void release() throws KeeperException, InterruptedException {
        //删除节点
        zooKeeper.delete(currentMode, -1);
    }
}
