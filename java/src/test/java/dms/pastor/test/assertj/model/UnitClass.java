package dms.pastor.test.assertj.model;


import dms.pastor.utils.randoms.RandomDataGenerator;

public class UnitClass {
    private final String name;
    private final int iq;
    private final boolean isDummy;

    private UnitClass(String name, int iq, boolean isDummy) {
        this.name = name;
        this.iq = iq;
        this.isDummy = isDummy;
    }

    public String getName() {
        return name;
    }

    public int getIq() {
        return iq;
    }

    public boolean isDummy() {
        return isDummy;
    }

    public static UnitClass build(String name) {
        return new UnitClass(name, name.length(), name.equalsIgnoreCase("dummy"));
    }

    public static UnitClass buildDummy() {
        return new UnitClass("Dummy no." + RandomDataGenerator.randomPositiveInteger(), 0, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitClass unitClass = (UnitClass) o;

        if (getIq() != unitClass.getIq()) return false;
        if (isDummy() != unitClass.isDummy()) return false;
        return getName() != null ? getName().equals(unitClass.getName()) : unitClass.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getIq();
        result = 31 * result + (isDummy() ? 1 : 0);
        return result;
    }
}
