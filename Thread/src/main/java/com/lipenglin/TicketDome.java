package com.lipenglin;

public class TicketDome {
    int ticketNum = 10;

    public synchronized void t1() throws InterruptedException {
        synchronized (this) {
            if (ticketNum <= 0) {
                return;
            }
            ticketNum--;
            System.out.println(Thread.currentThread().getName()+"...get a ticket..."+ticketNum);

        }
    }
    // 没有加锁会有并发问题
//    Thread-0...get a ticket...8
//    Thread-3...get a ticket...6
//    Thread-1...get a ticket...8
//    第9张票被卖出去两次
    public void t2() throws InterruptedException {
        if (ticketNum <= 0) {
            return;
        }
        ticketNum--;
        System.out.println(Thread.currentThread().getName()+"...get a ticket..."+ticketNum);
    }


    public static void main(String[] args) {
        TicketDome t1 = new TicketDome();

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    t1.t2();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }

}
