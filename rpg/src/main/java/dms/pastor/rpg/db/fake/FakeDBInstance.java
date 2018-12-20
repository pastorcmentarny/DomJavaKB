package dms.pastor.rpg.db.fake;

import dms.pastor.rpg.model.Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Author Dominik Symonowicz
 * Created 14/12/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * In the age, when you can simply spin up any awesome db in container,
 * Dom couldn't be bother. Dom create his own db. Why? For simplicity.
 */
public class FakeDBInstance {
    private List<Entry> entries;

    {
        entries = new ArrayList<>();
        IntStream.range(0, 10).forEach(entry -> entries.add(Entry.getRandomEntry()));
    }

    void addEntry(String word, String definition) {
        entries.add(new Entry(UUID.randomUUID(), word, definition, Entry.NO_PROVIDED));
    }

    Optional<Entry> getEntryById(UUID id) {
        return entries.stream().filter(entry -> entry.getId().equals(id)).findFirst();
    }

    List<Entry> getEntryByWordDefinition(String word) {
        return entries.stream().filter(entry -> entry.getWord().equalsIgnoreCase(word)).collect(Collectors.toList());
    }

    Optional<Entry> deleteEntryById(UUID id) {
        return entries.stream().filter(entry -> entry.getId().equals(id)).findFirst();
    }


    void listAllEntries() {
        entries.forEach(System.out::println);
    }

}
