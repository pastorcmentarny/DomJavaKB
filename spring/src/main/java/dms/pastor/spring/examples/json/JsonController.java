package dms.pastor.spring.examples.json;

import dms.pastor.spring.examples.rest.CuteDomainObject;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings("MagicNumber")
@RestController
public class JsonController {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JsonController.class);

    @GetMapping("/json")
    public CuteDomainObject getCuteDomainObjectAsJson() {
        CuteDomainObject cuteDomainObject = new CuteDomainObject("Name", new Random().nextInt(32));
        LOGGER.info("Getting Cute Domain Object with data: " + cuteDomainObject.toString());
        return cuteDomainObject;
    }

    @GetMapping(value = "/xml", produces = {"application/xml", "text/xml"})
    public CuteDomainObject getCuteDomainObjectAsXml() {
        CuteDomainObject cuteDomainObject = new CuteDomainObject("Name", new Random().nextInt(32));
        LOGGER.info("Getting Cute Domain Object with data: " + cuteDomainObject.toString());
        return cuteDomainObject;
    }

}
