package Company.Microsoft.Concurrency;

/**
 * @author gaurav kabra
 * @since 10/Apr/2022
 *
 * How to avoid deadlocks in Java
 *      - Deadlocks in Java threads can be minimized by avoiding nested locks.
 *      - Also lock only those resources that are used and shared across multiple threads.
 **/

public class CreateDeadlock {

    private static final String R1 = "RESOURCE1";
    private static final String R2 = "RESOURCE2";

    // driver - main method
    public static void main(String[] args) throws InterruptedException {
        // TESTCASE(S)
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (R1) {
                    try {
                        System.out.println("Sleeping t1 after R1");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (R2) {
                        System.out.println("t1 got R2");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (R2) {
                    try {
                        System.out.println("Sleeping t2 after R2");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (R1) {
                        System.out.println("t2 got R1");
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
