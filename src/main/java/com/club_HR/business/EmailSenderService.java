//package com.club_HR.business;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailSenderService {
//
//    private JavaMailSender mailSender;
//
//    @Autowired
//    public EmailSenderService(JavaMailSender mailSender) {
//        this.mailSender = mailSender;
//    }
//
//    public void sendSimpleEmail(String toEmail, String body, String subject){
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setFrom("anas.elkacemi@gmail.com");
//        message.setTo(toEmail);
//        message.setText(body);
//        message.setSubject(subject);
//
//        mailSender.send(message);
//        System.out.println("Mail sent ...");
//    }
//}
