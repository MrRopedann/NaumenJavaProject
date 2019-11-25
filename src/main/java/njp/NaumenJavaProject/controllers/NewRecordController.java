package njp.NaumenJavaProject.controllers;
import njp.NaumenJavaProject.forms.RecordForm;
import njp.NaumenJavaProject.models.Record;
import njp.NaumenJavaProject.servises.RecordServices;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller



public class NewRecordController {
    @RequestMapping(value = "/newRecord", method = RequestMethod.GET)
    public String enter() {
        return "newRecord";
    }

    // метод добывает логин текущего пользователя
    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @RequestMapping(value = "/newRecord", method = RequestMethod.POST)
    public ModelAndView createRecord (@ModelAttribute RecordForm recordForm){

        RecordServices recordServices = new RecordServices();

        Record record = new Record();
        record.setAttached(false);
        record.setDate(recordForm.getDate());
        record.setNote(recordForm.getNote());
        record.setStatus(false);
        record.setBasket(false);
        record.setLogin(getCurrentUsername());
        recordServices.saveRecord(record);

        ModelAndView mav = new ModelAndView();

        mav.addObject("form", recordForm);
        mav.setViewName("../static/index");
        return mav;
    }
}


