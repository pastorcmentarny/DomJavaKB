package dms.pastor.spring.examples.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Controller
public class SpringFourPointThreeAnnotationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringFourPointThreeAnnotationController.class);
    private static final String REQUEST_MAPPING_EXAMPLE_PATH = "/request-mapping-example";

    @GetMapping(REQUEST_MAPPING_EXAMPLE_PATH)
    public String getMethodUsingGetMapping(Model model) {
        return processMethodRequest(model, "Get");
    }

    @PostMapping(REQUEST_MAPPING_EXAMPLE_PATH)
    public String postMethodUsingPostMapping(Model model) {
        return processMethodRequest(model, "Post");
    }

    @PutMapping(REQUEST_MAPPING_EXAMPLE_PATH)
    public String putMethodUsingPostMapping(Model model) {
        return processMethodRequest(model, "Put");
    }

    private String processMethodRequest(Model model, String methodType) {
        LOGGER.info("Received " + methodType + " method request");
        model.addAttribute("result", methodType.toUpperCase() + " METHOD RECEIVED");
        return "index";
    }

}
