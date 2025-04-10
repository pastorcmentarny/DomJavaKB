package dms.pastor.prototypes.dcs;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.prototypes.dcs.conditions.ElementType;
import dms.pastor.utils.StringUtils;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.String.format;
import static java.util.Objects.hash;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-25
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
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

    @SuppressWarnings("OverlyComplexBooleanExpression") //it has 4 elements
    public boolean hasEnough(Elements elements) {
        return (elements.getAir() >= air) && (elements.getEarth() >= earth) && (elements.getFire() >= fire) && (elements.getWater() >= water);
    }

    public void displayElements() {
        System.out.printf(" Air:%d Earth:%d Fire:%d Water:%d%n", air, earth, fire, water);
    }

    //TODO improve it split into method that do something and return something
    public String addRandomElements(int addCardPerTurn) {
        StringBuilder stringBuilder = new StringBuilder(StringUtils.EMPTY_STRING);
        for (int i = 1; i <= addCardPerTurn; i++) {
            stringBuilder.append(" ");
            switch (random.nextInt(ElementType.values().length)) {
                case 0 -> {
                    air++;
                    stringBuilder.append(getElementName(ElementType.AIR));
                }
                case 1 -> {
                    earth++;
                    stringBuilder.append(getElementName(ElementType.EARTH));
                }
                case 2 -> {
                    fire++;
                    stringBuilder.append(getElementName(ElementType.FIRE));
                }
                case 3 -> {
                    water++;
                    stringBuilder.append(getElementName(ElementType.WATER));
                }
                default -> { //TODO how to test this ?
                    System.out.println("bug in addRandomElements");
                    throw new SomethingWentWrongException();
                }
            }
        }
        return stringBuilder.toString().trim();
    }

    public int getElementsFor(ElementType elementsType) {
        if (elementsType == null) {
            LOGGER.warn("getElementsFor method was passed with null.");
            return 0;
        }

        switch (elementsType) {
            case AIR:
                return getAir();
            case EARTH:
                return getEarth();
            case FIRE:
                return getFire();
            case WATER:
                return getWater();
            default:
                LOGGER.warn("getElementsFor method is not implemented for " + elementsType);
                return 0;
        }
    }

    public void setElementsFor(ElementType elementsType, int number) {
        switch (elementsType) {
            case AIR -> setAir(number);
            case EARTH -> setEarth(number);
            case FIRE -> setFire(number);
            case WATER -> setWater(number);
            default -> LOGGER.warn("getElementsFor method is not implemented for " + elementsType + " with number of elements equals to " + number);
        }
    }

    private String getElementName(ElementType elementType) {
        return StringUtils.getStringWithCapitalizedFirstCharacter(elementType.name());
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
            case AIR -> air += number;
            case FIRE -> fire += number;
            case EARTH -> earth += number;
            case WATER -> water += number;
            default -> System.out.println("OH COCK, unimplemented element in addElement");
        }
    }

    public void addElement(ElementType elementsType) {
        addElement(elementsType, 1);
    }

    public List<ElementType> removeRandomElements(int numberOfElements) {
        List<ElementType> types = new ArrayList<>();
        for (int i = 1; i <= numberOfElements; i++) {
            final ElementType elementTypeToRemove = Arrays.asList(ElementType.values()).get(ElementType.values().length - 1);
            useElement(elementTypeToRemove, 1);
            types.add(elementTypeToRemove);
        }
        return types;
    }

    public int getAndUseRandomElements() {
        int numberOfElements;
        switch (random.nextInt(ElementType.values().length)) {
            case 0 -> {
                numberOfElements = air;
                setAir(0);
                return numberOfElements;
            }
            case 1 -> {
                numberOfElements = earth;
                setEarth(0);
                return numberOfElements;
            }
            case 2 -> {
                numberOfElements = fire;
                setFire(0);
                return numberOfElements;
            }
            case 3 -> {
                numberOfElements = water;
                setWater(0);
                return numberOfElements;
            }
            default -> {
                System.out.println("bug in getAndUseRandomElements");
                return 0;
            }
        }
    }

    public int countElements() {
        return air + earth + fire + water;
    }


    public int useElement(ElementType elementType, int number) {
        switch (elementType) {
            case AIR -> {
                air -= number;
                return getAir();
            }
            case FIRE -> {
                fire -= number;
                return getFire();
            }
            case EARTH -> {
                earth -= number;
                return getEarth();
            }
            case WATER -> {
                water -= number;
                return getWater();
            }
            default -> throw new SomethingWentWrongException("No implementation for " + elementType);
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
