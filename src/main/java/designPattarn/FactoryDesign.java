package designPattarn;

import designPattarn.example.ChineseFoodFactory21;
import designPattarn.example.Food11;
import designPattarn.example.FoodFactory2;

/**
 * 设计模式2-工厂设计模式
 */
public class FactoryDesign {

    /**
     * 选择想要的工厂
     * 由选择的工厂实例化具体的对象
     * @param args
     */
    public static void main(String[] args) {
        FoodFactory2 foodFactory = new ChineseFoodFactory21();
        Food11 food = foodFactory.makeFood("a");

    }

}
