package dms.pastor.tasks.fifinder;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class NameBuilder {
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
