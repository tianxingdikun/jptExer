package Thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;


public class ThreadInMain {
    public static void main(String[] args) {

        System.out.println("---------------main方法执行----------------------");
        // 获取线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 无需获取同步的monitor和synchronizer信息
        // 仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        System.out.println("-------------开始打印线程信息------------");
        for (ThreadInfo threadInfo : threadInfos) {
            // 获取线程id和线程名
            System.out.println("[" + threadInfo.getThreadId() + "]" + "------->" + threadInfo.getThreadName());
        }
        System.out.println("main方法执行完毕");
    }
}

