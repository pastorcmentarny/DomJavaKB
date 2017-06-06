package dms.pastor.game.dcs.spells;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

public final class NoSpellTest {

    @Test
    public void getInstanceShouldReturnSingleInstanceOfNoSpell() {
        // given
        final NoSpell instanceOne = NoSpell.getInstance();

        // when
        final NoSpell instanceTwo = NoSpell.getInstance();

        // then
        assertThat(instanceOne.hashCode()).isEqualTo(instanceTwo.hashCode());
    }

    @Test
    public void noSpellSerializationTest() throws Exception {
        // given
        final NoSpell instanceOne = NoSpell.getInstance();
        final String tmpFileName = "noSpell.serialized";

        ObjectOutput objectToSerialize = new ObjectOutputStream(new FileOutputStream(
                tmpFileName));
        objectToSerialize.writeObject(instanceOne);
        objectToSerialize.close();

        // when
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                tmpFileName));
        NoSpell instanceTwo = (NoSpell) in.readObject();
        in.close();

        // then
        assertThat(instanceOne.hashCode()).isEqualTo(instanceTwo.hashCode());

        // after
        new File(tmpFileName).deleteOnExit();
    }
}