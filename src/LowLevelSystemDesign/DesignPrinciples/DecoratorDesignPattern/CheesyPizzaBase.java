package LowLevelSystemDesign.DesignPrinciples.DecoratorDesignPattern;

/**
 * @author gaurav kabra
 * @since 10/Jun/2022
 **/

public class CheesyPizzaBase implements PizzaBase{

    @Override
    public void displayType() {
        System.out.println("This is cheesy pizza base");
    }
}
