package dms.pastor.prototypes.dcs;

/**
 * Author Dominik Symonowicz
 * Created 30/03/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Entity {
    protected String name = "Name";
    private String description = "Description";

    protected Entity() {
    }

    protected Entity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    protected String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

}
