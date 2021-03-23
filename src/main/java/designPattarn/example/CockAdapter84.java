package designPattarn.example;

/**
 * 适配器模式-对象适配
 */
public class CockAdapter84 implements Duck81 {

    private Cock82 cock82;

    public CockAdapter84(Cock82 cock82) {
        this.cock82 = cock82;
    }

    @Override
    public void quack() {
        // 鸭的呱呱叫变成了鸡的咕咕叫
        cock82.gobble();
    }

    @Override
    public void fly() {
        // 鸭的飞变成了飞鸡
        cock82.fly();
    }
}
