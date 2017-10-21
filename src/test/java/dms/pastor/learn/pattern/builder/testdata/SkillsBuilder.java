package dms.pastor.learn.pattern.builder.testdata;

import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;

/**
 * Author Dominik Symonowicz
 * Created 16/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings("unused")
public final class SkillsBuilder {

    private int perception = randomPositiveInteger(10);
    private int strength = randomPositiveInteger(10);
    private int agility = randomPositiveInteger(10);

    private SkillsBuilder() {
    }

    public static SkillsBuilder skillsBuilder() {
        return new SkillsBuilder();
    }

    public Skills build() {
        return new Skills(perception, strength, agility);
    }

    public SkillsBuilder setPerception(int perception) {
        this.perception = perception;
        return this;
    }

    public SkillsBuilder setStrength(int strength) {
        this.strength = strength;
        return this;
    }

    public SkillsBuilder setAgility(int agility) {
        this.agility = agility;
        return this;
    }
}