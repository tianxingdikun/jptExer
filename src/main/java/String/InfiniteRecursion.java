package String;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
        for (int i = 0; i < 10;i++) {
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
        System.out.format("row : [%d,%f]\n",1,2.435);
    }

    public String toString() {
        return "InfiniteRecursion address: " + super.toString() + "\n";
    }

}
