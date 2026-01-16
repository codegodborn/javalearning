package com.lipenglin;

public class notifyAll {
    static boolean flag = false;
    static Object lock = new Object();
    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            synchronized (lock) {
                while (!flag) {
                    System.out.println(Thread.currentThread().getName()+"...wating...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+"...flag is true...");
                }
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (lock) {
                while (!flag) {
                    System.out.println(Thread.currentThread().getName()+"...wating...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {

                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+"...flag is true...");
                }
            }
        });
        Thread t3 = new Thread(()->{
            synchronized (lock) {

                    System.out.println(Thread.currentThread().getName()+"...wating...");
                    lock.notifyAll();
//                    flag = true;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

        });
        t1.start();
        t2.start();
        t3.start();
    }
}
