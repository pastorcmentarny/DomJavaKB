package dms.pastor.spring.examples.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

import static dms.pastor.spring.examples.ExamplesURL.REST;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Controller
public class RestExampleController {

    private static final String footer = "Have a nice day!";
    private static final String template = "Good Morning %s !" + footer;
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(REST)
    public
    @ResponseBody
    Message getRestTemplateExample(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
        return new Message(counter.incrementAndGet(), String.format(template, name), LocalDate.now());
    }
}
