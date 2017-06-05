package dms.pastor.game.dcs;

import org.slf4j.Logger;

import java.util.Random;

import static java.lang.String.format;
import static java.util.Objects.hash;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-25
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class Elements {

    private static final Logger LOGGER = getLogger(Elements.class);


    private final Random random = new Random();
    private int fire = 0;
    private int water = 0;
    private int earth = 0;
    private int air = 0;
    private int life = 0;
    private int death = 0;

    public Elements(int air, int earth, int fire, int water, int life, int death) {
        this.fire = fire;
        this.water = water;
        this.earth = earth;
        this.air = air;
        this.life = life;
        this.death = death;
    }

    public Elements(int i) {
        addRandomElements(i);
    }

    public static Elements noElements() {
        return new Elements(0, 0, 0, 0, 0, 0);
    }

    public void displayElements() {
        System.out.printf(" Air:%d Earth:%d Fire:%d Water:%d Life:%d Death:%d%n", air, earth, fire, water, life, death);
    }

    public void addRandomElements(int addCardPerTurn) {
        for (int i = 1; i <= addCardPerTurn; i++) {
            switch (random.nextInt(6)) {
                case 0:
                    air++;
                    break;
                case 1:
                    earth++;
                    break;
                case 2:
                    fire++;
                    break;
                case 3:
                    water++;
                    break;
                case 4:
                    life++;
                    break;
                case 5:
                    death++;
                    break;
                default:
                    System.out.println("bug in addRandomElements");
                    break;
            }
        }
    }

    public boolean hasEnough(Elements elements) {
        return (elements.getAir() >= air) && (elements.getEarth() >= earth) && (elements.getFire() >= fire) && (elements.getWater() >= water) && (elements.getLife() >= life) && (elements.getDeath() >= death);
    }

    public boolean hasExactly(Elements elements) {
        return (elements.getAir() == air) && (elements.getEarth() == earth) && (elements.getFire() == fire) && (elements.getWater() == water) && (elements.getLife() == life) && (elements.getDeath() == death);
    }

    public int getFire() {
        return fire;
    }

    public void setFire(int fire) {
        this.fire = fire;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getEarth() {
        return earth;
    }

    public void setEarth(int earth) {
        this.earth = earth;
    }

    public int getAir() {
        return air;
    }

    public void setAir(int air) {
        this.air = air;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public void useElements(Elements spellElements) {
        fire -= spellElements.getFire();
        water -= spellElements.getWater();
        earth -= spellElements.getEarth();
        air -= spellElements.getAir();
        life -= spellElements.getLife();
        death -= spellElements.getDeath();
    }

    public void addElement(ElementsType elementsType) {
        if (elementsType == null) {
            LOGGER.warn("Element type was null, while calling elementsType. Bug?");
            return;
        }
        switch (elementsType) {
            case AIR:
                air++;
                break;
            case FIRE:
                fire++;
                break;
            case EARTH:
                earth++;
                break;
            case WATER:
                water++;
                break;
            case LIFE:
                life++;
                break;
            case DEATH:
                death++;
                break;
            default:
                System.out.println("OH COCK, unimplemented element in addElement");
                break;
        }
    }

    public void removeRandomElements(int numberOfElements) {
        for (int i = 1; i <= numberOfElements; i++) {
            switch (random.nextInt(6)) {
                case 0:
                    reduceAirElement();
                    break;
                case 1:
                    reduceEarthElement();
                    break;
                case 2:
                    reduceFireElement();
                    break;
                case 3:
                    reduceWaterElement();
                    break;
                case 4:
                    reduceLifeElement();
                    break;
                case 5:
                    reduceDeathElement();
                    break;
                default:
                    LOGGER.warn("bug in addRandomElements");
            }
        }
    }

    private void reduceDeathElement() {
        if (death > 0) {
            death--;
        }
    }

    private void reduceLifeElement() {
        if (life > 0) {
            life--;
        }
    }

    private void reduceWaterElement() {
        if (water > 0) {
            water--;
        }
    }

    private void reduceFireElement() {
        if (fire > 0) {
            fire--;
        }
    }

    private void reduceEarthElement() {
        if (earth > 0) {
            earth--;
        }
    }

    public int getAndUseRandomElements() {
        int numberOfElements;
        switch (random.nextInt(6)) {
            case 0:
                numberOfElements = air;
                return numberOfElements;
            case 1:
                numberOfElements = earth;
                return numberOfElements;
            case 2:
                numberOfElements = fire;
                return numberOfElements;
            case 3:
                numberOfElements = water;
                return numberOfElements;
            case 4:
                numberOfElements = life;
                return numberOfElements;
            case 5:
                numberOfElements = death;
                return numberOfElements;
            default:
                System.out.println("bug in getAndUseRandomElements");
                return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Elements)) return false;
        Elements elements = (Elements) o;
        return getFire() == elements.getFire() &&
                getWater() == elements.getWater() &&
                getEarth() == elements.getEarth() &&
                getAir() == elements.getAir() &&
                getLife() == elements.getLife() &&
                getDeath() == elements.getDeath();
    }

    @Override
    public int hashCode() {
        return hash(getFire(), getWater(), getEarth(), getAir(), getLife(), getDeath());
    }

    @Override
    public String toString() {
        return format("Elements{fire=%d, water=%d, earth=%d, air=%d, life=%d, death=%d}", fire, water, earth, air, life, death);
    }

    int countElements() {
        return air + earth + fire + water + life + death;
    }

    private void reduceAirElement() {
        if (air > 0) {
            air--;
        }
    }

}
