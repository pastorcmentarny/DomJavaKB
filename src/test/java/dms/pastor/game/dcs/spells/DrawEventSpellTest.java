package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.UnitBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public final class DrawEventSpellTest {

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(printStream);
    }

    @Test
    public void castDrawEventSpellShouldGenerateSomeEvents() {
        // given
        DrawEventSpell drawEventSpell = new DrawEventSpell();
        Unit unit = UnitBuilder.unitBuilder().build();

        // when
        drawEventSpell.castSpell(unit, unit);

        // then
        assertThat("Casting Draw an event spell.");
        assertThat(byteArrayOutputStream.toString()).contains("EVENT");
    }
}