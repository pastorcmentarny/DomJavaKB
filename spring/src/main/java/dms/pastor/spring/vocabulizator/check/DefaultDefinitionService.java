package dms.pastor.spring.vocabulizator.check;

import dms.pastor.spring.vocabulizator.check.db.DefinitionRepository;
import dms.pastor.spring.vocabulizator.check.model.Definition;
import org.springframework.stereotype.Service;

/**
 * Author Dominik Symonowicz
 * Created 27/10/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@Service
public class DefaultDefinitionService implements DefinitionService {

    private final DefinitionRepository definitionRepository;

    public DefaultDefinitionService(DefinitionRepository definitionRepository) {
        this.definitionRepository = definitionRepository;
    }

    public Definition getDefinitionFor(String word) {
        return definitionRepository.findByWord(word);
    }
}
