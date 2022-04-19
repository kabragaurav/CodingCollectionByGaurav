/**
 * You are given a stream of records about a particular stock.
 * Each record contains a timestamp and the corresponding price of the stock at
 * that timestamp.
 *
 * Unfortunately due to the volatile nature of the stock market,
 * the records do not come in order. Even worse, some records may be incorrect.
 * Another record with the same timestamp may appear later in the stream correcting
 * the price of the previous wrong record.
 *
 * Design an algorithm that:
 *
 *  Updates the price of the stock at a particular timestamp,
 *  correcting the price from any previous records at the timestamp.
 *
 *  Finds the latest price of the stock based on the current records.
 *  The latest price is the price at the latest timestamp recorded.
 *
 *  Finds the maximum price the stock has been based on the current records.
 *
 *  Finds the minimum price the stock has been based on the current records.
 */
package Map;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author gkabra
 * @since 19-02-2022 Sat
 **/

public class StockPriceFluctuations {

    private static HashMap<Integer, Integer> priceAtTime;
    private static  int latestTime;
    private static  TreeMap<Integer, Integer> priceFreq;

    // TC : O(N)
    // SC : O(N)
    private static void update(int timestamp, int price) {
        Integer oldPrice = priceAtTime.get(timestamp);
        remove(oldPrice);
        priceFreq.put(price, priceFreq.getOrDefault(price, 0) + 1);

        priceAtTime.put(timestamp, price);
        latestTime = Math.max(latestTime, timestamp);
    }

    private static void remove(Integer oldPrice) {
        if(oldPrice == null) {
            return;
        }
        if(priceFreq.get(oldPrice) == 1) {
            priceFreq.remove(oldPrice);
        } else {
            priceFreq.put(oldPrice, priceFreq.get(oldPrice) - 1);
        }
    }

    private static int current() {
        return priceAtTime.get(latestTime);
    }

    private static int maximum() {
        return priceFreq.lastKey();
    }

    private static int minimum() {
        return priceFreq.firstKey();
    }

    // driver - main method
    public static void main(String[] args) {
        priceAtTime = new HashMap<>();
        priceFreq = new TreeMap<>();

        // TESTCASE
        update(1, 10);
        update(2, 5);
        System.out.println(current());
        System.out.println(maximum());
        update(1,3);
        System.out.println(maximum());
        update(4, 2);
        System.out.println(minimum());
    }

}
