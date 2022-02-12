/**
 * DE Shaw
 *
 * Given a string of lowercase alphabets, count all possible substrings
 * (not necessarily distinct) that have exactly k distinct characters.
 */
package Miscellaneous.UniqueConcepts.HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Amazing video here : https://tinyurl.com/cnt-str-k-distinct-char
 *
 * @author gkabra
 * @since 11-02-2022 Fri
 **/

public class CountSubstringsWithExactlyKDistinctChars {

    // TC : O(N^2)
    // SC : O(N)
    private static int countSubstrKDistinctChars2(String S, int K) {
        HashSet<Character> st = new HashSet<>();
        int N = S.length();
        int ans = 0;

        for(int i=0; i<N; i++) {
            st.clear();
            for(int j=i; j<N; j++) {
                char ch = S.charAt(j);
                st.add(ch);
                if(st.size() == K) {
                    ans++;
                } else if(st.size() > K) {
                    break;
                }
            }
        }

        return ans;
    }

    private static void remove(Map<Character, Integer> mp, char ch) {
        if(mp.get(ch) == 1) {
            mp.remove(ch);
        } else {
            mp.put(ch, mp.get(ch)-1);
        }
    }

    private static int solutionForOne(String str) {
        int ans = 1;
        int count = 1;
        for(int i=1; i<str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            if(prev == curr) {
                count++;
                ans += count;
            } else {
                ans++;
                count = 1;
            }
        }
        return ans;
    }

    // TC : O(N)
    // SC : O(N)
    private static long countSubstrKDistinctChars(String S, int K) {
        if(K == 1) {
            return solutionForOne(S);
        }
        long ans = 0;
        Map<Character, Integer> big = new HashMap<>();     // will store K elements
        Map<Character, Integer> small = new HashMap<>();   // will store K-1 elements

        int i = -1;     // acquiring big
        int j = -1;     // acquiring small
        int k = -1;     // releasing from both

        while(true) {
            // just to know when to break out from loop
            boolean b1 = false;
            boolean b2 = false;
            boolean b3 = false;

            // first big starts acquiring
            while(i < S.length()-1) {
                b1 = true;
                i++;
                char ch = S.charAt(i);
                big.put(ch, big.getOrDefault(ch, 0)+1);
                if(big.size() > K) {
                    remove(big, ch);
                    i--;
                    break;
                }
            }

            while(j < i) {
                b2 = true;
                j++;
                char ch = S.charAt(j);
                small.put(ch, small.getOrDefault(ch, 0)+1);
                if(small.size() > K-1) {
                    remove(small, ch);
                    j--;
                    break;
                }
            }

            // now big.size() = K
            // now small.size() == K-1

            while(k < j) {
                b3 = true;
                if(big.size() == K && small.size() == K-1) {
                    ans += (i-j);
                }
                k++;
                char ch = S.charAt(k);
                remove(small, ch);
                remove(big, ch);
                if(big.size() < K || small.size() < K-1) {
                    break;
                }
            }

            if(b1 == false && b2 == false && b3 == false) {
                break;
            }
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(countSubstrKDistinctChars("aba",2));
        System.out.println(countSubstrKDistinctChars("aabcbcdbca", 2));

        System.out.println(countSubstrKDistinctChars2("aba",2));
        System.out.println(countSubstrKDistinctChars2("aabcbcdbca", 2));
    }

}
