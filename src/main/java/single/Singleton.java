package single;

import bo.StudentBO;

/**
 *双重校验锁实现对象单例（线程安全）
 */
public class Singleton {

    private volatile static Singleton ensureSingleton;

    public Singleton getOnlyOneObject() {
        if (ensureSingleton == null) {
            synchronized (Singleton.class) {
                if (ensureSingleton == null) {
                    ensureSingleton = new Singleton();
                }
            }
        }
        return ensureSingleton;
    }

}
