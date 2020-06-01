package Thread.jpt213;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield(); // Cause failure faster
        ++currentEvenValue;
        return currentEvenValue;
    }

    /**
     * 没有看懂（EvenChecker,EvenGenerator,IntGenerator,SynchronizedEvenGenerator）
     *
     * 多线程时要注意资源的共享问题。所以上面4个类里面在过程后面加锁。
     * */
    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }

    /**
     * 用lock显式重写SynchronizedEvenGenerator的锁
     * */
    public static class MutexEvenGenerator extends IntGenerator {
        private int currentEvenValue = 0;
        private Lock lock = new ReentrantLock();
        public int next() {
            lock.lock();
            try {
                ++currentEvenValue;
                Thread.yield(); // Cause failure faster
                ++currentEvenValue;
                return currentEvenValue;
            } finally {
                lock.unlock();
            }
        }

        public static void main(String[] args) {
            EvenChecker.test(new MutexEvenGenerator());
        }
    }



}
