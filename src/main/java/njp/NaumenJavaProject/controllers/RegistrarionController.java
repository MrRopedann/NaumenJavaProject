package njp.NaumenJavaProject.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class RegistrarionController {
    @RequestMapping("/registration")
    public String registration() {
    return "registration";
    }
}






