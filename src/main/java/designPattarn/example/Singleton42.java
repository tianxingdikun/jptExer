package designPattarn.example;

/**
 * 单例模式-饱汉
 */
public class Singleton42 {

    private Singleton42() {}

    private static volatile Singleton42 instance = null;

    //双重检查
    public static Singleton42 getInstance() {
        if (instance == null) {
            synchronized (Singleton42.class) {
                if (instance == null) {
                    instance = new Singleton42();
                }
            }
        }
        return instance;
    }


}
