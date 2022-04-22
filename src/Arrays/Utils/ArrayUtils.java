package Arrays.Utils;

/**
 * Utility class for Arrays
 *
 * @author gkabra
 * @since 04-03-2022 Fri
 **/

public class ArrayUtils {

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + "    ");
        }
        System.out.println();
    }

    /**
     * Prints arr when condition is satisfied (i.e. true)
     *
     * If arr is printed, returns true.
     * Else returns false.
     */
    public static boolean printArrayOnCondition(int[] arr, boolean condition) {
        if (!condition) {
            return false;
        }
        for (int num : arr) {
            System.out.print(num + "    ");
        }
        System.out.println();
        return true;
    }

    public static void printArray(char[] arr) {
        for (char ch : arr) {
            System.out.print(ch + "    ");
        }
        System.out.println();
    }

    public static void printArray(double[] arr) {
        for (double num : arr) {
            System.out.print(num + "    ");
        }
        System.out.println();
    }

    public static void printArray(int[][] nums) {
        for (int[] num : nums) {
            printArray(num);
        }
    }

    public static void printArray(char[][] chrs) {
        for (char[] ch : chrs) {
            printArray(ch);
        }
    }

    public static void printArray(double[][] nums) {
        for (double[] num : nums) {
            printArray(num);
        }
    }

}
