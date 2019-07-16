package dms.pastor.spring.tools.vocabulizator;

import dms.pastor.spring.tools.vocabulizator.db.DefinitionDb;
import dms.pastor.spring.tools.vocabulizator.db.DefinitionRepository;
import dms.pastor.spring.tools.vocabulizator.search.DemoSearchService;
import dms.pastor.spring.tools.vocabulizator.search.SearchService;
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
