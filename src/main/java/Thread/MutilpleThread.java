package Thread;


public class MutilpleThread {

    public static void main(String[] args) {
        Thread t1 = new ThreadTest("t1",2);
        Thread t2 = new ThreadTest("t2",3);
        Thread t3 = new ThreadTest("t3",5);
        t1.start();
        t2.start();
        t3.start();

        t1.run();
    }

    public static void main2(String[] args) {
        //资源共享
        MyThread mt=new MyThread();
        new Thread(mt, "1号窗口").start();
        new Thread(mt, "2号窗口").start();
        new Thread(mt, "3号窗口").start();

    }

}
