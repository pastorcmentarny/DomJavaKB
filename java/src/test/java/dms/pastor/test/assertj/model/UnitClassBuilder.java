package dms.pastor.test.assertj.model;


public class UnitClassBuilder {


    private UnitClassBuilder() {
    }

    public static UnitClass buildCleric() {
        return UnitClass.build("Cleric");
    }

    public static UnitClass buildGenie() {
        return UnitClass.build("Genie");
    }

    public static UnitClass buildMage() {
        return UnitClass.build("Mage");
    }

    public static UnitClass buildVampire() {
        return UnitClass.build("Vampire");
    }
}
