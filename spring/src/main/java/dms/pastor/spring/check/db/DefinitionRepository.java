package dms.pastor.spring.check.db;

import dms.pastor.spring.check.model.Definition;

public interface DefinitionRepository {

    Definition findFirst(String query);

    Definition findByWord(String word);
}
