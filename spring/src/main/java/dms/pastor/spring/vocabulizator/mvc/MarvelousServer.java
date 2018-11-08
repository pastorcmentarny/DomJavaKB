package dms.pastor.spring.vocabulizator.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author Dominik Symonowicz
 * Created 09/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@Service
public class MarvelousServer {

    private final ServiceInterface legendaryService;

    @Autowired
    public MarvelousServer(ServiceInterface legendaryService) {
        this.legendaryService = legendaryService;
    }

}