package com.pjj.case1;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年10月20日 21:36
 */
public class DistributeClient {
    private ZooKeeper zooKeeper;
    private String connectString = "192.168.129.130:2181";
    private int sessionTimeout = 5000;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributeClient client = new DistributeClient();
        //获取连接
        client.getConnection();
        //监听/servers下面子节点的增加或删除
        client.getServerList();
        //业务
        client.business();
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void getServerList() throws KeeperException, InterruptedException {
        List<String> children = zooKeeper.getChildren("/servers", true);
        List<String> list  = new ArrayList();
        for (String child : children) {
            byte[] data = zooKeeper.getData("/servers/" + child, false, null);
            list.add(new String(data));
        }
        System.out.println(list);
    }

    private void getConnection() throws IOException {
        zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    getServerList();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
