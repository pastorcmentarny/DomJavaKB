package dms.pastor.learn.pattern.builder.testdata;

import java.util.UUID;

import static dms.pastor.learn.pattern.builder.testdata.SkillsBuilder.skillsBuilder;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;
import static java.util.UUID.randomUUID;

/**
 * Author Dominik Symonowicz
 * Created 16/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public final class UnitBuilder {
    private String name = generateString(10);
    private UUID id = randomUUID();
    private Skills skills = skillsBuilder().build();
    private int heathPoints = randomPositiveInteger(100);
    private int minimumDamage = randomPositiveInteger(10);
    private int maximumDamage = minimumDamage + 1 + randomPositiveInteger();
    private int armor = randomPositiveInteger(10);

    private UnitBuilder() {
    }

    public static UnitBuilder unitBuilder() {
        return new UnitBuilder();
    }

    public Unit build() {
        return new Unit(name, id, skills, heathPoints, minimumDamage, maximumDamage, armor);
    }

    public UnitBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UnitBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public UnitBuilder skills(Skills skills) {
        this.skills = skills;
        return this;
    }

    public UnitBuilder healthPoints(int heathPoints) {
        this.heathPoints = heathPoints;
        return this;
    }

    public UnitBuilder minimumDamage(int minimumDamage) {
        this.minimumDamage = minimumDamage;
        return this;
    }

    public UnitBuilder setMaximumDamage(int maximumDamage) {
        this.maximumDamage = maximumDamage;
        return this;
    }

    public UnitBuilder armor(int armor) {
        this.armor = armor;
        return this;
    }
}