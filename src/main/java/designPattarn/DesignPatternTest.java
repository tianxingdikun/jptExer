package designPattarn;

import designPattarn.example.FoodService71;

public class DesignPatternTest {

    /**
     * 代理模式
     * @param args
     */
    public static void main(String[] args) {
        FoodService71 foodService71 = new ProxyPattern();
        foodService71.makeChicken();
    }

}
