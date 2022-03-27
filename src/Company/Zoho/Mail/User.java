package Company.Zoho.Mail;

import java.util.*;
import java.util.regex.Pattern;

import static Company.Zoho.Mail.DesignMailApp.getEmailToPassword;

/**
 * @author gauravkabra
 * @since 26/Mar/2022
 **/

public class User {

    private String emailId;
    private String loginPassword;

    private EmailSummary emailSummary;
    private List<Mail> allEmails;
    private static Scanner userInputTaker;

    private static final String DOMAIN = "zsma.in";
    private static final String TO_PROMPT = "Whom to sent email";
    private static final String SUBJECT_PROMPT = "Enter subject";
    private static final String CONTENT_PROMPT = "Enter content";
    private static final String INVALID_TO_PROMPT = "To does not exist";

    User(String emailId, String loginPassword) {
        userInputTaker = new Scanner(System.in);
        this.emailId = emailId;
        this.loginPassword = loginPassword;
        allEmails = new ArrayList<>();
        emailSummary = new EmailSummary(0,0,0,0);
    }

    public String getEmailId() {
        return this.emailId;
    }

    public String getLoginPassword() {
        return this.loginPassword;
    }

    public EmailSummary getEmailSummary() {
        return emailSummary;
    }

    public void setEmailSummary(EmailSummary emailSummary) {
        this.emailSummary = emailSummary;
    }

    public List<Mail> getAllEmails() {
        return allEmails;
    }

    public void setAllEmails(List<Mail> allEmails) {
        this.allEmails = allEmails;
    }

    public boolean verifyPassword(String password) {
        return loginPassword.equals(password);
    }

    public static boolean isPasswordStrong(String password) {
        return password.length() >= 6 &&
                password.chars().anyMatch(ch -> Character.isLetter(ch) && Character.isUpperCase(ch)) &&
                password.chars().anyMatch(ch -> Character.isLetter(ch) && Character.isLowerCase(ch)) &&
                password.chars().anyMatch(ch -> Character.isDigit(ch));
    }

    public static boolean isEmailIdValid(String emailId) {
        String[] parts = emailId.split("@");
        return  !doesAlreadyExists(emailId) &&
                DOMAIN.equals(parts[1]) &&
                Pattern.matches("[a-zA-Z0-9_\\.]+", parts[0]);
    }

    public List<Mail> getAllSentMailsByEmailId(String emailId) {
        List<Mail> allSentMailsByEmailId = new ArrayList<>();
        for (Mail mail : allEmails) {
            if (mail.getType() == Type.SENT && mail.getTo().equals(emailId)) {
                allSentMailsByEmailId.add(mail);
            }
        }
        return allSentMailsByEmailId;
    }

    public List<Mail> getAllInboxEmails() {
        List<Mail> allInboxEmails = new ArrayList<>();
        for (Mail mail : allEmails) {
            if (mail.getType() == Type.RECEIVED) {
                allInboxEmails.add(mail);
            }
        }
        return allInboxEmails;
    }

    public boolean trashAMail(String subject) {
        List<Mail> matchedMails = new ArrayList<>();

        for (Mail mail : allEmails) {
            if (mail.getSubject().contains(subject)) {
                matchedMails.add(mail);
            }
        }

        for (Mail mail : matchedMails) {
            mail.setType(Type.TRASHED);
        }

        emailSummary.setTrashEmailsCount(emailSummary.getTrashEmailsCount() + 1);

        return true;
    }

    public boolean composeMail() {
        String from = this.getEmailId();
        System.out.println(TO_PROMPT);
        String to = userInputTaker.nextLine();
        System.out.println(SUBJECT_PROMPT);
        String subject = userInputTaker.nextLine();
        System.out.println(CONTENT_PROMPT);
        String content = userInputTaker.nextLine();
        List<User> users = DesignMailApp.getUsers();
        boolean isValidTo = false;
        for (User user : users) {
            if (user.getEmailId().equals(to)) {
                isValidTo = true;
                break;
            }
        }
        if (!isValidTo) {
            System.out.println(INVALID_TO_PROMPT);
            Mail mail = new Mail(to, from, subject, content, Type.FAILED);
            allEmails.add(mail);
            emailSummary.setFailedEmailsCount(emailSummary.getFailedEmailsCount() + 1);
            return false;
        }
        emailSummary.setSentEmailsCount(emailSummary.getSentEmailsCount() + 1);
        Mail mail = new Mail(to, from, subject, content, Type.SENT);
        allEmails.add(mail);
        return true;
    }

    private static boolean doesAlreadyExists(String emailId) {
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

    @Override
    public String toString() {
        return this.getEmailId() + ":" + this.getLoginPassword();
    }
}
