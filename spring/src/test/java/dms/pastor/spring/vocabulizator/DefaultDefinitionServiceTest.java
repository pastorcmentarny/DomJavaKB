package dms.pastor.spring.vocabulizator;

import dms.pastor.spring.tools.vocabulizator.DefaultDefinitionService;
import dms.pastor.spring.tools.vocabulizator.db.DefinitionRepository;
import dms.pastor.spring.tools.vocabulizator.model.Definition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static dms.pastor.spring.tools.vocabulizator.model.DefinitionBuilder.definitionBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Author Dominik Symonowicz
 * Created 27/10/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@ExtendWith(MockitoExtension.class)
public class DefaultDefinitionServiceTest {

    @Mock
    private DefinitionRepository definitionRepository;


    private DefaultDefinitionService defaultDefinitionService;

    @BeforeEach
    public void setUp() {
        defaultDefinitionService = new DefaultDefinitionService(definitionRepository);

    }

    @Test
    public void shouldReturnDefinition() {
        // given
        final String definition = "test";
        final Definition expectedDefinition = definitionBuilder().build();
        given(definitionRepository.findByWord(definition)).willReturn(expectedDefinition);
        // when
        final Definition result = defaultDefinitionService.getDefinitionFor(definition);

        // then
        assertThat(result).isNotNull();
        assertThat(result.toString()).isEqualTo(expectedDefinition.toString());
        System.out.println(result);

    }
}