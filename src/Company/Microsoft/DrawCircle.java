/*
Given a radius of a circle, draw the circle without using floating point arithmetic.
 */
package Company.Microsoft;

/**
 * @author gaurav kabra
 * @since 07/Apr/2022
 **/

public class DrawCircle {

    private static void drawCircle(int radius) {
        int D = 2 * radius;

        for (int i=0; i<D; i++) {
            for (int j=0; j<D; j++) {
                // left most point of circle
                int x = i - radius;
                int y = j - radius;
                if (x * x + y * y <= radius * radius) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        drawCircle(8);
    }

}
