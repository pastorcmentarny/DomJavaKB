package dms.pastor.prototypes.dcs.units.enemies;

import dms.pastor.prototypes.dcs.spells.HealSpell;
import dms.pastor.prototypes.dcs.units.Unit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("resource") // auto closable not essential
public final class DummyTest {

    private static final Unit UNUSED_UNIT = null;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @BeforeEach
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(printStream);
    }

    @Test
    public void dummyShouldHealItselfIfHisHpIsLow() {
        // given
        Unit unit = new Dummy();
        final int initialHp = 3;
        unit.getHealth().setHp(initialHp);
        unit.setElements(new HealSpell().getElements());
        // when
        unit.turn(UNUSED_UNIT);

        // then
        assertThat(outputStream.toString()).contains(unit.getName() + " casting heal!");
        assertThat(unit.getHp()).isGreaterThan(initialHp);
    }
}