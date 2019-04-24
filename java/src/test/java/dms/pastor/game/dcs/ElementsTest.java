package dms.pastor.game.dcs;

import dms.pastor.game.dcs.conditions.ElementType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static dms.pastor.game.dcs.ElementsBuilder.elementsBuilder;
import static dms.pastor.game.dcs.conditions.ElementType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Author Dominik Symonowicz
 * Created 27/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings("resource") // auto closable not essential
public class ElementsTest {
    private static final Logger LOGGER = getLogger(ElementsTest.class);
    private static final int INIT_ELEMENTS = 10;
    private static final int USED_ELEMENTS = 4;
    private static final int ELEMENTS_LEFT = 6;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() {
        System.setOut(printStream);
    }

    @Test
    public void countElementsShouldReturn6IfElementsContainsOneOfEachElement() {
        // when
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // then
        assertThat(elements.countElements()).isEqualTo(4);
    }

    @Test
    public void displayElementsShouldDisplayInformation() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        elements.displayElements();

        // then
        assertThat(outputStream.toString()).contains(String.format(" Air:%d Earth:%d Fire:%d Water:%d", 1, 1, 1, 1));
    }

    @Test
    public void addElementWith5AirShouldAdd5AirElementToElements() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        elements.addElement(AIR, 5);

        // then
        assertThat(elements.getAir()).isEqualTo(6);
    }

    @Test
    public void addElementWithAirShouldAirElementToElements() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        elements.addElement(AIR);

        // then
        assertThat(elements.getAir()).isEqualTo(2);
    }

    @Test
    public void addElementWithEarthShouldEarthElementToElements() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        elements.addElement(EARTH);

        // then
        assertThat(elements.getEarth()).isEqualTo(2);
    }

    @Test
    public void addElementWithFireShouldFireElementToElements() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        elements.addElement(FIRE);

        // then
        assertThat(elements.getFire()).isEqualTo(2);
    }

    @Test
    public void addElementWithWaterShouldWaterElementToElements() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        elements.addElement(WATER);

        // then
        assertThat(elements.getWater()).isEqualTo(2);
    }

    @Test //TODO IMPROVE IT
    public void addElementWithULLShouldDisplayWarningInLogs() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        elements.addElement(null);

        // then
        elements.displayElements();
        assertThat(outputStream.toString()).contains(String.format(" Air:%d Earth:%d Fire:%d Water:%d", 1, 1, 1, 1));

    }

    @Test
    public void getElementsForShouldReturnAmountOfElementsForAir() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        int airCount = elements.getElementsFor(AIR);

        // then
        assertThat(airCount).isEqualTo(1);
    }

    @Test
    public void getElementsForShouldReturnOneElementForEarth() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        int airCount = elements.getElementsFor(EARTH);

        // then
        assertThat(airCount).isEqualTo(1);
    }

    @Test
    public void getElementsForShouldReturnAmountOfElementsForFire() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        int airCount = elements.getElementsFor(FIRE);

        // then
        assertThat(airCount).isEqualTo(1);
    }


    @Test
    public void getElementsForShouldReturnOneElementForWater() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        int airCount = elements.getElementsFor(WATER);

        // then
        assertThat(airCount).isEqualTo(1);
    }


    @Test
    public void removeRandomElementsShouldRemoveOneElement() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        final List<ElementType> elementType = elements.removeRandomElements(1);

        // then
        assertThat(elements.countElements()).isEqualTo(3);
        assertThat(elementType.size()).isEqualTo(1);

    }

    @Test
    public void useElementShouldUseFourAirElements() {
        // given
        final Elements elements = elementsBuilder()
            .air(INIT_ELEMENTS)
            .build();

        // when
        final int usedElementsCount = elements.useElement(AIR, USED_ELEMENTS);

        // then
        assertThat(usedElementsCount).isEqualTo(ELEMENTS_LEFT);
        assertThat(elements.getAir()).isEqualTo(ELEMENTS_LEFT);
    }

    @Test
    public void useElementShouldUseFourEarthElements() {
        // given
        final Elements elements = elementsBuilder()
            .earth(INIT_ELEMENTS)
            .build();

        // when
        final int usedElementsCount = elements.useElement(EARTH, USED_ELEMENTS);

        // then
        assertThat(usedElementsCount).isEqualTo(ELEMENTS_LEFT);
        assertThat(elements.getEarth()).isEqualTo(ELEMENTS_LEFT);
    }

    @Test
    public void useElementShouldUseFourFireElements() {
        // given
        final Elements elements = elementsBuilder()
            .fire(INIT_ELEMENTS)
            .build();

        // when
        final int usedElementsCount = elements.useElement(FIRE, USED_ELEMENTS);

        // then
        assertThat(usedElementsCount).isEqualTo(ELEMENTS_LEFT);
        assertThat(elements.getFire()).isEqualTo(ELEMENTS_LEFT);
    }

    @Test
    public void useElementShouldUseFourWaterElements() {
        // given
        final Elements elements = elementsBuilder()
            .water(INIT_ELEMENTS)
            .build();

        // when
        final int usedElementsCount = elements.useElement(WATER, USED_ELEMENTS);

        // then
        assertThat(usedElementsCount).isEqualTo(ELEMENTS_LEFT);
        assertThat(elements.getWater()).isEqualTo(ELEMENTS_LEFT);
    }

    @Test
    public void setToZeroSetsAllElementsToZero() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        elements.setToZero();

        // then
        assertThat(elements.countElements()).isZero();
        assertThat(elements.getAir()).isZero();
        assertThat(elements.getEarth()).isZero();
        assertThat(elements.getFire()).isZero();
        assertThat(elements.getWater()).isZero();
    }

    @Test
    public void addRandomElementsShouldReturnEmptyStringWhenAddingZeroElements() {
        // given
        final Elements elements = elementsBuilder().build();

        // when
        final String result = elements.addRandomElements(0);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void addRandomElementsShouldReturnEmptyString() {
        // given
        final Elements elements = elementsBuilder().build();

        // when
        final String result = elements.addRandomElements(1);

        // then
        assertThat(result).isNotEmpty();
        assertThat(elements.countElements()).isEqualTo(1);
        assertThat(result.length()).isGreaterThanOrEqualTo(3);

        // debug
        LOGGER.debug(result);
    }

    @Test //TODO RENAME IT
    public void addRandomElementsShouldReturnEmptyString2() {
        // given
        final Elements elements = elementsBuilder().build();

        // when
        final String result = elements.addRandomElements(2);
        System.out.println(result);
        // then
        assertThat(result).isNotEmpty();
        assertThat(elements.countElements()).isEqualTo(2);
        assertThat(result.length()).isGreaterThanOrEqualTo(7);

        // debug
        LOGGER.debug(result);
    }
}
