package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.units.Unit;
import dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("resource") // auto closable not essential
public final class DrawEventSpellTest {

    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @BeforeEach
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @AfterEach
    public void tearDown() {
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