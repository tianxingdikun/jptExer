package designPattarn;

import designPattarn.example.Cock82;
import designPattarn.example.CockAdapter84;
import designPattarn.example.Duck81;
import designPattarn.example.WildCock83;

/**
 * 设计模式8-适配器模式
 */
public class AdapterPattern {

    public static void main(String[] args) {
        Cock82 cock = new WildCock83(); //实例化鸡
        Duck81 duck81 = new CockAdapter84(cock);//使用适配器，表面上初始化鸭，方法却是鸡的方法
    }

}
