package dms.pastor.spring.vocabulizator.check.model;

import java.util.ArrayList;
import java.util.List;

public enum Tag {
    AGILE("Agile related"),
    GENERAL("All other definitions that doe nop match to any category"),
    IT("Generic it terms");

    private final String description;

    Tag(String description) {
        this.description = description;
    }

    public static List<Tag> getTagAsSingleList(Tag tag) {
        if (tag == null) {
            throw new IllegalArgumentException("You are moron! You need provide not null value");
        }
        List<Tag> singleTagList = new ArrayList<>();
        singleTagList.add(tag);
        return singleTagList;
    }

    public String getDescription() {
        return description;
    }

    public String getName(){
        return this.name().substring(0,1).toUpperCase() + this.name().substring(1,this.name().length()).toLowerCase();
    }
}
