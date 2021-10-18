/**
 * Facebook
 * Given a string and the ability to delete at most one character,
 * return whether or not it can form a palindrome.
 */
package GreedyAndTwoPointer;

public class ValidPalindromeWithRemoval {
    private static boolean validPalindrome(String s) {
        /**
         * Logic:
         * We use 2-pointers, left=start index and right=last index.
         * When the charcters at left and right are equal, that means there is no need to remove any char. So we increase left and decrese right.
         * Else, we need to delete a char. We can either delete char at left or char at right.
         * We remove at the indices and see if in any case, we are able to get palindrome.
         * Since we can remove at most one char, so we return from there only.
         *
         * Time Complexity : O(N) due to complete traversal in worst case.
         * Space Complexity : O(N) since in non-palindrome case we use string builder variables.
         */
        int left = 0, right = s.length()-1;
        while(left <= right) {
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                StringBuilder leftRemoved = new StringBuilder(s.substring(0, left) + s.substring(left+1));
                StringBuilder rightRemoved = new StringBuilder(s.substring(0, right) + s.substring(right+1));
                // We need to convert StringBuilder to String because equals() method is override in String class
                // to compare content. In StringBuilder, equals() still compares references!
                // See this: https://tinyurl.com/string-builder-equals
                return leftRemoved.toString().equals(leftRemoved.reverse().toString()) ||
                        rightRemoved.toString().equals(rightRemoved.reverse().toString());
            }
        }
        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abc"));
    }
}
