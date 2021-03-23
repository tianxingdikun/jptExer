package designPattarn.example;

/**
 *单例的嵌套类
 */
public class Singleton43 {

    private Singleton43() {}

    public static class Holder {
        private static Singleton43 instance = new Singleton43();
    }

    public static Singleton43 getInstance() {
        return Holder.instance;
    }

}
