

/**
 * 观察各种内部类的用法
 */
public class OuterAndInnerClassExec {

    /*********************外部类************************************************/

    private String name = "中国";

    private final String county = "正村";

    public D getInstandceD() {
        return new D();
    }

    public void diffiCounty() {
        System.out.println("外部类的普通方法");
    }

    public void diffiAnimal() {
        int a = 10;
        D d = new D();
        System.out.println("调用成员内部类的属性 " + d.bird);

        //调用成员内部类的普通方法
        d.say();
    }

    public static void main(String[] args) {
        OuterAndInnerClassExec outerAndInnerClassExec = new OuterAndInnerClassExec();

        /**  创建成员内部类对象 */
        OuterAndInnerClassExec.D d1 = outerAndInnerClassExec.new D();
        //或
        OuterAndInnerClassExec.D d2 = outerAndInnerClassExec.getInstandceD();
    }


    /*************************局部内部类********************************************/

    public void diffiFruit() {

        //局部内部类,类似局部变量 无访问修饰符及statis
        class J {

        }

    }


    /***************************匿名内部类***********************************************/
//无构造方法 只能访问外部类的fianl属性
    public void diffiCar() {
        OuterAndInnerClassExec outerAndInnerClassExec = new OuterAndInnerClassExec();
        driveCar(new Car() {
            @Override
            public void drive() {
                System.out.println("开bba汽车");
            }
        });
    }

    interface Car {
        void drive();
    }

    public static void driveCar(Car car) {
        car.drive();
    }


    /****************************成员内部类***********************************************/

    //成员内部类 可加修饰符public private protect default
    class D {

        //内部类的属性
        private String bird = "孔雀";

        private String name = "美国";


        public void say() {
            System.out.println("内部类的普通方法");

            //调用外部类的方法
            diffiCounty();

            //成员内部类与外部类的属性相同时，调用外部类此属性用->外部类.this.属性/方法
            System.out.println("调用外部类的相同属性 " + OuterAndInnerClassExec.this.name);

            System.out.println("调用内部类自己的相同属性 " + name);
        }


    }

    /****************************静态内部类************************************/
    static class e {

    }

}
