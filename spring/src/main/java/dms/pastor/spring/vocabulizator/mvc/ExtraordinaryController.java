package dms.pastor.spring.vocabulizator.mvc;

import dms.pastor.spring.examples.ExamplesURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author Dominik Symonowicz
 * Created 14/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@RestController
public class ExtraordinaryController {

    private final MarvelousServer server;

    @Autowired
    public ExtraordinaryController(MarvelousServer server) {
        this.server = server;
    }

    @RequestMapping(ExamplesURL.MVC)
    public AwesomeResponse mvc(AwesomeRequest awesomeRequest) {

        return new AwesomeResponse(true);
    }
}
