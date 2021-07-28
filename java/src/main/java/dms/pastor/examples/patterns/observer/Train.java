package dms.pastor.examples.patterns.observer;

import dms.pastor.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Train {
    private final int id;
    private final String name;
    private Location location;
    private final Publisher publisher;

    public void setLocation(Location location) {
        this.location = location;
        publisher.notifyObserver(this);
    }

    public String getInfo() {
        return "Train " + name + " (" + id + ") is at " + StringUtils.capitalizeWord(location.toString().toLowerCase());
    }
}
