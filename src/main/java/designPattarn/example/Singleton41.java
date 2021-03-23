package designPattarn.example;

import java.util.Date;

/**
 * 单例模式-饿汉
 */
public class Singleton41 {

    private Singleton41() {

    }

    private static Singleton41 instandce = new Singleton41();

    public static Singleton41 getInstance() {
        return instandce;
    }

    //调用Singleton41.getDate()时，也会实例化不用的instandce
    public static Date getDate() {
        return new Date();
    }

}
