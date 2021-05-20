package Thread.volatilee;

/**
 * 看一下volatile的可见性
 */
public class VolatileExample {

    int a = 10;
    volatile boolean flag = false;

    public void write() {
        a = 20;
        flag = true;
    }

    public void read() {
        if (flag) {
            System.out.println("a值 " + a);
        }
    }

}
