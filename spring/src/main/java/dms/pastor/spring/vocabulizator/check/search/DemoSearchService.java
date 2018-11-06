package dms.pastor.spring.vocabulizator.check.search;

import dms.pastor.spring.vocabulizator.check.db.DefinitionRepository;
import dms.pastor.spring.vocabulizator.check.model.Definition;
import dms.pastor.spring.vocabulizator.check.model.exception.ResultNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class DemoSearchService implements SearchService {

    private final DefinitionRepository repository;

    public DemoSearchService(DefinitionRepository repository) {
        this.repository = repository;
    }

    @Override
    public SearchResponse getResultFor(String query) {
        validateQuery(query);
        final Definition definition = repository.findFirst(query);
        final List<Definition> definitionArrayList = asDefinitionList(definition);

        return new SearchResponse(definitionArrayList);
    }

    private List<Definition> asDefinitionList(Definition definition) {
        final List<Definition> definitionArrayList = new ArrayList<>();
        definitionArrayList.add(definition);
        return definitionArrayList;
    }

    private void validateQuery(String query) {
        if (query == null) {
            throw new ResultNotFoundException("Query was not specified(null)");
        }

        if (query.isEmpty()) {
            throw new ResultNotFoundException("Query was not specified(empty)");
        }
    }

}
