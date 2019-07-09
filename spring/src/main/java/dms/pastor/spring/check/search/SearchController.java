package dms.pastor.spring.check.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
