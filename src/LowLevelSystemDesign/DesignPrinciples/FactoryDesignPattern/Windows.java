package LowLevelSystemDesign.DesignPrinciples.FactoryDesignPattern;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class Windows implements OS {

    @Override
    public void printOsName() {
        System.out.println("I am Windows.");
    }

}
