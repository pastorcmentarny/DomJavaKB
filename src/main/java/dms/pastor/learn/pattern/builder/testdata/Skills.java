package dms.pastor.learn.pattern.builder.testdata;

import java.util.Objects;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 16/05/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class Skills {
    private int perception;
    private int strength;
    private int agility;

    public Skills(int perception, int strength, int agility) {
        this.perception = perception;
        this.strength = strength;
        this.agility = agility;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skills)) return false;
        Skills skills = (Skills) o;
        return perception == skills.perception &&
                strength == skills.strength &&
                agility == skills.agility;
    }

    @Override
    public int hashCode() {
        return Objects.hash(perception, strength, agility);
    }

    @Override
    public String toString() {
        return format("Skills{perception=%d, strength=%d, agility=%d}", perception, strength, agility);
    }
}