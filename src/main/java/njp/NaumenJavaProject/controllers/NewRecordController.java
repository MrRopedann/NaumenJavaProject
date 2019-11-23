package njp.NaumenJavaProject.controllers;
import njp.NaumenJavaProject.forms.RecordForm;
import njp.NaumenJavaProject.models.Record;

import njp.NaumenJavaProject.servises.RecordServices;

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

    @RequestMapping(value = "/newRecord", method = RequestMethod.POST)

    //rewright after create dao utils and services

    public ModelAndView createRecord (@ModelAttribute RecordForm recordForm){

        RecordServices recordServices = new RecordServices();

        Record record = new Record(); // для примера как записать в базу параметры
        record.setAttached(false);
        record.setDate(recordForm.getDate());
        record.setNote(recordForm.getNote());
        record.setStatus(false);
        record.setBasket(false);
       /* Users currentuser = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        record.setLogin(currentuser.getLogin());*/
        record.setLogin("c");


        recordServices.saveRecord(record);

        ModelAndView mav = new ModelAndView();

        mav.addObject("form", recordForm);
        mav.setViewName("../static/index");
        return mav;
    }
}


