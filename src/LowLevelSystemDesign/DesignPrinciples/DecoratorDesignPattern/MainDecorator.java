package LowLevelSystemDesign.DesignPrinciples.DecoratorDesignPattern;

/**
 * @author gaurav kabra
 * @since 10/Jun/2022
 **/

public class MainDecorator {

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        PizzaBase pizzaBase = new CheesyPizzaBase();
        pizzaBase.displayType();

        ToppedPizza toppedPizza = new CornToppedPizza(pizzaBase);
        toppedPizza.displayType();
    }

}
