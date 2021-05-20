package Thread.jpt212;

import java.util.concurrent.Callable;

public class LiftOffCallable implements Callable {
    protected int countDown = 10; // Default
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOffCallable() {}
    public LiftOffCallable(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff111!") + "), ";
    }
    /*public void run() {
        while(countDown-- > 0) {
            String getStatus = status();
            System.out.print(getStatus);
            Thread.yield();
        }
    }*/

    @Override
    public Object call() throws Exception {
        while(countDown-- > 0) {
            String getStatus = status();
            System.out.print(getStatus);
            Thread.yield();
        }
        return null;
    }
}
