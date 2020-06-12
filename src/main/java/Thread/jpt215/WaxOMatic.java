package Thread.jpt215;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMatic {


    /**
     * wait(),notify(),notifyAll()
     * 调用wait()，释放锁，等待设定时间后或调用notify/notifyAll唤醒
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5); // Run for a while...
        exec.shutdownNow(); // Interrupt all tasks
    }


    static class WaxOff implements Runnable {
        private Car car;
        public WaxOff(Car c) { car = c; }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    car.waitForWaxing();
                    System.out.println("Wax Off! ");
                    TimeUnit.MILLISECONDS.sleep(200);
                    car.buffed();
                }
            } catch(InterruptedException e) {
                System.out.println("Exiting via interrupt");
            }
            System.out.println("Ending Wax Off task");
        }
    }


    static class WaxOn implements Runnable {
        private Car car;
        public WaxOn(Car c) { car = c; }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    System.out.println("Wax On! ");
                    TimeUnit.MILLISECONDS.sleep(200);
                    car.waxed();
                    car.waitForBuffing();
                }
            } catch(InterruptedException e) {
                System.out.println("Exiting via interrupt");
            }
            System.out.println("Ending Wax On task");
        }
    }


    static class Car {
        private boolean waxOn = false;
        public synchronized void waxed() {
            waxOn = true; // Ready to buff
            notifyAll();
        }
        public synchronized void buffed() {
            waxOn = false; // Ready for another coat of wax
            notifyAll();
        }
        public synchronized void waitForWaxing()
                throws InterruptedException {
            while(waxOn == false)
                wait();
        }
        public synchronized void waitForBuffing()
                throws InterruptedException {
            while(waxOn == true)
                wait();
        }
    }
}
