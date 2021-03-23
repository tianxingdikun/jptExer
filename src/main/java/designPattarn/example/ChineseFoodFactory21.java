package designPattarn.example;

/**
 *
 */
public class ChineseFoodFactory21 implements FoodFactory2 {
    @Override
    public Food11 makeFood(String name) {
        if ("a".equals(name)) {
            return new ChineseFoodA2();
        } else if ("b".equals(name)) {
            return new ChineseFoodB2();
        } else {
            return null;
        }
    }
}
