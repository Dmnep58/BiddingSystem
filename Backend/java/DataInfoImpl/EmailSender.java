package DataInfoImpl;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
	static final String username = "mishrapwwan123@gmail.com";
   static  final String password = "qqomvodjhgvzmvtg";
     
//    public static void main(String[] args) {
//       
//        String recipientEmail = "dp@gmail.com";

        public static boolean SendEmail(String Subject , String messages , String recipientEmail) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(Subject);
            message.setText(messages);

            Transport.send(message);
            return true;

        } catch (AddressException e) {
        	return false;
        } catch (MessagingException e) {
            return false;
        }
    }
}
