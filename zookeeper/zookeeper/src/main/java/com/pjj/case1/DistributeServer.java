package com.pjj.case1;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * @author 潘俊杰
 * @date 2021年10月20日 21:19
 */
public class DistributeServer {
    private ZooKeeper zooKeeper;
    private String connectString = "192.168.129.130:2181";
    private int sessionTimeout = 3000;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributeServer server = new DistributeServer();
        //获取连接
        server.getConnection();
        //注册服务器到集群
        server.register(args[0]);
        //业务
        Thread.sleep(Long.MAX_VALUE);
    }

    private void register(String hostname) throws KeeperException, InterruptedException {
        zooKeeper.create("/servers/" + hostname, hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostname + "is Online!");

    }

    private void getConnection() throws IOException {
        zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });

    }
}
