package dms.pastor.examples.mockito;

import dms.pastor.domain.Treasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

/**
 * Author Dominik Symonowicz
 * Created 09/09/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * tag-mockito, tag-argumentCaptor
 */
@ExtendWith(MockitoExtension.class)
public class MockitoExampleServerTest {

    @Captor
    private ArgumentCaptor<Treasure> treasureArgumentCaptor;

    @Mock
    private MockitoExampleService legendaryService;

    @InjectMocks
    private MockitoExampleServer marvelousServer;

    @BeforeEach
    public void setUp() {
        marvelousServer = new MockitoExampleServer(legendaryService);
    }

    @Test
    public void shouldCreateTreasureTest() {
        // given
        final UUID id = UUID.randomUUID();
        final MockitoExampleRequest awesomeRequest = new MockitoExampleRequest(id, generateString(10));

        // when
        final MockitoExampleResponse awesomeResponse = marvelousServer.create(awesomeRequest);

        // then
        assertThat(awesomeResponse.isSuccess()).isTrue();
    }


    //http://site.mockito.org/mockito/docs/current/org/mockito/Captor.html
    @Test
    public void professionalArgumentCaptorTest() {
        // given
        treasureArgumentCaptor = ArgumentCaptor.forClass(Treasure.class);

        // when
        final UUID id = UUID.randomUUID();
        final String diamondTreasure = "diamond";
        final MockitoExampleRequest awesomeRequest = new MockitoExampleRequest(id, diamondTreasure);
        final MockitoExampleResponse awesomeResponse = marvelousServer.create(awesomeRequest);

        // then
        verify(legendaryService).create(eq(id), treasureArgumentCaptor.capture());
        assertThat(treasureArgumentCaptor.getValue().getDescription()).contains(diamondTreasure);
        assertThat(awesomeResponse.isSuccess()).isTrue();
        assertThat(treasureArgumentCaptor.getValue().getValue()).isEqualTo(1000);
    }
}