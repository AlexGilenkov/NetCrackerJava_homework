package com.netcracker.service;

import com.netcracker.constant.MyConstants;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Service
public class MyMailSender extends JavaMailSenderImpl {

    private final String myHost = "smtp.yandex.ru";
    private final int myPort = 465;


    public MyMailSender() {
        this.setUsername(MyConstants.MY_EMAIL);
        this.setPassword(MyConstants.PASSWORD);
        this.setHost(myHost);
        this.setPort(myPort);

        Properties props = new Properties();
        props.put("mail.smtp.host", myHost);
        props.put("mail.smtp.ssl.enable" , "true");
        props.put("mail.smtp.port",myPort);
        props.put("mail.smtp.auth", "true");

        this.setJavaMailProperties(props);

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MyConstants.MY_EMAIL, MyConstants.PASSWORD);
            }
        });

    }
}
