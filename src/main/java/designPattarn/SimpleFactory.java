package designPattarn;

import designPattarn.example.Food11;
import designPattarn.example.HuangMenChicken12;
import designPattarn.example.LanZhouNoodle12;

/**
 * 设计模式1-简单工厂模式
 */
public class SimpleFactory {

    /**
     * 根据不同的参数，返回不同的派生自同一个父类（或实现同一接口）的实例对象。
     * @param name
     * @return
     */
    public static Food11 makeFood(String name) {
        if ("noodles".equals(name)) {
            Food11 noodle = new LanZhouNoodle12();
            noodle.addSpicy("lanzhou");
            return noodle;
        } else if ("chicken".equals(name)) {
            Food11 chicken = new HuangMenChicken12();
            chicken.addCondiment("huangmen");
            return chicken;
        } else {
            return null;
        }
    }

}
