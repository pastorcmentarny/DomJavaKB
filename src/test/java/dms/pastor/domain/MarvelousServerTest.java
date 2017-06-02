package dms.pastor.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 * Author Dominik Symonowicz
 * Created 09/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * tag-mockito, tag-argumentCaptor
 */
@RunWith(MockitoJUnitRunner.class)
public class MarvelousServerTest {

    @Captor
    private ArgumentCaptor<Treasure> treasureArgumentCaptor;

    @Mock
    private LegendaryService legendaryService;

    @InjectMocks
    private MarvelousServer marvelousServer;

    @Before
    public void setUp() throws Exception {
        marvelousServer = new MarvelousServer(legendaryService);
    }

    @Test
    public void shouldCreateTreasureTest() throws Exception {
        // given
        final UUID id = UUID.randomUUID();
        final AwesomeRequest awesomeRequest = new AwesomeRequest(id, generateString(10));

        // when
        final AwesomeResponse awesomeResponse = marvelousServer.create(awesomeRequest);

        // then
        assertThat(awesomeResponse.isSuccess()).isTrue();
    }

    /*
     http://site.mockito.org/mockito/docs/current/org/mockito/Captor.html
      */
    @Test
    public void professionalArgumentCaptorTest() {
        // given
        treasureArgumentCaptor = ArgumentCaptor.forClass(Treasure.class);

        // when
        final UUID id = UUID.randomUUID();
        final String diamondTreasure = "diamond";
        final AwesomeRequest awesomeRequest = new AwesomeRequest(id, diamondTreasure);
        final AwesomeResponse awesomeResponse = marvelousServer.create(awesomeRequest);

        // then
        verify(legendaryService).create(eq(id), treasureArgumentCaptor.capture());
        assertThat(treasureArgumentCaptor.getValue().getDescription()).contains(diamondTreasure);
        assertThat(awesomeResponse.isSuccess()).isTrue();
        assertThat(treasureArgumentCaptor.getValue().getValue()).isEqualTo(1000);
    }
}