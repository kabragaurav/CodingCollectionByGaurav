/*
    Singleton Design Pattern falls under Creational Design Pattern
 */
package Company.Microsoft.OOD.SingletonDesignPattern;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class MainSingleton {

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        SingletonClass singletonClass1 = SingletonClass.getSingletonClassObject();
        SingletonClass singletonClass2 = SingletonClass.getSingletonClassObject();

        System.out.println(singletonClass1.hashCode() == singletonClass2.hashCode()
                && singletonClass1.equals(singletonClass2));
    }

}
