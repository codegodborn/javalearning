package com.lipenglin;

import java.util.concurrent.*;

public class CreateThreadForFour {

//    方式一：通过继承Thread Class
    public static class MyThread extends Thread {
        public void run() {
            System.out.println("Hello, World!");
        }

        public static void main(String[] args) {
            System.out.println("Hello, World!");
            MyThread myThread = new MyThread();
            myThread.start();
        }
    }

//    方式二：通过实现RUNNABLE接口
    public static class MyRunnable implements Runnable {
        public void run() {
            System.out.println("Hello, World!");
        }
        public static void main(String[] args) {
            MyRunnable myRunnable = new MyRunnable();
            Thread myThread = new Thread(myRunnable);
            myThread.start();
        }
    }

//    方式三：通过实现Callable方式实现线程，好处是可以调用线程的返回值
    public static class MyCallable implements Callable<String>
    {

        @Override
        public String call() throws Exception {

            System.out.println("Hello, World!"+Thread.currentThread().getName());
            return "Hello, Worl!";
        }

        public static void main(String[] args) throws ExecutionException, InterruptedException {
            MyCallable myCallable = new MyCallable();
//            FutureTask 是一个 "一次性任务"，它实现了 Runnable 和 Future 接口，但只能执行一次。
            FutureTask<String> futureTask = new FutureTask<String>(myCallable);
            Thread thread = new Thread(futureTask, "MyThread");
            Thread thread2 = new Thread(futureTask, "MyThread2");
            thread.start();
            thread2.start();
            String result = futureTask.get();
            System.out.println(result);
        }
    }

//    方式四：线程池创建线程

    public static class MyExecutor implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello, World!"+Thread.currentThread().getName());
        }
        public static void main(String[] args) {
            ExecutorService threadPool = Executors.newFixedThreadPool(5);
            threadPool.execute(new MyExecutor());

            threadPool.shutdown();
        }
    }


}
