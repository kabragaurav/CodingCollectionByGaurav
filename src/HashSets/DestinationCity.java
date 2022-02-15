/**
 * You are given the array paths, where paths[i] = [cityAi, cityBi]
 * means there exists a direct path going from cityAi to cityBi. Return the destination city,
 * that is, the city without any path outgoing to another city.
 * It is guaranteed that the graph of paths forms a line without any loop, therefore,
 * there will be exactly one destination city.
 */
package HashSets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author gkabra
 * @since 15-02-2022 Tue
 **/

public class DestinationCity {

    // TC : O(N)
    // SC : O(N
    private static String destCity(List<List<String>> paths) {
        HashSet<String> cities = new HashSet<>();
        for(List<String> path : paths) {
            cities.add(path.get(1));
        }
        for(List<String> path : paths) {
            cities.remove(path.get(0));
        }
        return cities.iterator().next();
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(destCity(new ArrayList<>() {{
            add(new ArrayList<>() {{
                add("London");
                add("New York");
            }});

            add(new ArrayList<>() {{
                add("New York");
                add("Lima");
            }});

            add(new ArrayList<>() {{
                add("Lima");
                add("San Paulo");
            }});
        }}));
    }

}
