package Company.Microsoft.Concurrency;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author gaurav kabra
 * @since 10/Apr/2022
 **/

class ProducerConsumer {
    private Queue<Integer> queue = new ArrayDeque<>();
    private final int CAPACITY = 2;

    void producer() throws InterruptedException {
        int val = 0;
        while (true) {
            // create critical section.
            // No more than one thread will be able to access the code inside this block.
            // Needed for notify() and wait() methods to work
            synchronized (this) {
                /*
                    synchronized( lockObject )
                    {
                      while( ! condition )
                      {
                        lockObject.wait();
                      }

                      //take the action here;
                    }
                 */
                while (queue.size() == CAPACITY) {
                    wait();     // go to sleep by releasing the lock
                }
                System.out.println("Producer : " + val);
                queue.add(val++);
                // notifyAll() then mostly thread with most priority runs. Else one which has all resources runs
                notify();       // wake up a single thread that called wait() on same obj. Lock is not given though until synchronized block is executed
                Thread.sleep(1000);         // so that output screen is not filled immediately with all dumps
            }
        }
    }

    void consumer() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.size() == 0) {
                    wait();
                }
                System.out.println("Consumer : " + queue.poll());
                notify();
                Thread.sleep(1000);
            }
        }
    }

}

/*
    InterruptionException
        - An interrupt is an indication to a thread that it should stop what it is doing and do something else.
        - Eg. while sleeping or waiting and interrupt using Thread.interrupt() in main method

 */
public class ProducerConsumerUsingInterThreadComm extends Thread {

    // driver - main method
    public static void main(String[] args) throws InterruptedException {
        // TESTCASE(S)
        ProducerConsumer pc = new ProducerConsumer();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
