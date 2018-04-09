package dms.pastor.game.dcs.units;

import dms.pastor.game.dcs.ElementsBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static dms.pastor.game.dcs.Config.INITIAL_SHIELD_POINTS;
import static dms.pastor.game.dcs.ElementsBuilder.elementsBuilder;
import static dms.pastor.game.dcs.conditions.ConditionEntry.createTemporaryConditionWithDefaultDuration;
import static dms.pastor.game.dcs.conditions.ConditionType.BUBBLE_SHIELD;
import static dms.pastor.game.dcs.conditions.ElementType.*;
import static dms.pastor.game.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings("resource") // auto closable not essential
public class UnitTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UnitTest.class);

    private static final int DEFAULT_NUMBER_OF_ELEMENTS = 10;
    private static final int LARGE_SHIELD_POINTS = 256;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    @Test
    public void recreateShieldShouldSetSpToInitialSpIfCurrentSpIsHigher() {
        // given
        final Unit unit = unitBuilder()
                .shielded()
                .sp(LARGE_SHIELD_POINTS)
                .build();
        // when
        unit.recreateShield();

        // then
        assertThat(unit.isShielded());
        assertThat(unit.getSp()).isEqualTo(INITIAL_SHIELD_POINTS);
    }

    @Test
    public void recreateShieldShouldDoNotChangeIfCurrentSpIsLower() {
        // given
        final Unit unit = unitBuilder()
                .shielded()
                .sp(1)
                .build();
        // when
        unit.recreateShield();

        // then
        assertThat(unit.isShielded());
        assertThat(unit.getSp()).isEqualTo(1);
    }

    @Test
    public void recreateShieldShouldCreateShield() {
        // given
        final Unit unit = unitBuilder()
                .withoutShield()
                .sp(0)
                .build();
        // when
        unit.recreateShield();

        // then
        assertThat(unit.isShielded());
        assertThat(unit.getSp()).isEqualTo(INITIAL_SHIELD_POINTS);
    }

    @Test
    public void addHPBy5ShouldIncreaseHpBy5() {
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
    public void addHPToHpMoreThanMaxHpShouldGivesMaxHp() {
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
    public void createShieldShouldEnableShieldAndSetInitialSPValue() {
        // given
        final Unit unit = unitBuilder()
                .withoutShield()
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
        final Unit unit = unitBuilder()
                .shielded()
                .build();

        // when
        unit.createShield(INITIAL_SHIELD_POINTS);

        // then
        assertThat(unit.isShielded()).isTrue();
        assertThat(unit.getSp()).isEqualTo(INITIAL_SHIELD_POINTS);
        assertThat(outputStream.toString()).contains("Name has shield already.");

        outputStream.close();
        System.setOut(original);
    }

    @Test
    public void increaseShieldByShouldIncreaseSpBy5() {
        // given
        final Unit unit = unitBuilder()
                .sp(DEFAULT_NUMBER_OF_ELEMENTS)
                .build();
        final int expectedSp = 15;

        // when
        unit.increaseShieldBy(5);

        // then
        assertThat(unit.getSp()).isEqualTo(expectedSp);

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
        final int elements = unit.getElements().getElementsFor(AIR);

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
        final int elements = unit.getElements().getElementsFor(EARTH);

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
        final int elements = unit.getElements().getElementsFor(FIRE);

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
        final int elements = unit.getElements().getElementsFor(WATER);

        // then
        assertThat(elements).isEqualTo(waterElements);
    }

    @Test
    public void getElementForShouldReturnZeroForNull() {
        // given
        final Unit unit = unitBuilder()
                .elements(ElementsBuilder.elementsBuilder().setToOneForAllElements().build())
                .build();

        // when
        final int elements = unit.getElements().getElementsFor(null);

        // then
        assertThat(elements).isZero();
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
        unit.getElements().setElementsFor(AIR, DEFAULT_NUMBER_OF_ELEMENTS);

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
        unit.getElements().setElementsFor(EARTH, DEFAULT_NUMBER_OF_ELEMENTS);

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
        unit.getElements().setElementsFor(FIRE, DEFAULT_NUMBER_OF_ELEMENTS);

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
        unit.getElements().setElementsFor(WATER, DEFAULT_NUMBER_OF_ELEMENTS);

        // then
        assertThat(unit.getElements().getWater()).isEqualTo(DEFAULT_NUMBER_OF_ELEMENTS);
    }

    @Test
    public void isNotShieldedShouldReturnTrueIfUnitDoNotHaveShield() {
        // given
        final Unit unit = unitBuilder()
                .withoutShield()
                .build();

        // when
        final boolean isNotShielded = unit.isNotShielded();

        // then
        assertThat(isNotShielded).isTrue();
    }

    @Test
    public void isNotShieldedShouldReturnFalseIfUnitDoHaveShield() {
        // given
        final Unit unit = unitBuilder()
                .shielded()
                .build();

        // when
        final boolean isNotShielded = unit.isNotShielded();

        // then
        assertThat(isNotShielded).isFalse();
    }

    @Test
    public void setShieldToFalseShouldSetSpValueToZero() {
        // given
        final Unit unit = unitBuilder()
                .sp(LARGE_SHIELD_POINTS)
                .build();

        // when
        unit.setShielded(false);

        // then
        assertThat(unit.isShielded()).isFalse();
        assertThat(unit.isStrongShield()).isFalse();
        assertThat(unit.getSp()).isZero();
    }

    @Test //TODO flake test. fix it
    public void increaseHpPerTurnShouldIncreaseHpIfIsBelowMaxHp() {
        // given
        final int regenHpRate = 2;

        final Unit unit = unitBuilder()
                .hp(1)
                .hpRegenPerTurn(regenHpRate)
                .withoutShield()
                .build();

        // debug
        LOGGER.info(unit.toString());

        // when
        final int increase = unit.getHealth().increaseHpPerTurn();

        // then
        assertThat(increase).isEqualTo(regenHpRate);
        assertThat(unit.getHp()).isEqualTo(3);

    }

    @Test
    public void increaseHpPerTurnShouldIncreaseHpIfToMaxHp() {
        // given
        final int maxHp = 10;
        final int regenHpRate = 2;

        final Unit unit = unitBuilder()
                .hp(9)
                .maxHp(maxHp)
                .hpRegenPerTurn(regenHpRate)
                .withoutShield()
                .build();

        // when
        final int increase = unit.getHealth().increaseHpPerTurn();

        // then
        assertThat(increase).isEqualTo(1);
        assertThat(unit.getHp()).isEqualTo(maxHp);
    }

    @Test
    public void increaseHpPerTurnShouldNotIncreaseHpIfMaxHpIsLowerThanHp() {
        // given
        final int maxHp = 10;
        final int regenHpRate = 2;
        final int currentHp = 11;

        final Unit unit = unitBuilder()
                .hp(currentHp)
                .maxHp(maxHp)
                .hpRegenPerTurn(regenHpRate)
                .withoutShield()
                .build();

        // when
        final int increase = unit.getHealth().increaseHpPerTurn();

        // then
        assertThat(increase).isZero();
        assertThat(unit.getHp()).isEqualTo(currentHp);
    }

    @Test
    public void doesDamageToShouldNotDoesDamageInsteadItBurstBubble() {
        // given

        final int initialHp = 10;
        final Unit unit = unitBuilder()
                .hp(initialHp)
                .build();
        unit.getConditions().add(createTemporaryConditionWithDefaultDuration(BUBBLE_SHIELD));

        // when
        final int damage = unit.doesDamageTo(unit, 5);

        // then
        assertThat(damage).isZero();
        assertThat(unit.getHp()).isEqualTo(initialHp);
        assertThat(unit.getConditions().has(BUBBLE_SHIELD));
    }

    @Test
    public void doesDirectDamageToShouldNotDoesDamageInsteadItBurstBubble() {
        // given
        final int initialHp = 10;
        final int initialSp = 20;
        final Unit unit = unitBuilder()
                .hp(initialHp)
                .sp(initialSp)
                .build();
        unit.getConditions().add(createTemporaryConditionWithDefaultDuration(BUBBLE_SHIELD));

        // when
        unit.doesDirectDamage(5);

        // then
        assertThat(unit.getHp()).isEqualTo(initialHp);
        assertThat(unit.getSp()).isEqualTo(initialSp);
        assertThat(unit.getConditions().has(BUBBLE_SHIELD));
    }

    @Test
    public void doesShieldDamageToShouldNotDoesDamageInsteadItBurstBubble() {
        // given
        final int initialHp = 10;
        final int initialSp = 20;
        final Unit unit = unitBuilder()
                .hp(initialHp)
                .sp(initialSp)
                .build();
        unit.getConditions().add(createTemporaryConditionWithDefaultDuration(BUBBLE_SHIELD));

        // when
        unit.doesShieldDamage(5);

        // then
        assertThat(unit.getHp()).isEqualTo(initialHp);
        assertThat(unit.getSp()).isEqualTo(initialSp);
        assertThat(unit.getConditions().has(BUBBLE_SHIELD));
    }


}
