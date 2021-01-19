package dms.pastor.examples.patterns;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class PatternRunner {
    private static final String LINE_SEPARATOR = "\n------\n";

    private String name;
    private String description;
    private String type;
    private String example;

    public void displayDefinition() {
        System.out.printf("The %s pattern (%s)\n\t%s." + LINE_SEPARATOR + "Example: %s" + LINE_SEPARATOR + "Read more here: kb/architecture/patterns.md" + LINE_SEPARATOR, getName(), getType(), getDescription(), getExample());
    }


}
