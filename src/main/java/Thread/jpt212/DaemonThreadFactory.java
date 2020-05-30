package Thread.jpt212;

import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread();
        t.setDaemon(true);
        System.out.println("1=1");
        return t;
    }
}
