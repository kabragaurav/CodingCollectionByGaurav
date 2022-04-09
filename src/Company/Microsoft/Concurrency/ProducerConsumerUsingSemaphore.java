package Company.Microsoft.Concurrency;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * @author gaurav kabra
 * @since 10/Apr/2022
 **/

public class ProducerConsumerUsingSemaphore {

    static class ProducerConsumer {
        private Queue<Integer> queue = new ArrayDeque<>();
        private final int CAPACITY = 2;
        private static Semaphore semConsumer = new Semaphore(0);
        private static Semaphore semProducer = new Semaphore(1);

        void producer() throws InterruptedException {
            int val = 0;
            while (true) {
                try {
                    semProducer.acquire();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println("Producer : " + val);
                queue.add(val++);
                semConsumer.release();
                Thread.sleep(1000);
            }
        }

        void consumer() throws InterruptedException {
            while (true) {
                try {
                    semConsumer.acquire();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println("Consumer : " + queue.poll());
                semProducer.release();
                Thread.sleep(1000);
            }
        }

    }


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
