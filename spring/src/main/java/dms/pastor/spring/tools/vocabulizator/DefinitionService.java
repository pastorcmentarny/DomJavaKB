package dms.pastor.spring.tools.vocabulizator;

import dms.pastor.spring.tools.vocabulizator.model.Definition;

/**
 * Author Dominik Symonowicz
 * Created 27/10/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public interface DefinitionService {

    Definition getDefinitionFor(String word);
}
