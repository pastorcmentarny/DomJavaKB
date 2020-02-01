package dms.pastor.tools.runs;

//https://www.depicus.com/swim-bike-run/pace-conversion-chart
public class ToSecondsPerKilometers {
    public static int transform(float kph) {
        if (kph < 0) {
            throw new IllegalArgumentException("kph is negative");
        }
        if (kph == 0) {
            return 0;
        }
        //second per kilometer = 60/ ÷ (kilometer per hour)
        return Float.valueOf(3600 / kph).intValue();
    }
}
