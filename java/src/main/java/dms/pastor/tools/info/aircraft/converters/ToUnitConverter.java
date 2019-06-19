package dms.pastor.tools.info.aircraft.converters;

public class ToUnitConverter {

    public static String toMetersAsString(int centimeters) {
        if (centimeters > 100) {
            return Math.abs(centimeters / 100) + "." + (centimeters % 100) + "m";
        } else {
            return centimeters + "cm";
        }
    }

}
