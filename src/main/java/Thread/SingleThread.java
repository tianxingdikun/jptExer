package Thread;

public class SingleThread {

    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        t.setName("单线程");
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(t.getName() + "执行" + i);
            } catch (Exception e) {
                System.out.println("线程出错");
            }
        }
    }

}
