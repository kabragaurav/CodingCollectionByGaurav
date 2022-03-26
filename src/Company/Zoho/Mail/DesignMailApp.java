package Company.Zoho.Mail;

import java.util.*;

/**
 * @author gauravkabra
 * @since 26/Mar/2022
 **/

public class DesignMailApp {

    private static final String EMAIL_STATEMENT_PROMPT = "Enter your email";
    private static final String PASSWORD_STATEMENT_PROMPT = "Enter your password";
    private static final String DUPLICATE_USER_PROMPT = "User already exists";
    private static final String WEAK_PASSWORD_PROMPT = "Password is weak";
    private static final String INVALID_EMAIL_ID_FORMAT = "Email ID is in invalid format";
    private static final String INVALID_USER = "User does not exist";
    private static final String INVALID_PASSWORD = "Invalid password";

    private static HashSet<User> emailToPassword;
    private static HashMap<User, EmailSummary> userToEmailsSummary;
    private static List<User> users;
    private static Scanner userInputTaker;
    private static User currentUser;

    public static HashSet<User> getEmailToPassword() {
        return emailToPassword;
    }

    DesignMailApp() {
        userInputTaker = new Scanner(System.in);

        // set users with email and pwd
        emailToPassword = new HashSet<>();
        users = new ArrayList<>();
        users.add(new User("user1@zsma.in", "test1234"));
        users.add(new User("user2@zsma.in", "pwd12345"));
        emailToPassword.addAll(users);

        // set user summaries
        userToEmailsSummary = new HashMap<>();
        EmailSummary emailSummary1 = new EmailSummary(10, 5, 2, 0);
        EmailSummary emailSummary2 = new EmailSummary(5, 15, 4, 1);
        userToEmailsSummary.put(users.get(0),emailSummary1);
        userToEmailsSummary.put(users.get(1),emailSummary2);

        // set all emails
        List<Mail> mails1 = new ArrayList<>();
        mails1.add(new Mail("user1", "user2", "this is a subject", "hey user1 from user2", Type.RECEIVED));
        users.get(0).setAllEmails(mails1);
    }


    public void loginFlow() {
        currentUser = loginUserIfSuccessful();
        if (null != currentUser) {
            System.out.println("Welcome " + currentUser.getEmailId());
            System.out.println(userToEmailsSummary.get(currentUser));
        }
    }

    public void logoutFlow() {
        currentUser = null;
    }

    public static List<User> getUsers() {
        return users;
    }

    public boolean isDeleteUserSuccessful() {
        System.out.println(EMAIL_STATEMENT_PROMPT);
        String email = userInputTaker.nextLine();
        System.out.println(PASSWORD_STATEMENT_PROMPT);
        String password = userInputTaker.nextLine();
        User whomToDelete = null;
        boolean isUserFound = false;
        for (User user : users) {
            if (user.getEmailId().equals(email) && user.getLoginPassword().equals(password)) {
                whomToDelete = user;
                isUserFound = true;
                break;
            }
        }

        if (!isUserFound) {
            return false;
        }

        users.remove(whomToDelete);
        for (User use : emailToPassword) {
            if (use.equals(whomToDelete)) {
                emailToPassword.remove(use);
                break;
            }
        }
        return false;
    }

    public List<Mail> getEmailBySubject(String subject) {
        if (null != currentUser) {
            List<Mail> matchedMails = new ArrayList<>();
            for (User user : users) {
                if (user.equals(currentUser)) {
                    List<Mail> allMails = user.getAllEmails();
                    for (Mail mail : allMails) {
                        if (mail.getType() != Type.TRASHED && mail.getSubject().contains(subject)) {
                            matchedMails.add(mail);
                        }
                    }
                    return matchedMails;
                }
            }
        }

        return Collections.emptyList();
    }

    public boolean signUpFlow() {
        System.out.println(EMAIL_STATEMENT_PROMPT);
        String email = userInputTaker.nextLine();
        if (!User.isEmailIdValid(email)) {
            System.out.println(INVALID_EMAIL_ID_FORMAT);
            return false;
        }
        User user = getUserByEmailId(email);
        if (null != user) {
            System.out.println(DUPLICATE_USER_PROMPT);
            return false;
        }
        System.out.println(PASSWORD_STATEMENT_PROMPT);
        String password = userInputTaker.nextLine();
        if (!User.isPasswordStrong(password)) {
            System.out.println(WEAK_PASSWORD_PROMPT);
            return false;
        }
        User newUser = new User(email, password);
        users.add(newUser);
        emailToPassword.add(newUser);
        return true;
    }

    private User loginUserIfSuccessful() {
        System.out.println(EMAIL_STATEMENT_PROMPT);
        String email = userInputTaker.nextLine();
        User user = getUserByEmailId(email);
        if (null == user) {
            System.out.println(INVALID_USER);
            return null;
        }
        System.out.println(PASSWORD_STATEMENT_PROMPT);
        String password = userInputTaker.nextLine();
        if (user.getLoginPassword().equals(password)) {
            return user;
        }
        System.out.printf(INVALID_PASSWORD);
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
        DesignMailApp designMailApp = new DesignMailApp();
        while (true) {
            System.out.println("What operation you want to do");
            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Logout");
            System.out.println("4. Mail Summary");
            System.out.println("5. Delete Account");
            System.out.println("6. Search mail by Subject");
            System.out.println("7. Compose a mail");
            System.out.println("8. Trash a mail");
            System.out.println("9. View Sent mails");
            System.out.println("10. Filter emails by email ID");
            System.out.println("11. Exit the app");


            int choice;
            try {
                choice = Integer.parseInt(userInputTaker.nextLine());
            } catch (Exception ex) {
                System.out.println("Invalid option entered. " + ex.getMessage());
                continue;
            }

            switch (choice) {
                case 1:
                    designMailApp.loginFlow();
                    break;
                case 2:
                    designMailApp.signUpFlow();
                    break;
                case 3:
                    designMailApp.logoutFlow();
                    break;
                case 4:
                    System.out.println(userToEmailsSummary.get(currentUser));
                    break;
                case 5:
                    designMailApp.isDeleteUserSuccessful();
                    break;
                case 6:
                    System.out.println("Enter subject");
                    String subject = userInputTaker.nextLine();
                    List<Mail> mails = designMailApp.getEmailBySubject(subject);
                    System.out.println(mails);
                    break;
                case 7:
                    if (currentUser != null) {
                        currentUser.composeMail();
                    }
                    break;
                case 8:
                    System.out.println("Enter subject");
                    subject = userInputTaker.nextLine();
                    if (currentUser != null) {
                        currentUser.trashAMail(subject);
                    }
                    break;
                case 9:
                    System.out.println("Enter email ID to which you sent");
                    String sentEmailId = userInputTaker.nextLine();
                    if (currentUser != null) {
                        mails = currentUser.getAllSentMailsByEmailId(sentEmailId);
                        System.out.println(mails);
                    }
                    break;
                case 10:
                    System.out.println("Enter email ID on which to filter");
                    String emailId = userInputTaker.nextLine();
                    mails = currentUser.getAllSentMailsByEmailId(emailId);
                    System.out.println(mails);
                    break;
                case 11:
                    System.exit(0);
                default:
                    System.out.println("Invalid attempt to break into system :)");
            }
            System.out.println("\n==========  ### =============\n");
        }
    }

}
