package com.revature.sendemail;

import java.util.Properties; //represents a persistent set of properties that can be saved to a stream or loaded from a stream
import javax.mail.Message; //this class models an email message. subclass of message is instantiated, the attributes and content are filled in, message is
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.revature.models.User;

public class SendMail {
    public static void main(String[] args) {
        User appUser = new User();
        //recipient's email ID needs to be mentioned
        String to = appUser.getEmail();
        //senders email ID needs to be mentioned as well
        String from = "ej@jeldrop.com";//check if this needs to be a real email
        //assumin you are sending email through gmail smtp
        String host = "smtp.gmail.com";
        //get system properties
        Properties properties = System.getProperties();

        //setup mail server
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");


    }
}
