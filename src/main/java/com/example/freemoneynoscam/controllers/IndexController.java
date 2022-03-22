package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
public class IndexController {
    private ValidateEmailService ve = new ValidateEmailService();

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/failure")
    public String failure() {
        return "failure";
    }

    @GetMapping("/success")
    public String success(){
    return "success";
    }

    @PostMapping("/test")
    public String test(WebRequest dataFromForm){

        if (ve.isEmailValid(dataFromForm.getParameter("email"))){
        return "redirect:/success";

        }
        return "redirect:/failure";
    }

}
