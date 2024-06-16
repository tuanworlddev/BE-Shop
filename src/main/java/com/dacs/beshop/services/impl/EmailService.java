package com.dacs.beshop.services.impl;

import com.dacs.beshop.entities.OrderDetails;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Async
    public void sendMessageUpdateStatus(String to, OrderDetails orderDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("nat612005@gmail.com");
        message.setTo(to);
        message.setSubject("Your Order Status Update");
        message.setText("Dear "+ to +",\n" +
                "\n" +
                "We hope this email finds you well.\n" +
                "\n" +
                "We are writing to inform you that your order #" + orderDetails.getId() + "is currently in the following status: "+ orderDetails.getStatus().name() +". Our team is working diligently to ensure that your order is processed smoothly and reaches you as quickly as possible.\n" +
                "\n" +
                "For the most up-to-date information about your order, we recommend that you frequently check our app. You can track the progress of your order, view estimated delivery times, and receive real-time updates directly within the app.\n" +
                "\n" +
                "If you have any questions or need further assistance, please do not hesitate to contact our customer service team at [Customer Service Email/Phone Number]. We are here to help and ensure that your shopping experience with us is exceptional.\n" +
                "\n" +
                "Thank you for choosing TuanDev. We appreciate your business and look forward to serving you again soon.\n" +
                "\n" +
                "Best regards,\n" +
                "\n" +
                "Nguyen Anh Tuan\n");
        emailSender.send(message);
    }
}
