package dms.pastor.spring.vocabulizator.check.model;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static dms.pastor.spring.vocabulizator.check.model.Tag.GENERAL;
import static dms.pastor.spring.vocabulizator.check.model.Tag.getTagAsSingleList;
import static java.lang.String.format;

public class Definition {

    private String word;
    private String definition;
    private List<Tag> tags;

    public Definition(UUID guid, String word, String definition, List<Tag> tags) {
        this.word = word;
        this.definition = definition;
        this.tags = tags;
    }

    public static Definition getTestDefinition() {
        return new Definition(UUID.randomUUID(), "Test", "Test is a procedure for evaluation or check truth of something;", getTagAsSingleList(GENERAL));
    }

    public String getWord() {
        return word;
    }

    private String getDefinition() {
        return definition;
    }

    private List<Tag> getTags() {
        return tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Definition that = (Definition) o;
        return Objects.equals(getWord(), that.getWord()) &&
                Objects.equals(getDefinition(), that.getDefinition()) &&
                Objects.equals(getTags(), that.getTags());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWord(), getDefinition(), getTags());
    }

    @Override
    public String toString() {
        return format("Definition{word='%s', definition='%s', tags=%s}", word, definition, tags);
    }
}
