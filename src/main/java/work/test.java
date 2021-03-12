package work;

import bo.CollegeStudentBO;
import bo.StudentBO;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class test {

    public static void main1(String[] args) {
        String a = "T_DF_INC_MAPPING_95_FLOW_JOB_1_RECEIVE_F_95_TJJC095_XRS_XRS_APPLY_DICT_REL_T";
        String str1 = a.substring(0, a.indexOf("RECEIVE"));
        System.out.println(str1);
        String str2 = a.substring(str1.length() + 8);
        System.out.println(str2);
    }

    public static void main3(String[] args) {
        String a = "F_1_DH_CJ_DATA_TOPIC_INFO_CAIBAO_QIYEJJ";
        System.out.println(a.toLowerCase());
    }

    public static void main2(String[] args) {
        String a = "asd|fe|vf||vv|o";
        String[] str = a.split("\\|");
        System.out.println(str[0]);
        System.out.println(str[1]);
        System.out.println(str[2]);
        System.out.println(str[3]);
        System.out.println(str[4]);
        System.out.println(str[5]);
    }

    public static void main4(String[] args) {
        //for循环实现
        int x = 0;
        for (; x < 10; x++) {
            System.out.println("x爱Java");
        }
        //这里不能在继续访问了
        System.out.println(x);

        //while循环实现
        int y = 0;
        while (y < 10) {
            System.out.println("y爱Java");
            y++;
        }
        //这里是可以继续访问的
        System.out.println(y);
    }

    public static void main5(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();

        list.add(12);
        //这里直接添加会报错
        // list.add("汉字");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        //但是通过反射添加，是可以的
        add.invoke(list, "汉字");

        System.out.println(list);

    }

    public static void main6(String[] args) {
        StudentBO studentBO = new CollegeStudentBO();
        Class stuClass = StudentBO.class;
        if(Objects.equals(null,"")){

        }
        List<Integer> integers = new ArrayList<>();
        integers.removeIf(o -> o % 2 == 0);
    }

    public void testimport() {

    }

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("thread name").setDaemon(true).build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,1l,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(),threadFactory
        );
    }



}
