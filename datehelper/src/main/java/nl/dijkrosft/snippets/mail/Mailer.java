package nl.dijkrosft.snippets.mail;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class Mailer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "gdexch6.ortec.intranet");
        // props.put("mail.smtp.port", "465");
        Session session = Session.getInstance(props, null);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom("bngtreasury@ortec.nl");
            msg.setRecipients(Message.RecipientType.TO,
                    "dickdijk@xs4all.nl");
            msg.setSubject("JavaMail hello world example");
            msg.setSentDate(new Date());
            msg.setText("Hello, world!\n");
            Transport.send(msg, "dickdijk", "aragon95");
            System.out.println("msg sent!");
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }
    }

}
