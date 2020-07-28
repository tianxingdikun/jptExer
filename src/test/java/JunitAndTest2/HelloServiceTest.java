package JunitAndTest2;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

//@SpringBootTest
//@SpringBootTest(classes = Application.class)
// 在启动类启动的时候也启动了这个类，所以也要引入进来
//@Import(ApplicationStartup.class)
// 不执行项目里Component注解过的方法
//@TestComponent

// 注意点一：保留了RunWith注解
//@RunWith()
public class HelloServiceTest {

    //@Autowired
    // 不使用Autowired，不启动Spring容器，对需要实现的方法实现类直接new进行实例化
    private HelloService helloService = new HelloService();


    /*@Test
    public void sayHello() {
        // 模拟JPA的EntityManager,官方的接口、类都要模拟
        EntityManager em =  init(helloService);

        // any()代替任意类型的参数
        Mockito.doReturn("我是模拟的返回值").when(em).findById("1");
        // 没有返回值的方法，可以不另外写，因为模拟实体类的时候已经自动模拟了
        Mockito.doNothing().when(em).find(any());

        helloService.sayHello("zhangsan");
        Assert.isTrue(true,"完全正确的单元测试");
    }


    EntityManager init(Object classInstance ){
        // 要模拟的类
        EntityManager em = Mockito.mock(EntityManager.class);
        // 指定反射类
        Class<?> clazz = classInstance.getClass();
        // 获得指定类的属性
        Field field = null;
        try {
            field = clazz.getDeclaredField("em");
            // 值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。
            // 值为 false 则指示反射的对象应该实施 Java 语言访问检查。
            // 默认 false
            field.setAccessible(true);
            // 更改私有属性的值
            field.set(classInstance, em);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return em;
    }*/

    @Before
    public void setup() {
        SparkConf conf = new SparkConf();
        conf.setMaster("local[3]").setAppName("jsonRDD");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);
        JavaRDD<String> nameRDD = sc.parallelize(Arrays.asList(
                "{\"name\":\"zhangsan\",\"age\":\"18\"}",
                "{\"name\":\"lisi\",\"age\":\"19\"}",
                "{\"name\":\"wangwu\",\"age\":\"20\"}"
        ));
        System.out.println(sqlContext.getClass().getClassLoader());
        Dataset<Row> dataset = sqlContext.read().json(nameRDD);
        dataset.show();
    }

    @Test
    public void testa() {
        System.out.println("11");
    }

}
