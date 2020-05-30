package Thread.ProducerAndConsumerModel.ActionWithSyncQueue;

import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<Goods> queue;

    public Consumer(Queue<Goods> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.queue) {
                if (this.queue.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + "容器已空，开始生产");
                    this.queue.notifyAll();
                } else {
                    Goods goods = this.queue.poll();
                    System.out.println(Thread.currentThread().getName() + "消费了一个" + goods);
                }
            }
        }
    }
}

