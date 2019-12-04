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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String recordsForCurrentusers(Model model) {

        UsersServices usersServices = new UsersServices();
        List <Record> records = usersServices.findAll(getCurrentUsername(),false, false);
        model.addAttribute("records", records);
        return("../static/index");
      }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView regPost (@ModelAttribute CurrentRecordForm currentRecordForm) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/editing");
        RecordServices recordServices =new RecordServices();
        Record record = recordServices.findById(currentRecordForm.getId());
        mav.addObject("record", record);
        return mav;
    }

    @RequestMapping(value = "/toBasket", method = RequestMethod.POST)
    public String toBasket(@ModelAttribute CurrentRecordForm basketForm){
            RecordServices recordServices =new RecordServices();
            Record record = recordServices.findById(basketForm.getId());//
            record.setBasket(true);
            recordServices.updateRecord(record);
        return "redirect:/";
    }
    @RequestMapping(value = "/endTask", method = RequestMethod.POST)
    public String endTask(@ModelAttribute CurrentRecordForm basketForm){
        RecordServices recordServices =new RecordServices();
        Record record = recordServices.findById(basketForm.getId());//
        record.setStatus(true);
        recordServices.updateRecord(record);
        return "redirect:/";
    }

}
