package com.pjj.case2;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

/**
 * @author 潘俊杰
 * @date 2021年10月20日 23:16
 */
public class DistributeLockTest {

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        final DistributeLock lock1 = new DistributeLock();
        final DistributeLock lock2 = new DistributeLock();

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    lock1.zkLock();
                    System.out.println("线程1启动，获取到锁");
                    Thread.sleep(5*1000);
                    lock1.release();
                    System.out.println("线程1的锁释放了 ");
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    lock2.zkLock();
                    System.out.println("线程2启动，获取到锁");
                    Thread.sleep(5*1000);
                    lock2.release();
                    System.out.println("线程2的锁释放了 ");
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
