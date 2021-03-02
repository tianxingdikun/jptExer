package generic;

import bo.CollegeStudentBO;
import bo.StudentBO;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    public static void main1(String[] args) {
        Generic<Integer> genericInteger = new Generic<Integer>(123);
        String[] abc = new String[]{"111", "222", "333"};
        printArray(abc);
    }

    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    static int countLegs(List<? extends StudentBO> animals) {
        int retVal = 0;
        for (StudentBO animal : animals) {
            retVal += animal.getAge();
        }
        return retVal;
    }

    static int countLegs1(List<StudentBO> animals) {
        int retVal = 0;
        for (StudentBO animal : animals) {
            retVal += animal.getAge();
        }
        return retVal;
    }

    public static void main(String[] args) {
        List<CollegeStudentBO> dogs = new ArrayList<>();
        // 不会报错
        countLegs(dogs);
        // 报错
//        countLegs1(dogs);
    }


}
