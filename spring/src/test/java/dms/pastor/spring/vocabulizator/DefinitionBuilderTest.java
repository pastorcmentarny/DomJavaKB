package dms.pastor.spring.vocabulizator;

import dms.pastor.spring.tools.vocabulizator.model.Definition;
import dms.pastor.spring.tools.vocabulizator.model.Tag;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static dms.pastor.spring.tools.vocabulizator.model.DefinitionBuilder.definitionBuilder;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static javax.swing.text.html.parser.DTDConstants.GENERAL;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 26/10/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class DefinitionBuilderTest {

    @Test
    public void shouldReturnBuilder() {
        // given
        final String meaning = generateString();
        final List<Tag> tags = new ArrayList<>(GENERAL);
        final String word = generateString();

        String expectedResult = "Definition{" +
            "word='" + word + '\'' +
            ", definition='" + meaning + '\'' +
            ", tags=" + tags +
            '}';

        final Definition definition = definitionBuilder()
            .meaning(meaning)
            .word(word)
            .tags(tags)
            .build();

        // then
        assertThat(expectedResult).isEqualTo(definition.toString());

    }
}