package Containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Collectors {

    public static void main1(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("asd");
        list.add("1234");
        list.add("njmn");
        list.add("aa");
        list.add("bb");
        Collections.nCopies(4,"asdfvdf");
        Collections.fill(list,"1234");
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

        }
    }

}
