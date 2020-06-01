package Thread.jpt213;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicityTest implements Runnable {
    private int i = 0;
    public int getValue() { return i; }
    private synchronized void evenIncrement() { i++; i++; }
    public void run() {
        while(true)
            evenIncrement();
    }

    /**
     * 原子性，可见性
     *
     * */
    public static void main1(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while(true) {
            int val = at.getValue();
            System.out.println(val);
            if(val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }

    /**
     *
     * 原子性工具：AtomicInteger,AtomicLong,AtomicReference
     *
     * */

    public static class AtomicIntegerTest implements Runnable {
        private AtomicInteger i = new AtomicInteger(0);
        public int getValue() { return i.get(); }
        private void evenIncrement() { i.addAndGet(2); }
        public void run() {
            while(true)
                evenIncrement();
        }
        public static void main(String[] args) {
            new Timer().schedule(new TimerTask() {
                public void run() {
                    System.err.println("Aborting");
                    System.exit(0);
                }
            }, 5000); // Terminate after 5 seconds
            ExecutorService exec = Executors.newCachedThreadPool();
            AtomicIntegerTest ait = new AtomicIntegerTest();
            exec.execute(ait);
            while(true) {
                int val = ait.getValue();
                if(val % 2 != 0) {
                    System.out.println(val);
                    System.exit(0);
                }
            }
        }
    }

}
