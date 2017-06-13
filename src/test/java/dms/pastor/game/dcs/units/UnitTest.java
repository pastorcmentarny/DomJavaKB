package dms.pastor.game.dcs.units;

import dms.pastor.game.dcs.ElementsBuilder;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static dms.pastor.game.dcs.Config.INITIAL_SHIELD_POINTS;
import static dms.pastor.game.dcs.ElementsBuilder.elementsBuilder;
import static dms.pastor.game.dcs.ElementsType.AIR;
import static dms.pastor.game.dcs.ElementsType.DEATH;
import static dms.pastor.game.dcs.ElementsType.EARTH;
import static dms.pastor.game.dcs.ElementsType.FIRE;
import static dms.pastor.game.dcs.ElementsType.LIFE;
import static dms.pastor.game.dcs.ElementsType.WATER;
import static dms.pastor.game.dcs.units.Unit.DEFAULT_SHIELD_POINTS;
import static dms.pastor.game.dcs.units.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 28/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class UnitTest {

    static final int DEFAULT_NUMBER_OF_ELEMENTS = 10;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    @Test
    public void recreateShieldShouldCreateShield() throws Exception {
        // given
        final Unit unit = unitBuilder()
                .shielded(false)
                .sp(0)
                .build();
        // when
        unit.recreateShield();

        // then
        assertThat(unit.isShielded());
        assertThat(unit.getSp()).isEqualTo(DEFAULT_SHIELD_POINTS);

    }

    @Test
    public void addHPBy5ShouldIncreaseHpBy5() throws Exception {
        // given
        final int initialHp = 20;
        final int healBy = 5;
        final int maxHp = initialHp + healBy + 1;
        final Unit unit = unitBuilder()
                .hp(initialHp)
                .maxHp(maxHp)
                .build();

        // when
        unit.addHP(healBy);

        // then
        assertThat(unit.getHp()).isEqualTo(initialHp + healBy);
    }

    @Test
    public void addHPToHpMoreThanMaxHpShouldGivesMaxHp() throws Exception {
        // given
        final int initialHp = 20;
        final int healBy = 5;
        final Unit unit = unitBuilder()
                .hp(initialHp)
                .maxHp(initialHp)
                .build();

        // when
        unit.addHP(healBy);

        // then
        assertThat(unit.getHp()).isEqualTo(initialHp);
    }

    @Test
    public void createShieldShouldEnableShieldAndSetInitialSPValue() throws Exception {
        // given
        final Unit unit = unitBuilder()
                .shielded(false)
                .sp(0)
                .build();
        final int initialShieldPoints = 20;

        // when
        unit.createShield(initialShieldPoints);

        // then
        assertThat(unit.isShielded()).isTrue();
        assertThat(unit.getSp()).isEqualTo(initialShieldPoints);

    }

    @Test
    public void createShieldShouldDoNothingIfUnitIsShieldedAlready() throws Exception {
        // given
        System.setOut(new PrintStream(outputStream));
        final int initialSp = 10;
        final Unit unit = unitBuilder()
                .shielded(true)
                .sp(initialSp)
                .build();

        // when
        unit.createShield(INITIAL_SHIELD_POINTS);

        // then
        assertThat(unit.isShielded()).isTrue();
        assertThat(unit.getSp()).isEqualTo(initialSp);
        assertThat(outputStream.toString()).contains("Name has shield already.");

        outputStream.close();
        System.setOut(original);
    }

    @Test
    public void increaseShieldByShouldIncreaseSpBy5() throws Exception {
        // given
        final Unit unit = unitBuilder()
                .sp(DEFAULT_NUMBER_OF_ELEMENTS)
                .build();

        // when
        unit.increaseShieldBy(5);

        // then
        assertThat(unit.getSp()).isEqualTo(15);

    }

    @Test
    public void getElementForShouldReturnAirElementsForAirType() {
        // given
        final int airElements = DEFAULT_NUMBER_OF_ELEMENTS;
        final Unit unit = unitBuilder()
                .elements(elementsBuilder()
                        .setToOneForAllElements()
                        .air(airElements)
                        .build())
                .build();

        // when
        final int elements = unit.getElementsFor(AIR);

        // then
        assertThat(elements).isEqualTo(airElements);
    }

    @Test
    public void getElementForShouldReturnEarthElementsForEarthType() {
        // given
        final int earthElements = DEFAULT_NUMBER_OF_ELEMENTS;
        final Unit unit = unitBuilder()
                .elements(elementsBuilder()
                        .setToOneForAllElements()
                        .earth(earthElements)
                        .build())
                .build();

        // when
        final int elements = unit.getElementsFor(EARTH);

        // then
        assertThat(elements).isEqualTo(earthElements);
    }

    @Test
    public void getElementForShouldReturnFireElementsForFireType() {
        // given
        final int fireElements = DEFAULT_NUMBER_OF_ELEMENTS;
        final Unit unit = unitBuilder()
                .elements(elementsBuilder()
                        .setToOneForAllElements()
                        .fire(fireElements)
                        .build())
                .build();

        // when
        final int elements = unit.getElementsFor(FIRE);

        // then
        assertThat(elements).isEqualTo(fireElements);
    }

    @Test
    public void getElementForShouldReturnWaterElementsForWaterType() {
        // given
        final int waterElements = DEFAULT_NUMBER_OF_ELEMENTS;
        final Unit unit = unitBuilder()
                .elements(elementsBuilder()
                        .setToOneForAllElements()
                        .water(waterElements)
                        .build())
                .build();

        // when
        final int elements = unit.getElementsFor(WATER);

        // then
        assertThat(elements).isEqualTo(waterElements);
    }

    @Test
    public void getElementForShouldReturnLifeElementsForLifeType() {
        // given
        final int lifeElements = DEFAULT_NUMBER_OF_ELEMENTS;
        final Unit unit = unitBuilder()
                .elements(elementsBuilder()
                        .setToOneForAllElements()
                        .life(lifeElements)
                        .build())
                .build();

        // when
        final int elements = unit.getElementsFor(LIFE);

        // then
        assertThat(elements).isEqualTo(lifeElements);
    }

    @Test
    public void getElementForShouldReturnDeathElementsForDeathType() {
        // given
        final int deathElements = DEFAULT_NUMBER_OF_ELEMENTS;
        final Unit unit = unitBuilder()
                .elements(elementsBuilder()
                        .setToOneForAllElements()
                        .death(deathElements)
                        .build())
                .build();

        // when
        final int elements = unit.getElementsFor(DEATH);

        // then
        assertThat(elements).isEqualTo(deathElements);
    }

    @Test
    public void getElementForShouldReturnZeroForNull() {
        // given
        final Unit unit = unitBuilder()
                .elements(ElementsBuilder.elementsBuilder().setToOneForAllElements().build())
                .build();

        // when
        final int elements = unit.getElementsFor(null);

        // then
        assertThat(elements).isEqualTo(0);
        //TODO test log too
    }

    @Test
    public void setElementForShouldSetAirElementsForAirType() {
        // given
        final Unit unit = unitBuilder()
                .elements(elementsBuilder()
                        .setToOneForAllElements()
                        .build())
                .build();

        // when
        unit.setElementsFor(AIR, DEFAULT_NUMBER_OF_ELEMENTS);

        // then
        assertThat(unit.getElements().getAir()).isEqualTo(DEFAULT_NUMBER_OF_ELEMENTS);
    }

    @Test
    public void setElementForShouldReturnEarthElementsForEarthType() {
        // given
        final Unit unit = unitBuilder()
                .elements(elementsBuilder()
                        .setToOneForAllElements()
                        .build())
                .build();

        // when
        unit.setElementsFor(EARTH, DEFAULT_NUMBER_OF_ELEMENTS);

        // then
        assertThat(unit.getElements().getEarth()).isEqualTo(DEFAULT_NUMBER_OF_ELEMENTS);
    }

    @Test
    public void setElementForShouldReturnFireElementsForFireType() {
        // given
        final Unit unit = unitBuilder()
                .elements(elementsBuilder()
                        .setToOneForAllElements()
                        .build())
                .build();

        // when
        unit.setElementsFor(FIRE, DEFAULT_NUMBER_OF_ELEMENTS);

        // then
        assertThat(unit.getElements().getFire()).isEqualTo(DEFAULT_NUMBER_OF_ELEMENTS);
    }

    @Test
    public void setElementForShouldReturnWaterElementsForWaterType() {
        // given
        final Unit unit = unitBuilder()
                .elements(elementsBuilder()
                        .setToOneForAllElements()
                        .build())
                .build();

        // when
        unit.setElementsFor(WATER, DEFAULT_NUMBER_OF_ELEMENTS);

        // then
        assertThat(unit.getElements().getWater()).isEqualTo(DEFAULT_NUMBER_OF_ELEMENTS);
    }

    @Test
    public void setElementForShouldReturnLifeElementsForLifeType() {
        // given
        final Unit unit = unitBuilder()
                .elements(elementsBuilder()
                        .setToOneForAllElements()
                        .build())
                .build();

        // when
        unit.setElementsFor(LIFE, DEFAULT_NUMBER_OF_ELEMENTS);

        // then
        assertThat(unit.getElements().getLife()).isEqualTo(DEFAULT_NUMBER_OF_ELEMENTS);
    }

    @Test
    public void setElementForShouldReturnDeathElementsForDeathType() {
        // given
        final Unit unit = unitBuilder()
                .elements(elementsBuilder()
                        .setToOneForAllElements()
                        .build())
                .build();

        // when
        unit.setElementsFor(DEATH, DEFAULT_NUMBER_OF_ELEMENTS);

        // then
        assertThat(unit.getElements().getDeath()).isEqualTo(DEFAULT_NUMBER_OF_ELEMENTS);
    }
}