package lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock
 */
public class LockDemo {

    //这个只能保证可见性 并不能保证原子性
    private static  int num = 0;
    private static CountDownLatch countDownLatch =new CountDownLatch(10);

    private static Lock lock = new ReentrantLock();

    /**
     * 每次调用对num进行++的操作
     *
     */
    public static  void  increment(){
        lock.lock();
        num++;
        lock.unlock();
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j <20 ; j++) {
                    increment();
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //在每个线程只想完后调用cutdown
                countDownLatch.countDown();
            }).start();

        }


        while (true){
            if(countDownLatch.getCount()==0){
                break;
            }
        }

        System.out.println(num);
    }
}