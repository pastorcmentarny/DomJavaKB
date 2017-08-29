package dms.pastor.game.dcs;

import dms.pastor.domain.exception.SomethingWentTerribleWrongError;
import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.game.dcs.conditions.ElementType;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static dms.pastor.game.dcs.conditions.ElementType.*;
import static dms.pastor.utils.StringUtils.getStringWithCapitalizedFirstCharacter;
import static java.lang.String.format;
import static java.util.Arrays.asList;
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

    @SuppressWarnings("OverlyComplexBooleanExpression") //it has 4 elements
    public boolean hasEnough(Elements elements) {
        return (elements.getAir() >= air) && (elements.getEarth() >= earth) && (elements.getFire() >= fire) && (elements.getWater() >= water);
    }

    public static Elements noElements() {
        return new Elements(0, 0, 0, 0);
    }

    public void displayElements() {
        System.out.printf(" Air:%d Earth:%d Fire:%d Water:%d%n", air, earth, fire, water);
    }

    //TODO improve it split into method that do something and return something
    public String addRandomElements(int addCardPerTurn) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 1; i <= addCardPerTurn; i++) {
            stringBuilder.append(" ");
            switch (random.nextInt(values().length)) {
                case 0:
                    air++;
                    stringBuilder.append(getElementName(AIR));
                    break;
                case 1:
                    earth++;
                    stringBuilder.append(getElementName(EARTH));
                    break;
                case 2:
                    fire++;
                    stringBuilder.append(getElementName(FIRE));
                    break;
                case 3:
                    water++;
                    stringBuilder.append(getElementName(WATER));
                    break;
                default:
                    System.out.println("bug in addRandomElements");
                    throw new SomethingWentTerribleWrongError();
            }
        }
        return stringBuilder.toString().trim();
    }

    private String getElementName(ElementType elementType) {
        return getStringWithCapitalizedFirstCharacter(elementType.name());
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

    public void addElement(ElementType elementsType, int number) {
        if (elementsType == null) {
            LOGGER.warn("Element type was null, while calling elementsType. Bug?");
            return;
        }
        switch (elementsType) {
            case AIR:
                air += number;
                break;
            case FIRE:
                fire += number;
                break;
            case EARTH:
                earth += number;
                break;
            case WATER:
                water += number;
                break;
            default:
                System.out.println("OH COCK, unimplemented element in addElement");
                break;
        }
    }

    public void addElement(ElementType elementsType) {
        addElement(elementsType, 1);
    }

    public List<ElementType> removeRandomElements(int numberOfElements) {
        List<ElementType> types = new ArrayList<>();
        for (int i = 1; i <= numberOfElements; i++) {
            final ElementType elementTypeToRemove = asList(values()).get(values().length - 1);
            useElement(elementTypeToRemove, 1);
            types.add(elementTypeToRemove);
        }
        return types;
    }

    public int getAndUseRandomElements() {
        int numberOfElements;
        switch (random.nextInt(values().length)) {
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

    public int countElements() {
        return air + earth + fire + water;
    }

    public int getElementsFor(ElementType elementType) {
        switch (elementType) {
            case AIR:
                return air;
            case EARTH:
                return earth;
            case FIRE:
                return fire;
            case WATER:
                return water;
            default:
                throw new SomethingWentWrongException("No implementation for " + elementType);
        }
    }

    public int useElement(ElementType elementType, int number) {
        switch (elementType) {
            case AIR:
                air -= number;
                return getAir();
            case FIRE:
                fire -= number;
                return getFire();
            case EARTH:
                earth -= number;
                return getEarth();
            case WATER:
                water -= number;
                return getWater();
            default:
                throw new SomethingWentWrongException("No implementation for " + elementType);
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

    public void setToZero() {
        air = 0;
        earth = 0;
        fire = 0;
        water = 0;
    }
}
