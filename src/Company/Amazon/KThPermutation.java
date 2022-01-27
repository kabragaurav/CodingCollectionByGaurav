package Company.Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gkabra
 * @since 27-01-2022 Thu
 **/

public class KThPermutation {

    /**
     * Logic:
     *      https://tinyurl.com/kth-permutation
     */
    private static String getPermutation(int n, int k) {
        int NMinus1Factorial = 1;   // how many permutations
        List<Integer> nums = new ArrayList<>();  // stores [1,n]

        for(int i=1; i<n; i++) {
            NMinus1Factorial *= i;
            nums.add(i);
        }
        nums.add(n);
        String ans = "";
        // 0 based indexing
        k = k-1;
        while(true) {
            ans += nums.get(k/NMinus1Factorial);
            nums.remove(k/NMinus1Factorial);
            if(nums.isEmpty()) {
                break;
            }
            k %= NMinus1Factorial;                      // update k
            NMinus1Factorial /= nums.size();            // update NMinus1Factorial
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(getPermutation(4, 17));
    }

}
