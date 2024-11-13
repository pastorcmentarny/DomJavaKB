package dms.pastor.spring.examples.profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static dms.pastor.spring.examples.Paths.PROFILE_EXAMPLE;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@RestController
public class ProfileController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);

    private final String luckyNumber;

    @Autowired
    public ProfileController(String luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    @RequestMapping(PROFILE_EXAMPLE)
    public String profileExample() {
        LOGGER.info("Value used : " + luckyNumber);
        return luckyNumber; //If you  running spring using dom profile it should be 7.77 on default 13.13
    }
}
