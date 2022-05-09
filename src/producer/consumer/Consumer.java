package producer.consumer;

import java.io.Serializable;
import java.util.Queue;

public class Consumer extends Thread{
	
    private  Queue<Integer> sharedQ;

    public Consumer(Queue<Integer> sharedQ) {
        super("Consumer");
        this.sharedQ = sharedQ;
       
    }

    
	/*
	 * //When to use notify and notifyAll in Java You can use notify over
	 * notifyAll if all thread are waiting for the same condition and only one
	 * Thread at a time can benefit from condition becoming true. In this case,
	 * notify is optimized call over notifyAll because waking up all of them
	 * because we know that only one thread will benefit and all other will wait
	 * again, so calling notifyAll method is just waste of CPU cycles. Though
	 * this looks quite reasonable there is still a caveat that unintended
	 * recipient swallowing critical notification. by using notifyAll we ensure
	 * that all recipient will get notify
	 * 
	 * producing : 19
Queue is full, waiting
consuming : 19
producing : 20
Queue is full, waiting
	
	 */
    
    @Override
    public void run() {
        while(true) {
//synchronized block is reentrant in java
            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                while (sharedQ.size() == 0) {
                    try {
                        System.out.println("Queue is empty, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                sharedQ.notifyAll();
                int number = sharedQ.poll();// pops first item if its empty returns null
                System.out.println("consuming : " + number );
                
              
                //termination condition
                if(number == 19){break; }
            }
        }
    }
}