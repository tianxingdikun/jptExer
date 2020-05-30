package Thread.jpt212;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
    public void run() {
        try {
            while(countDown-- > 0) {
                System.out.print(status());
                // Old-style:
                // Thread.sleep(100);
                // Java SE5/6-style:
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch(InterruptedException e) {
            System.err.println("Interrupted");
        }
    }


    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new SleepingTask());
        exec.shutdown();
    }

    /**
     * #2(9), #4(9), #3(9), #1(9), #0(9), #2(8), #4(8), #0(8), #1(8), #3(8),
     * #1(7), #2(7), #3(7), #4(7), #0(7), #0(6), #2(6), #3(6), #1(6), #4(6),
     * #3(5), #0(5), #4(5), #1(5), #2(5), #4(4), #0(4), #3(4), #1(4), #2(4),
     * #4(3), #0(3), #1(3), #3(3), #2(3), #1(2), #0(2), #4(2), #3(2), #2(2),
     * #4(1), #0(1), #1(1), #2(1), #3(1), #1(Liftoff!), #0(Liftoff!), #4(Liftoff!),
     * #2(Liftoff!), #3(Liftoff!),
     *
     * */

}
