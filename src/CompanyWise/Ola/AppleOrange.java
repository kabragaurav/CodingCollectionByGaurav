/**
 * Let A stands for Apple and O for Orange.
 * We have an array of apples and oranges.
 * We have M spells. Each spell allows us to convert an orange into apple.
 * Find the length of longest sequence of apples we can make.
 *
 * Note - Oranges may be replaced by pits and Apples with road, to tweak language.
 *
 * Video - https://tinyurl.com/ola-samples
 */
package CompanyWise.Ola;

/**
 * @author gaurav kabra
 * @since 28 Sept 2021
 **/

public class AppleOrange {

    private static int appleSequence(String fruits, int M){
        /**
         * Logic:
         * We first create an array, orangesSoFar.
         * Any index in it will have number of oranges so far in fruits string.
         */
        int N = fruits.length();
        int[] orangesSoFar = new int[N];
        char[] fruitArr = fruits.toCharArray();
        orangesSoFar[0] = fruitArr[0] == 'O' ? 1 : 0;
        // prefix sum method
        for(int i=1; i<N; i++) {
            orangesSoFar[i] = fruitArr[i] == 'O' ? orangesSoFar[i-1]+1 : orangesSoFar[i-1];
        }

        int maxLen = 0, j = 0, c = 0;  // c will have value of orangesSoFar[i]
        for(int i=0; i<N; i++) {
            for(; j<N; j++) {
                if(orangesSoFar[j] > c+M) {
                    break;
                }
            }
            if(j == N-1 && orangesSoFar[j] <= c+M) {   // Say M=10, fruits="AOOAO"
                j++;
            }
            maxLen = Math.max(maxLen, j-i);
            c = orangesSoFar[i];
        }
        return maxLen;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(appleSequence("AOOAO", 1));
    }
}
