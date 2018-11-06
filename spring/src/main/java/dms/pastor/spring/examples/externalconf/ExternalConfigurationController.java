package dms.pastor.spring.examples.externalconf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static dms.pastor.spring.examples.Paths.EXTERNAL_CONFIGURATION;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Controller
public class ExternalConfigurationController {

    @Value("valueFromCli")
    private String valueFromConfiguration;

    @RequestMapping(EXTERNAL_CONFIGURATION)
    public String externalConfigurationValue(Model model) {
        final String value = getValue();

        model.addAttribute("value", value);
        return "externalConfiguration";
    }

    private String getValue() {
        final String value;
        if (valueFromConfiguration != null) {
            value = valueFromConfiguration;
        } else {
            value = "Unknown";
        }
        return value;
    }
}
