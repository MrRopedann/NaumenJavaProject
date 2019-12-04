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
public class EditingController {
    @RequestMapping(value = "/editing", method = RequestMethod.GET)

    public ModelAndView editGet (@ModelAttribute Record record) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/editing");
        mav.addObject("record", record);
        return mav;
    }

    @RequestMapping(value = "/editRecord", method = RequestMethod.POST)

    public String  editRecord (@ModelAttribute RecordForm recordForm){

        RecordServices recordServices = new RecordServices();
        Record record = recordServices.findById(recordForm.getId());

        record.setDate(recordForm.getDate());
        record.setNote(recordForm.getNote());
        record.setStatus(recordForm.isStatus());
        record.setBasket(recordForm.isBasket());
        record.setAttached(recordForm.isAttached());

        recordServices.updateRecord(record);

        return "redirect:/";
    }

}
