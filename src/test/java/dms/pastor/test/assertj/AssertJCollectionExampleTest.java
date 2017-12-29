package dms.pastor.test.assertj;

import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.enemies.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static dms.pastor.game.dcs.units.enemies.builders.EnemyBuilder.enemyBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * Orginally used sometimes ago as part of learning aspectJ.
 * <p>
 * tag-test-assertj-collection
 * <p>
 * source: https://dzone.com/articles/assertj-and-collections-introduction
 */
public class AssertJCollectionExampleTest {

    private static final Cleric CLERIC = enemyBuilder().buildCleric();
    private static final Dummy DUMMY = enemyBuilder().buildDummy();
    private static final Genie GENIE = enemyBuilder().buildGenie();
    private static final Mage MAGE = enemyBuilder().buildMage();
    private static final Vampire VAMPIRE = enemyBuilder().buildVampire();

    private static List<Unit> getListOfEnemies() {
        List<Unit> enemies = new ArrayList<>(4);
        enemies.add(CLERIC);
        enemies.add(GENIE);
        enemies.add(MAGE);
        enemies.add(VAMPIRE);
        return enemies;
    }

    @Test
    public void checkIfSetupDataIsCorrect() {
        // when
        List<Unit> enemies = getListOfEnemies();

        // then
        assertThat(enemies).hasSize(4);
        assertThat(enemies).contains(CLERIC, GENIE, MAGE, VAMPIRE);
    }

    @Test
    public void containsExample() {
        // when
        List<Unit> enemies = getListOfEnemies();

        // then
        assertThat(enemies).contains(CLERIC, VAMPIRE);
    }

    @Test
    public void doesNotContainExample() {
        // when
        List<Unit> enemies = getListOfEnemies();

        // then
        assertThat(enemies).doesNotContain(DUMMY);
    }

    @Test
    public void containsExactlyInAnyOrderExample() {
        // when
        List<Unit> enemies = getListOfEnemies();

        // then
        assertThat(enemies).containsExactlyInAnyOrder(CLERIC, GENIE, MAGE, VAMPIRE);
        assertThat(enemies).containsExactlyInAnyOrder(MAGE, CLERIC, VAMPIRE, GENIE);
    }

    @Test
    public void containsExactlyExample() {
        // when
        List<Unit> enemies = getListOfEnemies();

        // then
        assertThat(enemies).containsExactly(CLERIC, GENIE, MAGE, VAMPIRE);
    }

    @Test
    public void containsOnlyOnceExample() {
        // when
        List<Unit> enemies = getListOfEnemies();

        // then
        assertThat(enemies).containsOnlyOnce(CLERIC, MAGE, VAMPIRE);
    }

    @Test
    public void extractingExample() {
        // when
        List<Unit> enemies = getListOfEnemies();

        // then
        assertThat(enemies).extracting(Unit::getArm)
                .containsExactly(0, 0, 0, 0);
    }
}
