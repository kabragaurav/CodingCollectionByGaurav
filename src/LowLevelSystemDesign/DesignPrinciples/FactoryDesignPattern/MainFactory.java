/*
    Factory Design Pattern falls in Creational Design Patterns category.
 */

package LowLevelSystemDesign.DesignPrinciples.FactoryDesignPattern;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class MainFactory {

    // driver - main method
    public static void main(String[] args) {
        OS os = Factory.getOs("mac");
        os.printOsName();

        os = Factory.getOs("windows");
        os.printOsName();
    }

}
