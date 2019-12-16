package njp.NaumenJavaProject.controllers;


import njp.NaumenJavaProject.forms.RegistrationForm;
import njp.NaumenJavaProject.models.Role;
import njp.NaumenJavaProject.models.Users;
import njp.NaumenJavaProject.servises.UsersServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Controller

public class RegistrationController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String enter() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)

    public ModelAndView regPost (@ModelAttribute RegistrationForm registrationForm){

        UsersServices usersServices = new UsersServices();
        Users user=usersServices.findUserLogin(registrationForm.getLogin());
        if(user!=null) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("form", registrationForm);
            mav.addObject("isExist" ,true);
            mav.setViewName("registration");
            return mav;
        }
        else {
            Users users = new Users(); // для примера как записать в базу параметры
            users.setEmail(registrationForm.getEmail());
            users.setLogin(registrationForm.getLogin());
            users.setPassword(registrationForm.getPassword());
            users.setRoles(Collections.singleton(Role.USER));
            users.setActive(true);
            usersServices.saveUser(users);

            ModelAndView mav = new ModelAndView();
            mav.addObject("form", registrationForm);
            mav.setViewName("login");
            return mav;
        }
    }
}
