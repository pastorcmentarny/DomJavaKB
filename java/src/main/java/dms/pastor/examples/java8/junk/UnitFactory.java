package dms.pastor.examples.java8.junk;

//U in this case is type parameter
public interface UnitFactory<U extends Unit> {
    U create(String name, String description, int age);

}
