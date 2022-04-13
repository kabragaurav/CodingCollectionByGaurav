/*
    Strategy design pattern falls under Behavioural design pattern.
 */
package Company.Microsoft.OOD.Strategy;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class MainStrategy {

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        IRole ic = new Developer("dveeloper");
        IRole lead = new TeamLead("Team Lead");

        Employee employee = new Employee();
        // strategy 1
        employee.setRole(ic);
        employee.displayRole();
        // strategy 2
        employee.setRole(lead);
        employee.displayRole();

    }

}
