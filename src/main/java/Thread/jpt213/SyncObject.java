package Thread.jpt213;

public class SyncObject {
    /**
     * 两个线程同时进入一个对象，该对象里的方法在不同的锁上同步。
     * */
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread() {
            public void run() {
                ds.f();
            }
        }.start();
        ds.g();
    }

    static class DualSynch {
        private Object syncObject = new Object();
        public synchronized void f() {
            for(int i = 0; i < 5; i++) {
                System.out.println("f()");
                Thread.yield();
            }
        }
        public void g() {
            synchronized(syncObject) {
                for(int i = 0; i < 5; i++) {
                    System.out.println("g()");
                    Thread.yield();
                }
            }
        }
    }
}
