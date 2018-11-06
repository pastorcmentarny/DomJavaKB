package dms.pastor.spring.vocabulizator.check;

import dms.pastor.spring.vocabulizator.check.model.Definition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.HttpStatus.OK;

/**
 * Author Dominik Symonowicz
 * Created 26/10/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@Controller
public class DefinitionSearchController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefinitionSearchController.class);

    private final DefaultDefinitionService defaultDefinitionService;

    @Autowired
    public DefinitionSearchController(DefaultDefinitionService defaultDefinitionService) {
        this.defaultDefinitionService = defaultDefinitionService;
    }


    @GetMapping("/definition")
    public ResponseEntity getDefinitionFor(@RequestParam String word) {
        if (isRequestNotValid(word)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        LOGGER.info("Getting definition for {}", word);
        final Definition def = defaultDefinitionService.getDefinitionFor(word);
        return new ResponseEntity<>(def.toString(), OK);
    }

    private boolean isRequestNotValid(String definition) {
        return StringUtils.isEmpty(definition);
    }
}
