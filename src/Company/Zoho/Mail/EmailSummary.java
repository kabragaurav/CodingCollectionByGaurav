package Company.Zoho.Mail;

/**
 * @author gauravkabra
 * @since 26/Mar/2022
 **/

public class EmailSummary {

    private int inboxEmailsCount;
    private int failedEmailsCount;
    private int sentEmailsCount;
    private int trashEmailsCount;

    public EmailSummary(int inboxEmailsCount, int failedEmailsCount, int sentEmailsCount, int trashEmailsCount) {
        this.inboxEmailsCount = inboxEmailsCount;
        this.failedEmailsCount = failedEmailsCount;
        this.sentEmailsCount = sentEmailsCount;
        this.trashEmailsCount = trashEmailsCount;
    }

    public int getInboxEmailsCount() {
        return inboxEmailsCount;
    }

    public int getFailedEmailsCount() {
        return failedEmailsCount;
    }

    public int getSentEmailsCount() {
        return sentEmailsCount;
    }

    public int getTrashEmailsCount() {
        return trashEmailsCount;
    }

    public void setInboxEmailsCount(int inboxEmailsCount) {
        this.inboxEmailsCount = inboxEmailsCount;
    }

    public void setFailedEmailsCount(int failedEmailsCount) {
        this.failedEmailsCount = failedEmailsCount;
    }

    public void setSentEmailsCount(int sentEmailsCount) {
        this.sentEmailsCount = sentEmailsCount;
    }

    public void setTrashEmailsCount(int trashEmailsCount) {
        this.trashEmailsCount = trashEmailsCount;
    }

    @Override
    public String toString() {
        return this.inboxEmailsCount + ", "
                + this.trashEmailsCount + ", "
                + this.failedEmailsCount + ", "
                + this.sentEmailsCount;
    }
}
