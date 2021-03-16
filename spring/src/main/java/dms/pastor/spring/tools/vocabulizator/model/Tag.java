package dms.pastor.spring.tools.vocabulizator.model;

import java.util.ArrayList;
import java.util.List;

public enum Tag {
    GENERAL("All other definitions that doe nop match to any category"),
    IT("Generic it terms");

    Tag(String description) {
    }

    public static List<Tag> getTagAsSingleList(Tag tag) {
        if (tag == null) {
            throw new IllegalArgumentException("You are moron! You need provide not null value");
        }
        List<Tag> singleTagList = new ArrayList<>();
        singleTagList.add(tag);
        return singleTagList;
    }

}
