package Company.Zoho.Mail;

/**
 * @author gauravkabra
 * @since 26/Mar/2022
 **/

public class Mail {
    private String to;
    private String from;
    private String subject;
    private String content;
    private Type type;

    public Mail(String to, String from, String subject, String content, Type type) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.content = content;
        this.type = type;
    }

    public String getTo() {
        return to;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.from + "->" + this.to + ", SUBJECT : " + this.subject + ", CONTENT : " + this.content;
    }
}
