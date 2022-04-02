package Arrays.Utils;

/**
 * Utility class for Arrays
 *
 * @author gkabra
 * @since 04-03-2022 Fri
 **/

public class ArrayUtils {

    public static void printArray(int[] arr) {
        for(int num : arr) {
            System.out.print(num + "    ");
        }
        System.out.println();
    }

    public static void printArray(char[] arr) {
        for(char ch : arr) {
            System.out.print(ch + "    ");
        }
        System.out.println();
    }

    public static void printArray(int[][] nums) {
        for(int[] num : nums) {
            printArray(num);
        }
    }

}
