
package Company.Pramp;

import Arrays.Utils.ArrayUtils;

/**
 * @author gaurav kabra
 * @since 02/Apr/2022
 **/

public class SentenceReverse {

    private static char[] reverseWords(char[] arr) {
        int N = arr.length;

        int l = 0;
        int m = N-1;
        reverse(arr, l, m);

        int prevIndex = -1;

        for (int i=0; i<N; i++) {
            if (arr[i] == ' ') {
                int j = prevIndex + 1;
                int k = i-1;
                reverse(arr, j, k);
                prevIndex = i;
            }
        }
        reverse(arr, prevIndex+1, N-1);
        return arr;
    }

    private static void reverse(char[] arr, int i, int j) {
        while (i <= j) {
            char ch = arr[i];
            arr[i++] = arr[j];
            arr[j--] = ch;
        }
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        ArrayUtils.printArray(reverseWords(new char[] {' ', ' '}));
        ArrayUtils.printArray(reverseWords(new char[] { }));
        ArrayUtils.printArray(reverseWords(new char[] {'a'}));
        ArrayUtils.printArray(reverseWords(new char[] {'a', ' ', 'b', 'c'}));
        ArrayUtils.printArray(reverseWords(new char[] {'a', ' ', 'b', 'c', ' '}));
    }

}
