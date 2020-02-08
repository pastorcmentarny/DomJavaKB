package dms.pastor.tools.converters;

//https://www.depicus.com/swim-bike-run/pace-conversion-chart
public class ToSecondsPerKilometers {
    public static int transform(float kph) {
        if (kph < 0) {
            throw new IllegalArgumentException("kph is negative");
        }
        if (kph == 0) {
            return 0;
        }
        return Float.valueOf(3600 / kph).intValue();
    }
}
