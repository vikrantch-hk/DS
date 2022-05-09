package producer.consumer.blocking.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class InterThreadCommunicationExample {

	public static void main(String args[]) {

		final BlockingQueue<Integer> sharedQ = new ArrayBlockingQueue<Integer>(1);

		Thread producer = new Thread(new Producer(sharedQ));
		Thread consumer = new Thread(new Consumer(sharedQ));

		producer.start();
		consumer.start();
		/*
		 * Producer Thread produced number and Consumer thread consumes it in
		 * FIFO order because blocking queue allows elements to be accessed in
		 * FIFO.
		 */

	}
}