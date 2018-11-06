package dms.pastor.spring.vocabulizator.mvc;

import java.util.UUID;

/**
 * Author Dominik Symonowicz
 * Created 15/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public interface ServiceInterface {

    void send(UUID id, RemarkableMessage remarkableMessage);
}
