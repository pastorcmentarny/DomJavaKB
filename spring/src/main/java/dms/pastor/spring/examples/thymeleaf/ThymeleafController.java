package dms.pastor.spring.examples.thymeleaf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ThymeleafController {
    private static final Logger LOG = LoggerFactory.getLogger(ThymeleafController.class);

    @RequestMapping("/thymeleaf")
    public String thymeleaf(@RequestParam(value = "name", required = false, defaultValue = ":)") String name, Model model) {
        LOG.info("Displaying page using name{}", name);
        model.addAttribute("result", name);
        return "thymeleaf/thymeleaf";
    }

}
