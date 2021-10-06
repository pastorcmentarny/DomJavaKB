package dms.pastor.test.assertj;

import dms.pastor.test.assertj.model.UnitClass;
import dms.pastor.test.assertj.model.UnitClassBuilder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * Originally used sometimes ago as part of learning aspectJ.
 * <p>
 * tag-test-assertj-collection
 * <p>
 * source: https://dzone.com/articles/assertj-and-collections-introduction
 */
public class AssertJCollectionExampleTest {

    private static final UnitClass CLERIC = UnitClassBuilder.buildCleric();
    private static final UnitClass DUMMY = UnitClass.buildDummy();
    private static final UnitClass GENIE = UnitClassBuilder.buildGenie();
    private static final UnitClass MAGE = UnitClassBuilder.buildMage();
    private static final UnitClass VAMPIRE = UnitClassBuilder.buildVampire();

    private static List<UnitClass> getListOfEnemies() {
        List<UnitClass> enemies = new ArrayList<>(4);
        enemies.add(CLERIC);
        enemies.add(GENIE);
        enemies.add(MAGE);
        enemies.add(VAMPIRE);
        return enemies;
    }

    @Test
    public void checkIfSetupDataIsCorrect() {
        // when
        List<UnitClass> enemies = getListOfEnemies();

        // then
        assertThat(enemies).hasSize(4);
        assertThat(enemies).contains(CLERIC, GENIE, MAGE, VAMPIRE);
    }

    @Test
    public void containsExample() {
        // when
        List<UnitClass> enemies = getListOfEnemies();

        // then
        assertThat(enemies).contains(CLERIC, VAMPIRE);
    }

    @Test
    public void doesNotContainExample() {
        // when
        List<UnitClass> enemies = getListOfEnemies();

        // then
        assertThat(enemies).doesNotContain(DUMMY);
    }

    @Test
    public void containsExactlyInAnyOrderExample() {
        // when
        List<UnitClass> enemies = getListOfEnemies();

        // then
        assertThat(enemies).containsExactlyInAnyOrder(CLERIC, GENIE, MAGE, VAMPIRE);
        assertThat(enemies).containsExactlyInAnyOrder(MAGE, CLERIC, VAMPIRE, GENIE);
    }

    @Test
    public void containsExactlyExample() {
        // when
        List<UnitClass> enemies = getListOfEnemies();

        // then
        assertThat(enemies).containsExactly(CLERIC, GENIE, MAGE, VAMPIRE);
    }

    @Test
    public void containsOnlyOnceExample() {
        // when
        List<UnitClass> enemies = getListOfEnemies();

        // then
        assertThat(enemies).containsOnlyOnce(CLERIC, MAGE, VAMPIRE);
    }

    @Test
    public void extractingExample() {
        // when
        List<UnitClass> enemies = getListOfEnemies();

        // then
        assertThat(enemies).extracting(UnitClass::getIq)
                .containsExactly(6, 5, 4, 7);
    }
}
