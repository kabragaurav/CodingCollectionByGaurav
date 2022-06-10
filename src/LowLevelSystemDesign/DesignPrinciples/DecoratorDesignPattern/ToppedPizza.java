package LowLevelSystemDesign.DesignPrinciples.DecoratorDesignPattern;

/**
 * @author gaurav kabra
 * @since 10/Jun/2022
 **/

public abstract class ToppedPizza implements PizzaBase {

    PizzaBase pizzaBase;

    ToppedPizza(PizzaBase pizzaBase) {
        this.pizzaBase = pizzaBase;
    }

}
