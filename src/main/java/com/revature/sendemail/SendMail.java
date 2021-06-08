package com.revature.sendemail;

import java.security.Security;
import java.util.Properties; //represents a persistent set of properties that can be saved to a stream or loaded from a stream
import javax.mail.Message; //this class models an email message. subclass of message is instantiated, the attributes and content are filled in, message is
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.security.Security;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.revature.models.User;

public class SendMail {
    //assumin you are sending email through gmail smtp
    private String host = "smtp.gmail.com";
    //port name
    private String smtpPort="465";
    //actual message
    private String meessage ="Test  message";
    //email subject
    private String subject ="AlphaCast: WeatherAlert";
    //senders email ID needs to be mentioned as well
    private String from = "ej@jeldrop.com";//check if this needs to be a real email
    //String to = appUser.getEmail();
    private String to = "eobarobest@gmail.com";
    private String sslFactory ="javax.net.ssl.SSLSocketFactory";
    private User appUser = new User();
    private String[] sendTo={"eobarobest@gmail.com"};
    //recipient's email ID needs to be mentioned

    public static void main(String[] args) {
//        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//
//        new SendMail().sendSSLMessage(sendTo, subject,
//                message, from);
//        System.out.println("Sucessfully Sent mail to All Users");
//    }
//    public void sendSSLMessage(String recipients[], String subject,
//                               String message, String from) throws MessagingException {
//        boolean debug = true;
//        //get system properties
//        Properties properties = System.getProperties();
//        //setup mail server
//        properties.put("mail.smtp.host",host);
//        properties.put("mail.smtp.auth","true");
//        properties.put("mail.debug","true");
//        properties.put("mail.smtp.socketFactory.port",smtpPort);
//        properties.put("mail.smtp.socketFactory.")
//        properties.put("mail.smtp.port","465");
//        properties.put("mail.smtp.ssl.enable","true");
//
//        //get the session object and pass the username and password, this will be replaced with JWT token
//        Session session = Session.getInstance(properties,new javax.mail.Authenticator(){
//            protected  PasswordAuthentication getPasswordAuthentication(){
//            return new PasswordAuthentication("ej@jeldrop.com","6Children!");
//
//            }
//        });
//
//        //Used to debug SMTP issues
//        session.setDebug(true);
//        try{
//            //Create a default MimeMessage obj
//            MimeMessage message = new MimeMessage(session);
//            //set from: header field of the header
//            message.setFrom(new InternetAddress(from));
//            // Set To: header field of the header.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            //set to:header their of the header
//            message.setSubject("AlphaCast Weather Update!");
//            //set the actual message
//            message.setText(
//                    "Insert weather alert here"
//            );
////            // Send the actual HTML message.
//            //this is for if we wanted to actually send html in the actual message
////            message.setContent(
////                    "<h1>This is actual message embedded in HTML tags</h1>",
////                    "text/html");
//            System.out.println("Sending...");
//            Transport.send(message);
//            System.out.println("Sent message successfully...");
//        }catch(MessagingException messagingException){
//            messagingException.printStackTrace();
//        }
//
//
//
    }
}
