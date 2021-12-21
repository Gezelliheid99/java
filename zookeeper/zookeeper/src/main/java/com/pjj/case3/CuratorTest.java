package com.pjj.case3;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author 潘俊杰
 * @date 2021年10月21日 14:01
 */
public class CuratorTest {
    public static void main(String[] args) {
        InterProcessMutex lock1 = new InterProcessMutex(getCuratorFrame(), "/locks");

        InterProcessMutex lock2 = new InterProcessMutex(getCuratorFrame(), "/locks");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //获取锁
                    lock1.acquire();
                    System.out.println("线程1获取到锁");
                    lock1.acquire();
                    System.out.println("线程1获取到锁");

                    Thread.sleep(5*1000);

                    lock1.release();
                    System.out.println("线程1释放锁");
                    lock1.release();
                    System.out.println("线程1释放锁");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //获取锁
                    lock2.acquire();
                    System.out.println("线程2获取到锁");
                    lock2.acquire();
                    System.out.println("线程2获取到锁");

                    Thread.sleep(5*1000);

                    lock2.release();
                    System.out.println("线程2释放锁");
                    lock2.release();
                    System.out.println("线程2释放锁");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static CuratorFramework getCuratorFrame() {
        ExponentialBackoffRetry policy = new ExponentialBackoffRetry(3000, 3);
        CuratorFramework framework = CuratorFrameworkFactory.builder().connectString("zookeeper102:2181")
                .sessionTimeoutMs(3000)
                .connectionTimeoutMs(3000)
                .retryPolicy(policy).build();

        //启动客户端
        framework.start();
        System.out.println("zookeeper  启动成功！");
        return framework;
    }
}
