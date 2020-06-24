package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.units.Unit;
import dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("resource") // auto closable not essential
public final class InfoSpellTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void cleanUp() throws IOException {
        outputStream.close();
        System.setOut(original);
    }

    @Test
    public void castInfoSpellShouldDisplayInfoAboutUnit() {
        // given
        InfoSpell infoSpell = new InfoSpell();
        final Unit unit = UnitBuilder.unitBuilder()
            .hp(24)
            .sp(24)
            .maxHp(32)
            .build();

        // when
        infoSpell.castSpell(unit, unit);

        // then
        assertThat(outputStream.toString()).contains("Name casting Show Info on Name");
        assertThat(outputStream.toString()).contains("Name HP: 24/32| SP: 24");
    }
}