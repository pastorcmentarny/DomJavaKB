package dms.pastor.spring.tools.getdone.controllers;

import dms.pastor.spring.tools.getdone.commons.Status;
import dms.pastor.spring.tools.getdone.model.StatusMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@ControllerAdvice
public class ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public StatusMessage handleNumberFormatException(HttpServletRequest request, Exception ex) {
        logger.error("There was problem with handle request URL=" + request.getRequestURL() + " due " + ex.getMessage());
        return new StatusMessage(Status.ERROR.name(), "Something went wrong,so wrong.");

    }
}