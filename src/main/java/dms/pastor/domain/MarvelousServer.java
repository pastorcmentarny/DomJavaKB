package dms.pastor.domain;

/**
 * Author Dominik Symonowicz
 * Created 09/09/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class MarvelousServer {

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