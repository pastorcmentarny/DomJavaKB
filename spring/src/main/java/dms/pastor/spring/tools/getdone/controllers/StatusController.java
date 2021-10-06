package dms.pastor.spring.tools.getdone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Controller
public class StatusController {
    @RequestMapping("/ds1")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", ":)");
        return "welcome";
    }

    @RequestMapping("/ds2")
    public ModelAndView greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println(name);
        return new ModelAndView("index", "message", name);
    }

}
