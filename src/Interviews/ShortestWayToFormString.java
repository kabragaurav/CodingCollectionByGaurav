/**
 * Google
 *
 * Given two strings src and dest, determine the minimum number of
 * concatenations of subsequences of src to form dest.
 */
package Interviews;

/**
 * @author gaurav kabra
 * @since 18 Dec 2021
 **/

public class ShortestWayToFormString {

    private static int shortestWay(String src, String dest) {
        int min = 0;
        String remaining = dest;

        while(remaining.length() > 0) {
            StringBuilder subseq = new StringBuilder();
            int i=0, j=0;
            while(i<src.length() && j<remaining.length()) {
                if(src.charAt(i++) == remaining.charAt(j)) {
                    subseq.append(remaining.charAt(j++));
                }
            }

            if(subseq.length() == 0) {
                return -1;
            }
            min++;
            remaining = remaining.substring(subseq.length());
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(shortestWay("abc", "abcbc"));
        System.out.println(shortestWay("lan", "allan"));
    }
}
