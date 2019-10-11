package dms.pastor.prototype.dcs.events;

import dms.pastor.prototype.dcs.units.Unit;
import dms.pastor.prototype.dcs.units.enemies.builders.PlayerBuilder;
import org.junit.Test;

import static dms.pastor.prototype.dcs.ElementsBuilder.elementsBuilder;
import static dms.pastor.prototype.dcs.units.HealthBuilder.healthBuilder;
import static dms.pastor.prototype.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

public class AntiMatterStormEventTest {
    private final AntiMatterStormEvent antiMatterStormEvent = new AntiMatterStormEvent();

    @Test
    public void antiMatterStormEventRarityShouldBeRare() {

        // when
        final Rarity rarity = antiMatterStormEvent.getRarity();

        // then
        assertThat(rarity).isEqualTo(Rarity.RARE);
    }

    @Test
    public void makeThingsHappenWillCauseDamagePerElementAndLoseHalfOfElements() {
        // given
        final Unit player = PlayerBuilder.playerBuilder()
            .health(healthBuilder()
                .hp(10)
                .arm(1)
                .build())
            .sp(10)

            .elements(elementsBuilder()
                .setToOneForAllElements()
                .build())
            .build();
        final Unit enemy = unitBuilder()
            .health(healthBuilder()
                .hp(10)
                .arm(1)
                .build())
            .sp(10)
            .elements(elementsBuilder()
                .setToOneForAllElements()
                .build())
            .build();
        // when
        antiMatterStormEvent.makeItHappen(player, enemy);

        // then
        assertThat(player.getHp()).isEqualTo(8);
        assertThat(player.getSp()).isEqualTo(6);
        assertThat(player.getElements().countElements()).isEqualTo(2);
        assertThat(enemy.getHp()).isEqualTo(8);
        assertThat(enemy.getSp()).isEqualTo(6);
        assertThat(enemy.getElements().countElements()).isEqualTo(2);

    }
}