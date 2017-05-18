package dms.pastor.learn.pattern.builder.testdata;

import java.util.Objects;
import java.util.UUID;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 16/05/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class Unit {
    private String name;
    private UUID id;
    private Skills skills;
    private int heathPoints;
    private int minimumDamage;
    private int maximumDamage;
    private int armor;

    public Unit(String name, UUID id, Skills skills, int heathPoints, int minimumDamage, int maximumDamage, int armor) {
        this.name = name;
        this.id = id;
        this.skills = skills;
        this.heathPoints = heathPoints;
        this.minimumDamage = minimumDamage;
        this.maximumDamage = maximumDamage;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public int getHeathPoints() {
        return heathPoints;
    }

    public void setHeathPoints(int heathPoints) {
        this.heathPoints = heathPoints;
    }

    public int getMinimumDamage() {
        return minimumDamage;
    }

    public void setMinimumDamage(int minimumDamage) {
        this.minimumDamage = minimumDamage;
    }

    public int getMaximumDamage() {
        return maximumDamage;
    }

    public void setMaximumDamage(int maximumDamage) {
        this.maximumDamage = maximumDamage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Unit)) return false;
        Unit unit = (Unit) o;
        return heathPoints == unit.heathPoints &&
                minimumDamage == unit.minimumDamage &&
                maximumDamage == unit.maximumDamage &&
                armor == unit.armor &&
                Objects.equals(name, unit.name) &&
                Objects.equals(id, unit.id) &&
                Objects.equals(skills, unit.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, skills, heathPoints, minimumDamage, maximumDamage, armor);
    }

    @Override
    public String toString() {
        return format("Unit{name='%s', id=%s, skills=%s, heathPoints=%d, minimumDamage=%d, maximumDamage=%d, armor=%d}", name, id, skills, heathPoints, minimumDamage, maximumDamage, armor);
    }
}