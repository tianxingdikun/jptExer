package designPattarn;

import designPattarn.example.Food73;
import designPattarn.example.FoodService71;
import designPattarn.example.FoodServiceImpl72;

/**
 * 设计模式7-代理模式
 */
public class ProxyPattern implements FoodService71 {

    private FoodService71 foodService = new FoodServiceImpl72();

    @Override
    public Food73 makeChicken() {
        Food73 food73 = foodService.makeChicken();
        System.out.println("//TODO 增强功能");
        return food73;
    }

    @Override
    public Food73 makeNoodle() {
        Food73 food73 = foodService.makeNoodle();
        System.out.println("//TODO 增强功能");
        return food73;
    }
}
