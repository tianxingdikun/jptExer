package designPattarn;

import designPattarn.example.Singleton41;
import designPattarn.example.Singleton42;
import designPattarn.example.Singleton43;

/**
 * 设计模式4-单例模式模式
 */
public class Singleton {

    public static void main(String[] args) {
        //恶汉
        Singleton41 singleton41 = Singleton41.getInstance();

        //饱汉
        Singleton42 singleton42 = Singleton42.getInstance();

        Singleton43 singleton43 = Singleton43.getInstance();
    }



}
