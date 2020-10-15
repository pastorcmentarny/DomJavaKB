package dms.pastor.spring.tools.vocabulizator.model;


import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static dms.pastor.spring.DomUtils.generateString;


/**
 * Author Dominik Symonowicz
 * Created 26/10/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class DefinitionBuilder {
    private String word = generateString();
    private String meaning = generateString();
    private List<Tag> tags = Collections.singletonList(Tag.IT);

    private DefinitionBuilder() {
    }

    public static DefinitionBuilder definitionBuilder() {
        return new DefinitionBuilder();
    }

    public Definition build() {
        return new Definition(UUID.randomUUID(), word, meaning, tags);
    }

    public DefinitionBuilder word(String word) {
        this.word = word;
        return this;
    }

    public DefinitionBuilder meaning(String meaning) {
        this.meaning = meaning;
        return this;
    }

    public DefinitionBuilder tags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }
}
