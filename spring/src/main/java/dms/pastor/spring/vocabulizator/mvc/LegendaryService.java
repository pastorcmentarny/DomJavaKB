package dms.pastor.spring.vocabulizator.mvc;

import org.springframework.stereotype.Service;

import java.util.UUID;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@Service
public class LegendaryService implements ServiceInterface {

    public void send(UUID id, RemarkableMessage remarkableMessage) {
        System.out.println(format("Created treasure %s with id: %s", remarkableMessage.getId(), id.toString()));
    }

}
