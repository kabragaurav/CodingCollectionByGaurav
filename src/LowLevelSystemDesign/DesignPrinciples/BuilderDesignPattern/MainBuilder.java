/*
    Builder Design Pattern falls under Creational Design Pattern.

    Basically, instead of ctor, we use setters.
    This allows us to skip few properties while creating objects.
 */
package LowLevelSystemDesign.DesignPrinciples.BuilderDesignPattern;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class MainBuilder {

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        Phone phone = new Phone().setName("gaurav's iphone").setOs("ios");
        System.out.println(phone);

        phone = new Phone().setOs("Android").setName("gaurav's realme").setProcessor("qualcom");
        System.out.println(phone);
    }

}
