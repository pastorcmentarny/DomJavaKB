package dms.pastor.spring.check.stats;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static dms.pastor.spring.check.Paths.DICTIONARY_STATISTIC;

@RestController
public class StatsController {
    private static final Logger LOG = LoggerFactory.getLogger(StatsController.class);

    @GetMapping(DICTIONARY_STATISTIC)
    public Map<String, String> getStatisticForDictionary() {
        LOG.info("Getting stats for rpg");
        final HashMap<String, String> summary = new HashMap<>();
        summary.put("words", "0");
        LOG.info("Returning stats for rpg");
        return summary;
    }

}
