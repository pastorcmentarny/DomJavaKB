package dms.pastor.domain;

/**
 * Author Dominik Symonowicz
 * Created 09/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class MarvelousServer {

    private final LegendaryService legendaryService;

    public MarvelousServer(LegendaryService legendaryService) {
        this.legendaryService = legendaryService;
    }

    public AwesomeResponse create(AwesomeRequest awesomeRequest) {
        Treasure treasure = new Treasure("Mysterious Treasure", "This contains: " + awesomeRequest.getData(), 1000);
        legendaryService.create(awesomeRequest.getId(), treasure);
        return new AwesomeResponse();
    }
}