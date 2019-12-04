package njp.NaumenJavaProject.controllers;


import njp.NaumenJavaProject.forms.CurrentRecordForm;
import njp.NaumenJavaProject.models.Record;
import njp.NaumenJavaProject.servises.RecordServices;
import njp.NaumenJavaProject.servises.UsersServices;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    //метод для восстановления из корзины, форма должна прердать в него id и basket
    @RequestMapping(value ="/recoverfromBasket", method = RequestMethod.POST)
    public String recoverfromBasket(@ModelAttribute CurrentRecordForm basketForm){
        UsersServices usersServices = new UsersServices();
        RecordServices recordServices =new RecordServices();
        Record record = recordServices.findById(basketForm.getId());//
        record.setBasket(false);
        recordServices.updateRecord(record);
        return "redirect:/basket";
    }
    //метод для удаления из корзины, форма должна передать в него id
    @RequestMapping(value ="/deleteRecord", method = RequestMethod.POST)
    public String deleteRecord(@ModelAttribute CurrentRecordForm basketForm){
        RecordServices recordServices =new RecordServices();
        //не прередаётся id из формы, в остальном работает.
        Record record = recordServices.findById(basketForm.getId()); //
        recordServices.deleteRecord(record);
        return "redirect:/basket";
    }


}