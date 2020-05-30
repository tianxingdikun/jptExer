package Thread.ProducerAndConsumerModel.ActionWithBlockQueue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class ProducerWithBlock implements Runnable {
    private BlockingQueue<GoodsWithBlock> queue;

    public ProducerWithBlock(BlockingQueue<GoodsWithBlock> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String id = UUID.randomUUID().toString();
        String name = "包子";
        Double price = new Random().nextDouble();
        GoodsWithBlock goods = new GoodsWithBlock(id, name, price);
        while (true) {
            System.out.println(Thread.currentThread().getName() + "准备生产！");
            try {
                Thread.sleep(500);
                queue.put(goods);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "生产完成：" + goods);
        }
    }
}
