package Thread.ProducerAndConsumerModel.ActionWithBlockQueue;

import java.util.concurrent.BlockingQueue;

public class ConsumerWithBlockQueue implements Runnable {
    private BlockingQueue<GoodsWithBlock> queue;

    public ConsumerWithBlockQueue(BlockingQueue<GoodsWithBlock> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "准备消费！");
            GoodsWithBlock goods = null;
            try {
                Thread.sleep(500);
                goods = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "消费完成：" + goods);
        }
    }
}


