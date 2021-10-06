package dms.pastor.examples.mockito;

import dms.pastor.domain.Treasure;

/**
 * Author Dominik Symonowicz
 * Created 09/09/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * this class is used as example for mockito
 * tag-mockito
 * tag-argumentCaptor
 */
class MockitoExampleServer {

    private final MockitoExampleService legendaryService;

    public MockitoExampleServer(MockitoExampleService legendaryService) {
        this.legendaryService = legendaryService;
    }

    public MockitoExampleResponse create(MockitoExampleRequest awesomeRequest) {
        Treasure treasure = new Treasure("Mysterious Treasure", "This contains: " + awesomeRequest.getData(), 1000);
        legendaryService.create(awesomeRequest.getId(), treasure);
        return new MockitoExampleResponse();
    }
}