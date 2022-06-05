package com.netcracker.controller;

import com.netcracker.constant.MyConstants;
import com.netcracker.model.CustomMessage;
import com.netcracker.model.User;
import com.netcracker.service.MyEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {

    @Autowired
    private MyEmailService emailService;


    @PostMapping("/email")
    public String createCustomMessage(Model model,@ModelAttribute String email){

        CustomMessage m = new CustomMessage();
        m.setTo(email);
        m.setFrom(MyConstants.MY_EMAIL);

        System.out.println(m);
        model.addAttribute("message", m);

        return "newemail";
    }

    @PostMapping("/sendemail")
    public String sendCustomMessage(Model model, @ModelAttribute CustomMessage message){
        System.out.println(message.toString());

        emailService.sendSimpleEmail(message.getTo(),message.getFrom(),
                message.getSubject(), message.getText());

        model.addAttribute("message", message);

        return "messagesent";
    }
}