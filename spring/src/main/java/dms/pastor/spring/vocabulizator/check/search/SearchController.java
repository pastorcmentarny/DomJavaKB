package dms.pastor.spring.vocabulizator.check.search;

import dms.pastor.spring.vocabulizator.check.model.exception.ResultNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class SearchController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getResultFor(@RequestParam String searchPhrase) {
        LOGGER.info("Getting definition for word {}", searchPhrase);
        final SearchResponse response = searchService.getResultFor(searchPhrase);
        LOGGER.info("Got definition for word {}", searchPhrase);
        return response.toString();
    }

    @ExceptionHandler(ResultNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    void handleNotFoundException(final ResultNotFoundException uncaughtException) {
        LOGGER.error("Result not found ", uncaughtException);
    }

}
