package dms.pastor.game.dcs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static dms.pastor.game.dcs.ElementsBuilder.elementsBuilder;
import static dms.pastor.game.dcs.ElementsType.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 27/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
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
        assertThat(elements.countElements()).isEqualTo(6);
    }

    @Test
    public void displayElementsShouldDisplayInformation() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        elements.displayElements();

        // then
        assertThat(outputStream.toString()).contains(String.format(" Air:%d Earth:%d Fire:%d Water:%d Life:%d Death:%d", 1, 1, 1, 1, 1, 1));
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

    @Test
    public void addElementWithLifeShouldLifeElementToElements() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        elements.addElement(LIFE);

        // then
        assertThat(elements.getLife()).isEqualTo(2);
    }

    @Test
    public void addElementWithDeathShouldDeathElementToElements() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        elements.addElement(DEATH);

        // then
        assertThat(elements.getDeath()).isEqualTo(2);
    }

    @Test //TODO IMPROVE IT
    public void addElementWithULLShouldDisplayWarningInLogs() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        elements.addElement(null);

        // then
        elements.displayElements();
        assertThat(outputStream.toString()).contains(String.format(" Air:%d Earth:%d Fire:%d Water:%d Life:%d Death:%d", 1, 1, 1, 1, 1, 1));

    }

    @Test
    public void removeRandomElementsShouldRemoveOneElement() {
        // given
        final Elements elements = elementsBuilder().setToOneForAllElements().build();

        // when
        elements.removeRandomElements(1);

        // then
        assertThat(elements.countElements()).isEqualTo(5);
    }
}
