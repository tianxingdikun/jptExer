package Thread;

public class ThreadTest extends Thread {

    private String name;
    private int ts;

    public ThreadTest(String name,int ts) {
        this.name = name;
        this.ts = ts;
    }

    public void run() {
        try {
            sleep(ts);
            for (int i = 1; i <= ts; i++) {
                System.out.println(name + "执行" + i);
            }
        } catch (Exception e) {
            System.out.println("线程运行中断");
        }

        System.out.println("名字叫" + name + "休眠" + ts);
    }

}
