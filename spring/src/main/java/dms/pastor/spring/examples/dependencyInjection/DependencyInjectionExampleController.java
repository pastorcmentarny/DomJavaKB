package dms.pastor.spring.examples.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Controller
public class DependencyInjectionExampleController {

    private final DataService dataService;

    @Autowired
    public DependencyInjectionExampleController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping("/di")
    public String dependencyInjection(@RequestParam(required = false, defaultValue = "veryLongString") String text, Model model) {
        model.addAttribute("example", dataService.getData(text));
        return "di";
    }
}
