package njp.NaumenJavaProject.controllers;


import njp.NaumenJavaProject.forms.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/*@Controller

public class RegistrationController {
    @RequestMapping(value= "/registration", method =  RequestMethod.GET)
    public String registration() {
    return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    protected String postRegistration()  {

       //
        // String userLogin=RegistrationForm registrationForm
        // String userPassword=
       // String userEmail = registrationForm.getEmail();
      //  System.out.println(userEmail);
        // Здесь выполняем какие-то действия (например, сохранение в БД)
        return "registration";
    }

}*/

@Controller
public class RegistrationController {
    /*
    @GetMapping("/registration")

        protected String resp()
    {return "/registration";
    }
    */
    @PostMapping("/registration")
    protected String addManPost(RegistrationForm registrationForm ) throws UnsupportedEncodingException {
        String login = registrationForm.getLogin();
        System.out.println(login);
        // Здесь выполняем какие-то действия (например, сохранение в БД)
        return "/greeting";
    }

/*
    @GetMapping("/greeting")
    protected String getGreeting(
        @RequestParam(name = "name",required = false, defaultValue = "1234") String name,
                Model model){
        model.addAttribute("name", name);// есть методы model.addAttribures() можно передавать колекции скорее всего есть метод для объектов
        return "/greeting";
    }
    @PostMapping("/greeting")
    protected String postGreeting(RegistrationForm registrationForm){
        String name= registrationForm.getLogin();
         return"redirect:/greeting";
    }

 */
}


