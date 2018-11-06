package dms.pastor.spring.vocabulizator.check.db;

import dms.pastor.spring.vocabulizator.check.model.Definition;

public interface DefinitionRepository {

    Definition findFirst(String query);

    Definition findByWord(String word);
}
