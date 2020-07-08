package String;

public class Concatenation {

    public static void main(String[] args) {
        /*String mango = "mango";
        String s = "abc" + mango + "def" + 47;
        System.out.println(s);*/


        String readyAllColumns = "D.d,B.*,A.a,E.e,E.ee";
        String childColumns = "B.b,B.c";
        String regex = "B.\\*";
        String finalColumns = readyAllColumns.replaceAll(regex, childColumns);
        System.out.println(finalColumns);

    }
}
