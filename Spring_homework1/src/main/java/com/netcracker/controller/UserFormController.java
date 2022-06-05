package com.netcracker.controller;

import com.netcracker.constant.MyConstants;
import com.netcracker.model.CustomMessage;
import com.netcracker.model.Info;
import com.netcracker.model.User;
import com.netcracker.model.UserForSearch;
import com.netcracker.service.MyEmailService;
import com.netcracker.service.MyMailSender;
import com.netcracker.service.RegexService;
import com.netcracker.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class UserFormController {

    @Autowired
    private UserDataService userDataService;
    @Autowired
    private RegexService regexService;


    @GetMapping("/user")
    public String userForm(Model model){
        model.addAttribute("userform", new User());
        model.addAttribute("findform", new UserForSearch());

        return "userform";
    }

    @PostMapping("/find-user")
    public String findByNameUser(@ModelAttribute UserForSearch u,
                                 Model model, HttpServletRequest request) {
        String name = u.getName();
        String family = u.getFamily();
        User user = userDataService.findByNameAndFamily(name, family);
        if (user == null) {
            return "usernotfound";
        } else {
            Info info = new Info();
            info.setTime(String.valueOf(new Date(System.currentTimeMillis())));
            info.setBrowser(String.valueOf(request.getHeader("User-Agent")));
            model.addAttribute("user", user);
            model.addAttribute("info", info);
            CustomMessage m = new CustomMessage();
            m.setTo(user.getEmail());
            model.addAttribute("message", m);
            model.addAttribute("email", user.getEmail());

            return "userisfound";
        }
    }

    @PostMapping("/save-user")
    public String userSave(@ModelAttribute User user, @ModelAttribute UserForSearch u, Model model){
        if(regexService.checkingValidate(user)) {
            userDataService.saveInFile(user);
            return "result";
        }
        else {
            return "incorrectenter";
        }
    }

}
