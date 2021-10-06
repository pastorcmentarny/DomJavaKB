package dms.pastor.spring.exercises.calculator.controllers;

import dms.pastor.spring.exercises.calculator.models.Addition;
import dms.pastor.spring.exercises.calculator.models.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@RestController
public class AdditionController {
    private static final Logger logger = LoggerFactory.getLogger(AdditionController.class);

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Result add(@RequestBody Addition name) {
        logger.debug("Performing addition");
        return name.getAnswer();
    }

    @RequestMapping(value = "/getresult", method = RequestMethod.GET, produces = "application/json")
    public Result getResult(@RequestParam(value = "id") int id) {
        if (id < 1) {
            logger.warn("Invalid Id");
            throw new IllegalArgumentException("Invalid id");
        }
        return new Result(1L, id);
    }


}
