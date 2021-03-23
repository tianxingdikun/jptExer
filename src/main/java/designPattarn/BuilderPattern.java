package designPattarn;

import designPattarn.example.User5;

/**
 * 设计模式5-建造者模式
 */
public class BuilderPattern {

    /**
     * 建造者模式  是一种链式写法
     * @param args
     */
    public static void main(String[] args) {
        User5 user = User5.builder().age(90).name("").nickName("").password("").build();
    }

}
