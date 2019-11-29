package njp.NaumenJavaProject.controllers;

import njp.NaumenJavaProject.models.Record;
import njp.NaumenJavaProject.servises.UsersServices;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class BasketControler {

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @RequestMapping(value = "/basket", method = RequestMethod.GET)

    public String showBasket(Model model) {
        UsersServices usersServices = new UsersServices();
        List<Record> records = usersServices.findAll(getCurrentUsername(),true);
        model.addAttribute("records", records);
        return("/basket");



    }
}