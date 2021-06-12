package com.revature.services;

import com.revature.models.Mail;
import com.revature.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service("mailService")
@Transactional
public class MailServiceImpl implements MailService {
    private UserRepository userRepo;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    SpringTemplateEngine templateEngine;

    @Override
    public void sendEmail(Mail mail) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();

        try{
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            //mimeMessageHelper.addAttachment(mail.getAttachments());
            mimeMessageHelper.setSubject(mail.getMailSubject());
            mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom(),"AlphaCastInfo@gmail.com"));
            mimeMessageHelper.setTo(mail.getMailTo());


            mimeMessageHelper.addAttachment(mail.getAttachmentString(), new ClassPathResource(mail.getAttachmentResource()));

            Context context = new Context();
            context.setVariables(mail.getProps());




            String html = templateEngine.process("newsletter-template",context);
            mimeMessageHelper.setText(html,true);
            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | UnsupportedEncodingException messagingException) {
            messagingException.printStackTrace();
        }
    }


}
