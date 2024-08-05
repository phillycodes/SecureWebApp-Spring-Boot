package com.springboot.SecureWebApp.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * This component indicates that this class is managed by spring.
 */
@Component
public class BookHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private JavaMailSender javaMailSender;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    /*
     * Description: This method is invoked before the actual handler gets executed and the view is not generated.
     * The handler will check to see if the bookId is in the incoming http request, is so it will print to the console
     * and invoke the sendEmail method.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getParameter("bookId") != null) {
            System.out.println("preHandle() method sending book access mail..");

            sendEmail(request.getParameter("bookId"), "Book accessed");

            System.out.println("Done!");
        }

        return true;
    }

    /*
     * Description: After the Handler is executed and before the view is executed. This is where
     * you can add additional model parameters
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        if (request.getParameter("bookId") != null) {
            System.out.println("postHandle() method sending book access mail...");

            sendEmail(request.getParameter("bookId"), "Book access complete");

            System.out.println("Done");
        }
    }

    /*
     * Description: In this method you not only gather the request and response data but also
     * information about any exceptions that were thrown. Which can be used for logging and/or
     * timing purposes.
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        if (request.getParameter("bookId") != null) {

            System.out.println("Sending book request and response completion mail...");

            sendEmail(request.getParameter("bookId"), "Request and response complete");

            System.out.println("Done");
        }
    }

    private void sendEmail(String bookId, String messageText) {

        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo("jet-onset-stove@duck.com");

        msg.setSubject("Book Related Activity for Book: " + bookId);
        msg.setText(messageText + " " + dateFormat.format(new Date()));

        javaMailSender.send(msg);
    }
}