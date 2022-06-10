package LowLevelSystemDesign.DesignPrinciples.FactoryDesignPattern;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class Factory {

    public static OS getOs(String osName) {
        switch (osName) {
            case "mac":
                return new MacOS();
            case "windows":
                return new Windows();
            default:
                return null;
        }
    }

}
