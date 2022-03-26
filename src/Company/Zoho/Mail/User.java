package Company.Zoho.Mail;

import java.util.HashSet;
import java.util.Objects;
import java.util.regex.Pattern;

import static Company.Zoho.Mail.DesignMailApp.getEmailToPassword;

/**
 * @author gauravkabra
 * @since 26/Mar/2022
 **/

public class User {

    private static String emailId;
    private static String loginPassword;

    private static EmailSummary emailSummary;
    private static final String DOMAIN = "zsma.in";

    User(String emailId, String loginPassword) {
        this.emailId = emailId;
        this.loginPassword = loginPassword;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public String getLoginPassword() {
        return this.loginPassword;
    }

    public static EmailSummary getEmailSummary() {
        return emailSummary;
    }

    public static void setEmailSummary(EmailSummary emailSummary) {
        User.emailSummary = emailSummary;
    }

    public boolean verifyPassword(String password) {
        return loginPassword.equals(password);
    }

    public boolean isPasswordStrong(String password) {
        return password.length() >= 6 &&
                password.chars().anyMatch(ch -> Character.isLetter(ch) && Character.isUpperCase(ch)) &&
                password.chars().anyMatch(ch -> Character.isLetter(ch) && Character.isLowerCase(ch)) &&
                password.chars().anyMatch(ch -> Character.isDigit(ch));
    }

    public boolean isEmailIdValid(String emailId) {
        String[] parts = emailId.split("@");
        return  !doesAlreadyExists(emailId) &&
                DOMAIN.equals(parts[1]) &&
                Pattern.matches("[a-zA-Z0-9_\\.]+", parts[0]);
    }

    private boolean doesAlreadyExists(String emailId) {
        HashSet<User> emailToPassword = getEmailToPassword();

        for (User user : emailToPassword) {
            if (user.getEmailId().equals(emailId)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof User &&
                ((User) obj).getEmailId().equals(this.getEmailId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getEmailId() + ":" + this.getLoginPassword());
    }
}
