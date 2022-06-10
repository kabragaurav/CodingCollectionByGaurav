package LowLevelSystemDesign.DesignPrinciples.ObserverDesignPattern;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class Subscriber {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void showNotification(String title) {
        System.out.println("Hey " + name + ", New video published : " + title);
    }
}
