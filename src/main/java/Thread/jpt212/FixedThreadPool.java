package Thread.jpt212;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPool {

    public static void main(String[] args) throws Exception {
        // Constructor argument is number of threads:
        /**
         * 不同于CachedThreadPool，FixedThreadPool用有限的线程集处理提交的任务
         * FixedThreadPool：
         * 1、固定数量的线程去执行任务（这个任务可以很大）
         * 2、如有线程down掉，会有新的线程代替
         * 3、所有线程会在shutdown方法后清除
         */
        List<Future> futures = new ArrayList<>();
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++) {
            futures.add(exec.submit(new LiftOffCallable()));
        }
        exec.shutdown();
        Iterator iter = futures.iterator();
        while (iter.hasNext()){
            Future future = (Future) iter.next();
            future.get();
        }
        System.out.println("结书");
    }

    /**
     * #1(9), #3(9), #2(9), #4(9), #0(9), #4(8), #2(8), #3(8), #1(8), #3(7),
     * #2(7), #4(7), #0(8), #4(6), #2(6), #3(6), #1(7), #3(5), #2(5), #4(5),
     * #0(7), #4(4), #2(4), #3(4), #1(6), #3(3), #2(3), #4(3), #0(6), #4(2),
     * #0(5), #2(2), #3(2), #1(5), #3(1), #2(1), #0(4), #4(1), #0(3), #0(2),
     * #0(1), #0(Liftoff!), #2(Liftoff!), #3(Liftoff!), #1(4), #4(Liftoff!),
     * #1(3), #1(2), #1(1), #1(Liftoff!),
     *
     * */

}
