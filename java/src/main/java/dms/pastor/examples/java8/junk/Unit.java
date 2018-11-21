package dms.pastor.examples.java8.junk;

public final class Unit {
    private final String name;
    private final String description;
    private final int age;

    public Unit(String name, String description, int age) {
        this.name = name;
        this.description = description;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", age=" + age +
                '}';
    }
}
