package LowLevelSystemDesign.DesignPrinciples.StrategyDesignPattern;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class Developer implements IRole {

    String role;

    public Developer(String role) {
        this.role = role;
    }

    @Override
    public void printRole() {
        System.out.println(role);
    }
}
