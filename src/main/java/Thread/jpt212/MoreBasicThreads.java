package Thread.jpt212;

public class MoreBasicThreads {

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++)
            new Thread(new LiftOff()).start();
        System.out.println("Waiting for LiftOff");
    }

    /**
     *
     * Waiting for LiftOff
     * #4(9), #3(9), #3(8), #2(9), #2(8), #1(9), #1(8), #0(9), #1(7), #1(6),
     * #1(5), #1(4), #1(3), #2(7), #2(6), #3(7), #4(8), #4(7), #3(6), #3(5),
     * #2(5), #2(4), #1(2), #0(8), #0(7), #0(6), #1(1), #1(Liftoff!), #2(3),
     * #3(4), #4(6), #4(5), #3(3), #2(2), #2(1), #2(Liftoff!), #0(5), #3(2),
     * #3(1), #3(Liftoff!), #4(4), #0(4), #4(3), #0(3), #0(2), #0(1), #0(Liftoff!),
     * #4(2), #4(1), #4(Liftoff!),
     * */

}
