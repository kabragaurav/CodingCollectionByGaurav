package Arrays.Utils;

/**
 * Utility class for Arrays
 *
 * @author gkabra
 * @since 04-03-2022 Fri
 **/

public class ArrayUtils {

    public static void printArray(int[] arr) {
        System.out.println("#########################");
        for(int num : arr) {
            System.out.print(num + "    ");
        }
        System.out.println("\n#########################\n");
    }

}
