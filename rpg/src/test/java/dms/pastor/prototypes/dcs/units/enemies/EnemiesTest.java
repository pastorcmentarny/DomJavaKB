package dms.pastor.prototypes.dcs.units.enemies;

import dms.pastor.prototypes.dcs.units.Unit;
import org.junit.jupiter.api.Test;

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
