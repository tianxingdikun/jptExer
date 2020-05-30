package Thread.jpt212;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CallableDemo {

    /**
     * 类型参数
     * 实现Callable接口，可以通过executor.submit()方法调用它来得到返回值
     *
     * */
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results =
                new ArrayList<Future<String>>();
        for(int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
            System.out.println("1=1");
        }
        for(Future<String> fs : results)
            try {
                // get() blocks until completion:
                System.out.println(fs.get());
            } catch(InterruptedException e) {
                System.out.println(e);
                return;
            } catch(ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
    }

}

class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }
    public String call() {
        return "result of TaskWithResult " + id;
    }
}


/**
 * 1=1
 * 1=1
 * 1=1
 * 1=1
 * 1=1
 * 1=1
 * 1=1
 * 1=1
 * 1=1
 * 1=1
 * result of TaskWithResult 0
 * result of TaskWithResult 1
 * result of TaskWithResult 2
 * result of TaskWithResult 3
 * result of TaskWithResult 4
 * result of TaskWithResult 5
 * result of TaskWithResult 6
 * result of TaskWithResult 7
 * result of TaskWithResult 8
 * result of TaskWithResult 9
 *
 * */