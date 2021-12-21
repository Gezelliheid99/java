package com.pjj.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年10月19日 16:50
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class zkClient {

    private ZooKeeper zooKeeper;
    private String connectString = "zookeeper102:2181";
    private int sessionTimeout = 3000;


    @BeforeAll
    public void init() throws IOException {
        zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("=====================");
                List<String> children = null;
                try {
                    children = zooKeeper.getChildren("/", true);
                    for (String child : children) {
                        // System.out.println(child);
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Test
    public void create() throws KeeperException, InterruptedException {
        String node = zooKeeper.create("/pjj", "data001".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    @Test
    public void getChildren() throws KeeperException, InterruptedException {
        List<String> children = zooKeeper.getChildren("/", true);
        for (String child : children) {
            System.out.println(child);
        }
        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void exists() throws KeeperException, InterruptedException {
        Stat stat = zooKeeper.exists("/pjj1", false);
        System.out.print("节点是否存在：");
        System.out.println(stat==null?"不存在":"存在");
    }













}
