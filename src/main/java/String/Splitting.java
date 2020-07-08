package String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitting {

    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("1234").matcher("\\d+");
        while (matcher.find()) {
            System.out.println("1=1");
        }
    }

}
