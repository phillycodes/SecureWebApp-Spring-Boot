package com.springboot.SecureWebApp.controller;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.io.IOException;

/*
 * @Configuration indicating that it specifies configuration properties for the application.
 *
 * An object of this controller class will be instantiated and executed by invoking it's run method.
 * Implementing the CommandLineRunner interface makes this bean an executable bean.
 */
/*
@Configuration
public class MailController implements CommandLineRunner {


    // This bean makes use of the JavaMailSender in order to send mail
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void run(String... args) throws MessagingException, IOException {
        System.out.println("Sending mail...");

        sendEmail();

        System.out.println("Done");
    }

    private void sendEmail() {
        // Instantiate the object of SimpleMailMessage. Its simple being that there are no attachments.
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("twister-flaky-pony@duck.com");

        msg.setSubject("Email Sent By PhillyCodes Using Spring Boot");
        msg.setText("""
                Hello!\s

                Welcome to Spring Boot, PhillyCodes has sent this email via \
                an application created using Java Spring Boot and the SimpleMailMessage/JavaMailSender library.""");

        javaMailSender.send(msg);
    }
}


 */