import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMailBySite {
 public static void main(String[] args) {

  final String batteryMotherShip="maketestwork@gmail.com";
  final String password="123password123";
  
  String to="praveen.shethe7@gmail.com";

   //Get the session object
   Properties properties = new Properties();
   properties.put("mail.smtp.host","smtp.gmail.com");
   properties.put("mail.smtp.auth", "true");
   properties.put("mail.smtp.port", "587");
   properties.put("mail.smtp.starttls.enable", "true");   
   Session session = Session.getDefaultInstance(properties,
    new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication(batteryMotherShip,password);
      }
    });

    try {
     MimeMessage message = new MimeMessage(session);
     message.setFrom(new InternetAddress(batteryMotherShip));
     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
     message.setSubject("Mail API worked subject");
     message.setText("hi Vishnu check this new feature");
     Transport.send(message);

     System.out.println("message sent successfully...");
 
     } catch (MessagingException e) {e.printStackTrace();}
 }
}