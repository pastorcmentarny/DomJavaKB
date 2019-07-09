package dms.pastor.spring.check;

import dms.pastor.spring.check.db.DefinitionDb;
import dms.pastor.spring.check.db.DefinitionRepository;
import dms.pastor.spring.check.search.DemoSearchService;
import dms.pastor.spring.check.search.SearchService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DictionaryConfiguration {

    @Bean
    public DefinitionRepository definitionRepository() {
        return new DefinitionDb();
    }

    @Bean
    public SearchService searchService(DefinitionRepository definitionRepository) {
        return new DemoSearchService(definitionRepository);
    }
}
