package dms.pastor.tasks.fifinder;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
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
