package dms.pastor.examples.java8.junk;

import lombok.AllArgsConstructor;

@AllArgsConstructor
final class Unit {
    private final String name;
    private final String description;
    private final int age;

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", age=" + age +
                '}';
    }
}
