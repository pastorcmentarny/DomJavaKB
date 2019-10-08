package dms.pastor.tools.runs;

//https://www.depicus.com/swim-bike-run/pace-conversion-chart
public class ToMinutesPerKilometers {
    public static int transform(float kph) {
        if (kph < 0) {
            throw new IllegalArgumentException("kph is negative");
        }
        //minute per kilometer = 60/ ÷ (kilometer per hour)
        return 0;
    }
}
