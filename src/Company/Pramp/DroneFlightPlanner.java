/**
 * You’re an engineer at a disruptive drone delivery startup and your CTO asks you to come up with an
 * efficient algorithm that calculates the minimum amount of energy required for the company’s drone to
 * complete its flight. You know that the drone burns 1 kWh (kilowatt-hour is an energy unit) for every mile
 * it ascends, and it gains 1 kWh for every mile it descends. Flying sideways neither burns nor adds any energy.
 *
 * Given an array route of 3D points, implement a function calcDroneMinEnergy that computes and returns
 * the minimal amount of energy the drone would need to complete its route. Assume that the drone starts
 * its flight at the first point in route. That is, no energy was expended to place the drone at the starting
 * point.
 *
 * For simplicity, every 3D point will be represented as an integer array whose length is 3. Also, the values
 * at indexes 0, 1, and 2 represent the x, y and z coordinates in a 3D point, respectively.
 */
package Company.Pramp;

/**
 * @author gauravkabra
 * @since 20/Mar/2022
 **/

public class DroneFlightPlanner {

    // TC : O(N)
    // SC : O(1)
    private static int calcDroneMinEnergyWayTwo(int[][] route) {

        int N = route.length;
        int minEnergy = 0;
        int prevZCoord = route[0][2];
        int eneryAtThisPoint = 0;

        for (int i=1; i<N; i++) {
              int z = route[i][2];
              if (z < prevZCoord) {
                eneryAtThisPoint += (prevZCoord - z);
              } else if (z > prevZCoord) {
                if (eneryAtThisPoint < (z-prevZCoord)) {
                  minEnergy += (z-prevZCoord-eneryAtThisPoint);
                  eneryAtThisPoint = 0;
                } else {
                  eneryAtThisPoint -= (z-prevZCoord);
                }
              }
              prevZCoord = z;
        }
        return minEnergy;
    }

    // TC : O(N)
    // SC : O(1)
    private static int calcDroneMinEnergy(int[][] route) {

        int N = route.length;
        int startingEnergy = 0;

        for (int i=1; i<N; i++) {
            if (route[i][2] > route[0][2]) {
                startingEnergy = Math.max(startingEnergy, route[i][2] - route[0][2]);
            }
        }
        return startingEnergy;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        int[][] route = {
                {0,   2, 10},
                {3,   5,  0},
                {9,  20,  6},
                {10, 12, 15},
                {10, 10,  8},
                {10, 10,  16}
        };
        System.out.println(calcDroneMinEnergy(route));
        System.out.println(calcDroneMinEnergyWayTwo(route));
    }

}
