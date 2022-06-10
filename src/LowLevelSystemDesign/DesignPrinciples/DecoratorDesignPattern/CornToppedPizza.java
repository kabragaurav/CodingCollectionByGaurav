package LowLevelSystemDesign.DesignPrinciples.DecoratorDesignPattern;

/**
 * @author gaurav kabra
 * @since 10/Jun/2022
 **/

public class CornToppedPizza extends ToppedPizza {

    CornToppedPizza(PizzaBase pizzaBase) {
        super(pizzaBase);
    }

    @Override
    public void displayType() {
        System.out.println("This pizza has yummy corn topping");
    }

}
