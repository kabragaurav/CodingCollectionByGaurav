package Company.Microsoft.OOD.Strategy;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class Employee {
    IRole role;

    public void setRole(IRole role) {
        this.role = role;
    }

    public void displayRole() {
        role.printRole();
    }

}
