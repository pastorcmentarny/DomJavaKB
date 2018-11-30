package dms.pastor.spring.vocabulizator;

import dms.pastor.spring.vocabulizator.check.DefaultDefinitionService;
import dms.pastor.spring.vocabulizator.check.DefinitionSearchController;
import dms.pastor.spring.vocabulizator.check.model.Definition;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static dms.pastor.spring.vocabulizator.check.model.DefinitionBuilder.definitionBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.HttpStatus.OK;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@RunWith(MockitoJUnitRunner.class)
public class DefinitionSearchControllerTest {

/*
    @Rule
    public ExpectedException exception = ExpectedException.none();
*/

    @Mock
    private DefaultDefinitionService defaultDefinitionService;

    private DefinitionSearchController definitionSearchController;

    @Before
    public void setUp() {
        definitionSearchController = new DefinitionSearchController(defaultDefinitionService);
    }

    @Test
    public void shouldReturnDefinition() {
        // given
        final String definition = "test";
        final Definition expectedDefinition = definitionBuilder().build();
        given(defaultDefinitionService.getDefinitionFor(definition)).willReturn(expectedDefinition);

        // when
        final ResponseEntity result = definitionSearchController.getDefinitionFor(definition);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(OK);
        final String body = (String) result.getBody();
        assertThat(body).isEqualTo(expectedDefinition.toString());
        System.out.println(result);

    }
}