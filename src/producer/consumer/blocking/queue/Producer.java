package producer.consumer.blocking.queue;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<Integer> sharedQ;

    public Producer(BlockingQueue<Integer> sharedQ) {
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            try {
            	
				sharedQ.put(i);
				System.out.println("producing "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}