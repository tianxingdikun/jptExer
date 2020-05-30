package Thread.ProducerAndConsumerModel.ActionWithBlockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainInBlock {
    public static void main(String[] args) {
        BlockingQueue<GoodsWithBlock> queue = new ArrayBlockingQueue<>(3);
        Runnable produce = new ProducerWithBlock(queue);
        Runnable consumer = new ConsumerWithBlockQueue(queue);
        //生产者线程
        for (int i = 0; i < 3; i++) {
            new Thread(produce, "生产者-" + i).start();
        }


        //消费者线程
        for (int i = 0; i < 2; i++) {
            new Thread(consumer, "消费者-" + i).start();
        }
    }

}
