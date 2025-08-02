package dms.pastor.examples.patterns;

import lombok.Builder;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
@Builder
public record PatternInformation(String name, String description, String type, String example) {
    private static final String LINE_SEPARATOR = "\n------\n";

    public void displayDefinition() {
        System.out.printf("The %s pattern (%s)\n\t%s." + LINE_SEPARATOR + "Example: %s" + LINE_SEPARATOR + "Read more here: kb/architecture/patterns.md" + LINE_SEPARATOR, name(), type(), description(), example());
    }


}
