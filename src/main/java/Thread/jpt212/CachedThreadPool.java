package Thread.jpt212;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

    public static void main(String[] args) {
        /***
         * 使用Execute管理thread,不用显式的管理thread的生命周期了。
         * CachedThreadPool。
         * 1、有多少任务就会有自动创建多少线程；
         * 2、适合任务量大且每个任务消耗时间短；
         * 3、需要关注运行时间长后，线程创建太多造成内存溢出
         *
         */
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }


   /**
    *
    * #1(9), #4(9), #3(9), #2(9), #3(8), #0(9), #3(7), #2(8), #4(8), #1(8),
    * #4(7), #2(7), #3(6), #0(8), #3(5), #2(6), #4(6), #1(7), #4(5), #2(5),
    * #3(4), #0(7), #3(3), #2(4), #4(4), #1(6), #4(3), #2(3), #3(2), #0(6),
    * #3(1), #2(2), #4(2), #1(5), #4(1), #2(1), #4(Liftoff!), #3(Liftoff!),
    * #0(5), #2(Liftoff!), #1(4), #0(4), #1(3), #0(3), #1(2), #1(1), #1(Liftoff!),
    * #0(2), #0(1), #0(Liftoff!),
    *
    * */

}
