package dms.pastor.spring.examples.json;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class JsonObject {

    private String name;
    private int version;
    private boolean ok;

    public JsonObject() {
    }

    public JsonObject(String name, int version, boolean ok) {
        this.name = name;
        this.version = version;
        this.ok = ok;
    }

    @JsonIgnore
    private String ignoredField;

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    private boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    private String getIgnoredField() {
        return ignoredField;
    }

    public void setIgnoredField(String ignoredField) {
        this.ignoredField = ignoredField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonObject that = (JsonObject) o;
        return getVersion() == that.getVersion() &&
            isOk() == that.isOk() &&
            Objects.equals(getName(), that.getName()) &&
            Objects.equals(getIgnoredField(), that.getIgnoredField());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getVersion(), isOk(), getIgnoredField());
    }

    @Override
    public String toString() {
        return "JsonObject{" +
            "name='" + name + '\'' +
            ", version=" + version +
            ", ok=" + ok +
            ", ignoredField='" + ignoredField + '\'' +
            '}';
    }
}
