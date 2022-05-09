package producer.consumer.blocking.queue;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<Integer> sharedQ;

    public Consumer(BlockingQueue<Integer> sharedQ) {
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        while(true) {
        	try {
				int i= sharedQ.take();
				System.out.println("consuming "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}