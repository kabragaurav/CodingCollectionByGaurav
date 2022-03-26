package Company.Zoho.Mail;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author gauravkabra
 * @since 26/Mar/2022
 **/

public class DesignMailApp {

    private static final String loginStatementEmail = "Enter your email";
    private static final String loginStatementPassword = "Enter your password";

    private static HashSet<User> emailToPassword;
    private static HashMap<User, EmailSummary> userToEmailsSummary;
    private static List<User> users;
    Scanner userInputTaker;

    public static HashSet<User> getEmailToPassword() {
        return emailToPassword;
    }

    DesignMailApp() {
        userInputTaker = new Scanner(System.in);

        // set users with email and pwd
        emailToPassword = new HashSet<>();
        users.add(new User("user1", "test1234"));
        users.add(new User("user2", "pwd12345"));
        emailToPassword.addAll(users);

        // set user summaries
        userToEmailsSummary = new HashMap<>();
        EmailSummary emailSummary1 = new EmailSummary(10, 5, 2, 0);
        EmailSummary emailSummary2 = new EmailSummary(5, 15, 4, 1);
        userToEmailsSummary.put(users.get(0),emailSummary1);
        userToEmailsSummary.put(users.get(1),emailSummary1);
    }


    public void loginFlow() {
        User currentUser = loginUserIfSuccessful();
        if (null != currentUser) {
            System.out.println("Welcome " + currentUser.getEmailId());
            System.out.println(userToEmailsSummary.get(currentUser));
        }
    }


    private User loginUserIfSuccessful() {
        System.out.println(loginStatementEmail);
        String email = userInputTaker.nextLine();
        User currentUser = getUserByEmailId(email);
        if (null == currentUser) {
            return null;
        }
        System.out.println(loginStatementPassword);
        String password = userInputTaker.nextLine();
        if (currentUser.getLoginPassword().equals(password)) {
            return currentUser;
        }
        return null;
    }

    private User getUserByEmailId(String email) {
        for (User user : emailToPassword) {
            if (user.getEmailId().equals(email)) {
                return user;
            }
        }
        return null;
    }


    // driver - main method
    public static void main(String[] args) {
        // TESTCASE

    }

}
