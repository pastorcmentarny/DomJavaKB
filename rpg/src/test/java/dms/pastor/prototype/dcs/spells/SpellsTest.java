package dms.pastor.prototype.dcs.spells;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Author Dominik Symonowicz
 * Created 02/08/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class SpellsTest {

    @Test
    public void getRandomSpellShouldReturnSpell() {
        // when
        Spell spell = Spells.getRandomSpell();

        assertThat(spell).isInstanceOf(Spell.class);
    }
}
