package com.lipenglin;

public class ThreeThreadController {
    public static void main(String[] args) {
//        create new Thread object
        Thread t1 = new Thread(()->{
            System.out.println("t1");
        });
        Thread t2 = new Thread(()->{
            try{
                t1.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("t2");
        });
        Thread t3 = new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t3");
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
