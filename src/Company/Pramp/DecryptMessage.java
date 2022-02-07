/**
 * Interview with Arun Kumar, Oracle
 *
 * Messages consist of lowercase latin letters only,
 * and every word is encrypted separately as follows:
 *
 * Convert every letter to its ASCII value. Add 1 to the first letter,
 * and then for every letter from the second one to the last one, add the value of the previous letter.
 * Subtract 26 from every letter until it is in the range of lowercase letters a-z in ASCII.
 * Convert the values back to letters.
 *
 * For instance, to encrypt the word “crime”
 *
 * Decrypted message:	c	r	i	m	e
 * Step 1:	            99	114	105	109	101
 * Step 2:	            100	214	319	428	529
 * Step 3:	            100	110	111	116	113
 * Encrypted message:	d	n	o	t	q
 *
 * Write a function named decrypt(word) that
 * receives a string that consists of small latin letters only, and returns the decrypted word.
 */
package Company.Pramp;

/**
 * @author gkabra
 * @since 06-02-2022 Sun
 **/

public class DecryptMessage {

    // TC : O(N)
    // SC : O(N) for step3[] and ans
    private static String decrypt(String word) {
        String ans = "";
        if(word.isEmpty()) {
            return ans;
        }
        // word : d	 n	o	t	q
        int[] step3 = new int[word.length()];
        int k = 0;
        for(char ch : word.toCharArray()) {
            step3[k++] = ch;              // [100 110 111 116 113]
        }

        for(int i=1; i<word.length(); i++) {
            int diff = step3[i] - step3[i-1];  // 10
            while(diff < (int) 'a') {          // bring in range 'a' to 'z'
                diff += 26;                    // 114
            }
            char next = (char) diff;           // r
            ans += next;
        }

        char first = word.charAt(0);
        if('b' <= first && first <= 'z') {         // note that 'd' in encrypted msg is just 1 greater than 'c' in decrypted msg
            ans  = "" + (char) (first-1) + ans;    // so subtract 1 to go back from 'd' to 'c'
        } else {
            ans = "z" + ans;                       // if first is 'a' then it will be 'z' in decrypted msg
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(decrypt("dnotq"));
        System.out.println(decrypt(""));
    }

}
