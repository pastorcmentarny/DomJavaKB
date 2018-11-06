package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.units.Unit;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class EnemiesTest {

    @Test
    public void getAllEnemiesShouldReturnListOfAllEnemies() {
        // when
        final List<Unit> allEnemies = Enemies.getAllEnemies();

        // then
        assertThat(allEnemies).hasSize(9);
    }
}
