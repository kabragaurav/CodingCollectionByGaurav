package LowLevelSystemDesign.DesignPrinciples.BuilderDesignPattern;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class Phone {

    private String name;
    private String os;
    private String processor;

    public Phone setName(String name) {
        this.name = name;
        return this;
    }

    public Phone setOs(String os) {
        this.os = os;
        return this;
    }

    public Phone setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    @Override
    public String toString() {
        return "Phone : name=" + name +
                    ", os=" + os +
                    ", processor=" + processor;
    }

}
