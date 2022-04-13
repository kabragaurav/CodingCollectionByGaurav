/*
    Observer design pattern falls under Behavioral Design Pattern.
 */
package Company.Microsoft.OOD.ObserverDesignPattern;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class MainObserver {

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        Subscriber sub1 = new Subscriber("Amit");
        Subscriber sub2 = new Subscriber("Sumit");

        Channel youTube = new Channel();
        youTube.addSubscriber(sub1);
        youTube.addSubscriber(sub2);

        youTube.publishVideo("How to be rich!");

        youTube.removeSubscriber(sub2);
        youTube.publishVideo("How to be famous!!");
    }

}
