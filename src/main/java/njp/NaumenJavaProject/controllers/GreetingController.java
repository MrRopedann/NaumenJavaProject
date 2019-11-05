package njp.NaumenJavaProject.controllers;

import njp.NaumenJavaProject.forms.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
    public class GreetingController {

        private static final String template = "Hello, %s!";

        @RequestMapping(value = "/greeting", method = RequestMethod.GET)
        public String greeting() {
            return "greeting";
        }

        @RequestMapping(value = "/greeting-post", method = RequestMethod.POST)
        public ModelAndView greetingpost(@ModelAttribute Greeting form) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("form", form);
            mav.setViewName("greetingpost");
            return mav;
        }
    }

