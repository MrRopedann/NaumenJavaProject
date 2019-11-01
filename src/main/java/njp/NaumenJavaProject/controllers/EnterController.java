package njp.NaumenJavaProject.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnterController {

    @RequestMapping("/enter")
    public String enter() {
        return "enter";
    }
}
