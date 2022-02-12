/**
 * The multiplication table of size m x n is
 * an integer matrix mat where mat[i][j] == i * j (1-indexed).
 * Given three integers m, n, and k, return the kth smallest element in the m x n
 * multiplication table.
 */
package Miscellaneous.UniqueConcepts.BinarySearch;

/**
 * @author gkabra
 * @since 12-02-2022 Sat
 **/

public class KthSmallestMultiplicationTable {

    private static int count(int mid, int m, int n) {
        int count = 0;
        for(int i=1; i<=m; i++) {
            count += Math.min(mid/i, n);
        }
        return count;
    }

    /**
     * This is a typical question,
     * see https://tinyurl.com/kth-smallest-multiply-table
     * for easy explanation.
     *
     * Also see : KthSmallestInSortedMatrix.java file
     *
     * TC : log(m*n) for mid calculations so O(log(m*n) * m)
     * SC : O(1)
     */
    private static int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m*n;

        while(left < right) {
            int mid = left + (right-left)/2;
            int numbersLessThanOrEqualToMid = count(mid, m, n);
            if(numbersLessThanOrEqualToMid >= k) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(findKthNumber(3,3,5));
    }

}
