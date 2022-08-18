package com.alkemy.disneylandia.disneylandia.service.implement;

import com.alkemy.disneylandia.disneylandia.exception.EmailExc;
import com.alkemy.disneylandia.disneylandia.service.EmailService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailServiceImplement implements EmailService {

    @Autowired
    private Environment env;

    @Value("alkemy.disneylandia.email.sender")
    private String emailSender;
    @Value("alkemy.disneylandia.email.enabled")
    private boolean enabled;

    public void sendWelcomeEmailTo(String to) throws IOException {
        if (!enabled) {
            throw new EmailExc("Email sending is disabled");
        }
        if (emailSender == null) {
            throw new EmailExc("Invalid email sender");
        }
        String apiKey = env.getProperty("EMAIL_API_KEY");
        Email fromMail = new Email(emailSender);
        Email toMail = new Email(to);
        Content content = new Content("text/plain", "Welcome to Disney Alkemy API - now you're in our database");
        String subject = "You've registered succesfully";
        Mail mail = new Mail(fromMail, subject, toMail, content);
        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            if (response.getStatusCode() != 200 && response.getStatusCode() != 201 && response.getStatusCode() != 202) {
                throw new EmailExc("Error. Email not sent");
            }
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}