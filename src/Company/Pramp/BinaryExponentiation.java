package Company.Pramp;

/**
 * @author gkabra
 * @since 26-01-2022 Wed
 **/

public class BinaryExponentiation {

    private static double power(double x, int n) {
        if(n == 0) {
            return 1;
        }
        double p = power(x, n/2);
        if(n%2 == 0) {
            p = p*p;
        } else {
            p = p*p*x;
        }
        return p;
    }

    // TC: O(logN) as each time we divide n by 2
    // SC: O(1) explicitly and O(logN) internally due to recursion stack
    private static double myPow(double x, int n) {
        if(x == 0) {
            return 0;
        }
        double power = power(x, Math.abs(n));
        if(n < 0) {
            power = 1/power;
        }
        return power;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(myPow(2, -2));
        System.out.println(myPow(0, -9));
    }

}
