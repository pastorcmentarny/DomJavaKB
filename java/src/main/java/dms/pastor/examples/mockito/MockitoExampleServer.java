package dms.pastor.examples.mockito;

import dms.pastor.domain.Treasure;

/**
 * Author Dominik Symonowicz
 * Created 09/09/2016
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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
        Treasure treasure = new Treasure("Mysterious Treasure", "This contains: " + awesomeRequest.data(), 1000);
        legendaryService.create(awesomeRequest.id(), treasure);
        return new MockitoExampleResponse();
    }
}