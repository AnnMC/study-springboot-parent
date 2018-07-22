package study.springboot.all.study.springboot.all.email;

public interface MailService {
    public void sendSimpleMail(String to, String subject, String content);
}
