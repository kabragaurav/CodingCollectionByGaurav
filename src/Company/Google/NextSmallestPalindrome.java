/*
For a given positive integer K of not more than 1000000 digits, write the
value of the smallest palindrome larger than K to output. Numbers are always displayed without leading zeros.
 */
package Company.Google;

import Arrays.Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gaurav kabra
 * @since 22/Apr/2022
 **/

public class NextSmallestPalindrome {

    private static List<Integer> ls;

    // TC : O(N)
    // SC : O(N)
    // https://tinyurl.com/next-smallest-palindrome
    private static void generateNextPalindrome(int[] num) {
        // if all 9's
        int N = num.length;
        if (9 * N == Arrays.stream(num).sum()) {
            ls.add(1);
            for (int i=0; i<N-1; i++) {
                ls.add(0);
            }
            ls.add(1);
            return;
        }

        // else
        int mid = N / 2;
        int left = mid - 1;
        int right = (N % 2 == 0 ? mid : mid+1);

        // skip same digits at left and right
        while (left >= 0 && num[left] == num[right]) {
            left--;
            right++;
        }

        boolean isLeftSmaller = false;
        if (left < 0 || num[left] < num[right]) {
            isLeftSmaller = true;
        }

        // now mirror from left to right by copying
        while (left >= 0) {
            num[right++] = num[left--];
        }

        if (isLeftSmaller) {
            int carry = 1;
            // if odd length arr, then add 1 to mid
            if (N % 2 == 1) {
                num[mid] += 1;
                if (num[mid] > 9) {
                    carry = 1;
                    num[mid] -= 10;
                } else {
                    carry = 0;
                }
            }
            // reset left and right
            left = mid - 1;
            right = (N % 2 == 0 ? mid : mid+1);

            // and propagate adding 1 to MSB
            while (left >= 0 && carry == 1) {
                num[left] += carry;
                if (num[left] > 9) {
                    carry = 1;
                    num[left] -= 10;
                } else {
                    carry = 0;
                }
                // plus keep mirroring
                num[right++] = num[left--];
            }
        }
    }


    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        ls = new ArrayList<>();

        int[][] nums = new int[][] {
                {9,4,1,8,7,9,7,8,3,2,2},
                {9, 9, 9},
                {2,3,5,4,5},
                {1,2,3,4},
                {1,2,2,1},
                {7,8,3,3,2,2},
                {1,2,5,3,2,2},
                {1,4,5,8,7,6,7,8,3,2,2}
        };

        for (int [] num : nums) {
            ls.clear();
            generateNextPalindrome(num);
            if (!ArrayUtils.printArrayOnCondition(num, ls.size() == 0)) {
                System.out.println(ls);
            }
        }
    }

}
