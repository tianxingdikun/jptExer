package service;

import java.util.concurrent.TimeUnit;

public class SelfExer {
    public static void main(String[] args) {
        Object co = new Object();
        System.out.println(co);

        for (int i = 0; i < 5; i++) {
            MyThread t = new MyThread("Thread" + i, co);
            t.start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("-----Main Thread notify-----");
            synchronized (co) {
                co.notifyAll();
            }

            TimeUnit.SECONDS.sleep(2);
            System.out.println("Main Thread is end.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyThread extends Thread {
        private String name;
        private Object co;

        public MyThread(String name, Object o) {
            this.name = name;
            this.co = o;
        }

        @Override
        public void run() {
            System.out.println(name + " is waiting.");
            try {
                synchronized (co) {
                    co.wait();
                }
                System.out.println(name + " has been notified.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

 /*
运行结果：
        java.lang.Object@1540e19d
        Thread1 is waiting.
        Thread2 is waiting.
        Thread0 is waiting.
        Thread3 is waiting.
        Thread4 is waiting.
        -----Main Thread notify-----
        Thread1 has been notified.
        Main Thread is end.

        将其中的那个notify换成notifyAll，运行结果：
        Thread0 is waiting.
        Thread1 is waiting.
        Thread2 is waiting.
        Thread3 is waiting.
        Thread4 is waiting.
        -----Main Thread notifyAll-----
        Thread4 has been notified.
        Thread2 has been notified.
        Thread1 has been notified.
        Thread3 has been notified.
        Thread0 has been notified.
        Main Thread is end.

        运行环境jdk8，结论：
        notify唤醒一个等待的线程；notifyAll唤醒所有等待的线程。*/
