package dms.pastor.game.dcs;

import dms.pastor.game.dcs.conditions.ElementType;
import org.slf4j.Logger;

import java.util.Random;

import static java.lang.String.format;
import static java.util.Objects.hash;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-25
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Elements {

    private static final Logger LOGGER = getLogger(Elements.class);

    private final Random random = new Random();
    private int fire = 0;
    private int water = 0;
    private int earth = 0;
    private int air = 0;

    public Elements(int air, int earth, int fire, int water) {
        this.fire = fire;
        this.water = water;
        this.earth = earth;
        this.air = air;
    }

    public Elements(int i) {
        addRandomElements(i);
    }

    public static Elements noElements() {
        return new Elements(0, 0, 0, 0);
    }

    public void displayElements() {
        System.out.printf(" Air:%d Earth:%d Fire:%d Water:%d%n", air, earth, fire, water);
    }

    public void addRandomElements(int addCardPerTurn) {
        for (int i = 1; i <= addCardPerTurn; i++) {
            switch (random.nextInt(ElementType.values().length)) {
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
                default:
                    System.out.println("bug in addRandomElements");
                    break;
            }
        }
    }

    @SuppressWarnings("OverlyComplexBooleanExpression") //it has 4 elements
    public boolean hasEnough(Elements elements) {
        return (elements.getAir() >= air) && (elements.getEarth() >= earth) && (elements.getFire() >= fire) && (elements.getWater() >= water);
    }

    @SuppressWarnings("OverlyComplexBooleanExpression") //it has 4 elements
    public boolean hasExactly(Elements elements) {
        return (elements.getAir() == air) && (elements.getEarth() == earth) && (elements.getFire() == fire) && (elements.getWater() == water);
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

    public void useElements(Elements spellElements) {
        fire -= spellElements.getFire();
        water -= spellElements.getWater();
        earth -= spellElements.getEarth();
        air -= spellElements.getAir();
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
            default:
                System.out.println("OH COCK, unimplemented element in addElement");
                break;
        }
    }

    public void removeRandomElements(int numberOfElements) {
        for (int i = 1; i <= numberOfElements; i++) {
            switch (random.nextInt(ElementType.values().length)) {
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
                default:
                    LOGGER.warn("bug in addRandomElements");
            }
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
        switch (random.nextInt(ElementType.values().length)) {
            case 0:
                numberOfElements = air;
                setAir(0);
                return numberOfElements;
            case 1:
                numberOfElements = earth;
                setEarth(0);
                return numberOfElements;
            case 2:
                numberOfElements = fire;
                setFire(0);
                return numberOfElements;
            case 3:
                numberOfElements = water;
                setWater(0);
                return numberOfElements;
            default:
                System.out.println("bug in getAndUseRandomElements");
                return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Elements elements = (Elements) o;
        return fire == elements.fire &&
                water == elements.water &&
                earth == elements.earth &&
                air == elements.air;
    }

    @Override
    public int hashCode() {
        return hash(fire, water, earth, air);
    }

    @Override
    public String toString() {
        return format("Elements{fire=%d, water=%d, earth=%d, air=%d}", fire, water, earth, air);
    }

    public int countElements() {
        return air + earth + fire + water;
    }

    private void reduceAirElement() {
        if (air > 0) {
            air--;
        }
    }

}
