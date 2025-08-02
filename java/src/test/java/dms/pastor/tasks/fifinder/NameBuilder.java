package dms.pastor.tasks.fifinder;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
final class NameBuilder {

    private String first = generateString();
    private String middles = generateString();
    private String last = generateString();

    private NameBuilder() {
    }

    static NameBuilder nameBuilder() {
        return new NameBuilder();
    }

    Name build() {
        return new Name(first, middles, last);
    }

    NameBuilder first(String first) {
        this.first = first;
        return this;
    }

    NameBuilder middles(String middles) {
        this.middles = middles;
        return this;
    }

    NameBuilder last(String last) {
        this.last = last;
        return this;
    }

    NameBuilder withoutFirstName() {
        first(null);
        return this;
    }

    NameBuilder withoutMiddleName() {
        middles(null);
        return this;
    }

    NameBuilder withoutLastName() {
        last(null);
        return this;
    }
}
