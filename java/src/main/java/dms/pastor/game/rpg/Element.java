package dms.pastor.game.rpg;

/**
 * Everything extends from Element
 *
 * @author domhome
 */
public class Element {
    protected String name;
    protected String description;

    public Element() {
    }

    public Element(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name + " :{ " + description + "}:\n";
    }


}
