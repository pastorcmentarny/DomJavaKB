package dms.pastor.game.dcs;

import dms.pastor.game.dcs.conditions.ElementType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static dms.pastor.game.dcs.ElementsBuilder.elementsBuilder;
import static dms.pastor.game.dcs.ElementsType.AIR;
import static dms.pastor.game.dcs.ElementsType.EARTH;
import static dms.pastor.game.dcs.ElementsType.FIRE;
import static dms.pastor.game.dcs.ElementsType.WATER;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 27/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ElementsTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() throws Exception {
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
        int airCount = elements.getElementsFor(ElementType.AIR);

        // then
        assertThat(airCount).isEqualTo(1);
    }

    @Test
    public void getElementsForShouldReturnOneElementForEarth() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        int airCount = elements.getElementsFor(ElementType.EARTH);

        // then
        assertThat(airCount).isEqualTo(1);
    }

    @Test
    public void getElementsForShouldReturnAmountOfElementsForFire() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        int airCount = elements.getElementsFor(ElementType.FIRE);

        // then
        assertThat(airCount).isEqualTo(1);
    }


    @Test
    public void getElementsForShouldReturnOneElementForWater() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        int airCount = elements.getElementsFor(ElementType.WATER);

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
}
