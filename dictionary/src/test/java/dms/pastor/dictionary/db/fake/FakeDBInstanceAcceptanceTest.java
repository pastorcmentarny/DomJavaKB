package dms.pastor.dictionary.db.fake;

import dms.pastor.dictionary.model.Entry;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 14/12/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FakeDBInstanceAcceptanceTest {
    private FakeDBInstance db = new FakeDBInstance();

    @Test
    public void shouldAddEntryToDb() {
        // given
        var word = "word";
        var definition = "definition";

        // when
        db.addEntry(word, definition);

        // then
        final List<Entry> entries = db.getEntryByWordDefinition(word);
        assertThat(entries.get(0).getWord()).isEqualTo(word);
        assertThat(entries.get(0).getDefinition()).isEqualTo(definition);
        assertThat(entries.get(0).getSource()).isEqualTo(Entry.NO_PROVIDED);
    }

    @Test
    public void listAllEntries() {
        //when
        db.listAllEntries();

        // then it should display all entries
    }

}