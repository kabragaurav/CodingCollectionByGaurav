/*
    MacCharger design pattern falls in Structural Design Pattern.
 */
package LowLevelSystemDesign.DesignPrinciples.AdapterDesignPattern;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class MainAdapter {

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        MacBook macAir = new MacBook();
        macAir.chargeMacbook(new WindowsCharger());
    }

}
