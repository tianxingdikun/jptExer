package Thread;

public class RunnableImpl {

    public static void main(String[] args) {
        RunnableTest r1= new RunnableTest();
        Thread t=new Thread(r1);
        t.start();
    }

    /**
     * 线程状态：
     * 1、创建     new Thread()
     * 2、就绪     执行thread.start()
     * 3、运行     start方法内调用自建类的run()方法（实现runnable接口时重写的run方法），
     * 4、阻塞     在上步运行的过程中调用了thread里面的sleep,wait,suspend方法
     * 5、死亡     run方法运行完毕或者调用stop方法
     *
     *
     *
     *
     *
     * */
    public static void main1(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread,"张三");
        Thread thread2 = new Thread(myThread,"李四");
        Thread thread3 = new Thread(myThread,"王五");
        thread1.start();
        thread2.start();
        thread3.start();
    }



}
