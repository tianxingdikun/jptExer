package Thread;

public class MyThread extends Thread {

    private int ticket=10;

    public void run() {
        for(int i=0;i<=20;i++){
            if(this.ticket>0){
                System.out.println(Thread.currentThread().getName()+"正在卖票："+this.ticket--);
            }
        }
    }
}
