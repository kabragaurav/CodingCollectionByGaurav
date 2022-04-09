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
            synchronized (this) { // no more than one thread will be able to access the code inside this block. Needed for notify() and wait() methods to work
                while (queue.size() == CAPACITY) {
                    wait();
                }
                System.out.println("Producer : " + val);
                queue.add(val++);
                notify();
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
