package dms.pastor.spring.tools.vocabulizator.db;

import dms.pastor.spring.tools.vocabulizator.model.Definition;

public interface DefinitionRepository {

    Definition findFirst(String query);

    Definition findByWord(String word);
}
