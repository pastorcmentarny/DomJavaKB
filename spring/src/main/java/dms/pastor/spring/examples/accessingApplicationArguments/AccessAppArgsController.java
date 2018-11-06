package dms.pastor.spring.examples.accessingApplicationArguments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Controller
public class AccessAppArgsController {

    private AccessAppArgsComponent accessAppArgsComponent;

    @Autowired
    public AccessAppArgsController(AccessAppArgsComponent accessAppArgsComponent) {
        this.accessAppArgsComponent = accessAppArgsComponent;
    }

    @GetMapping("/argument-list")
    public String displayArgsList(Model model) {
        model.addAttribute("list", accessAppArgsComponent.getArgsList());
        return "argsList";
    }
}
