package dms.pastor.spring.check.db;

import dms.pastor.spring.check.model.Definition;
import dms.pastor.spring.check.model.exception.ResultNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static dms.pastor.spring.check.model.Definition.getTestDefinition;
import static dms.pastor.spring.check.model.Tag.IT;
import static dms.pastor.spring.check.model.Tag.getTagAsSingleList;


/**
 * This is just example of using Singleton patten.
 * In real application
 */
public class DefinitionDb implements DefinitionRepository {

    private List<Definition> definitionList;

    public DefinitionDb() {
        generateDummyData();
    }

    @Override
    public Definition findFirst(String query) {
        validateQuery(query);

        for (Definition definition : definitionList) {
            if (definition.getWord().equals(query)) {
                return definition;
            }
        }

        for (Definition definition : definitionList) {
            if (definition.getWord().contains(query)) {
                return definition;
            }
        }

        throw new ResultNotFoundException();
    }

    @Override //TODO improve it
    public Definition findByWord(String word) {
        return findFirst(word);
    }

    private void validateQuery(String query) {
        if (query == null) {
            throw new ResultNotFoundException("Query was not specified(null)");
        }

        if (query.isEmpty()) {
            throw new ResultNotFoundException("Query was not specified(empty)");
        }
    }

    private void generateDummyData() {
        definitionList = new ArrayList<>();
        definitionList.add(getTestDefinition());
        definitionList.add(new Definition(UUID.randomUUID(), "Test Driven Development", "Test-driven development is a technique to develop software.It is iterative approach of repetition of a very short development cycle : Write Test->Production Code->Run all tests. ", getTagAsSingleList(IT)));
        definitionList.add(new Definition(UUID.randomUUID(), "IT", "IT stands for Information Technology.The study or use of systems (especially computers and telecommunications) for information lifecycle (like create,send and so on)", getTagAsSingleList(IT)));
    }
}
