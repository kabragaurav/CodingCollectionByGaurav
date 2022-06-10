package LowLevelSystemDesign.DesignPrinciples.SingletonDesignPattern;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class SingletonClass {

    private static SingletonClass singletonClass;

    private SingletonClass() {

    }

    public static SingletonClass getSingletonClassObject() {
        if (singletonClass == null) {
            singletonClass = new SingletonClass();
        }
        return singletonClass;
    }

}
