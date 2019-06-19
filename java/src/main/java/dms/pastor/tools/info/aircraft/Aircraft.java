package dms.pastor.tools.info.aircraft;

import lombok.Builder;
import lombok.Data;

import static dms.pastor.tools.info.aircraft.Config.KILOMETERS;
import static dms.pastor.tools.info.aircraft.Config.KPH;
import static dms.pastor.tools.info.aircraft.converters.ToUnitConverter.toMetersAsString;
import static java.lang.System.lineSeparator;

@Data
@Builder
public class Aircraft {
    private String model;
    private String variant;
    private String bodyType;
    private String role;
    private int cockpitCrew;
    private int passengerCapacityOneClass;
    private int length;
    private int wingspan;
    private int height;
    private int engines;
    private int cruiseSpeed;
    private int maxSpeed;
    private int range;
    private int fuelCapacity;

    public String info() {

        String aircraft = "Model: " + model + '(' + variant + ')' + lineSeparator() +
            "Body Type: " + bodyType + lineSeparator() +
            "Role: " + role + lineSeparator() +
            "Cockpit crew: " + cockpitCrew + lineSeparator() +
            "Passenger Capacity: " + passengerCapacityOneClass + lineSeparator() +
            "Length: " + toMetersAsString(length) + lineSeparator() +
            "Wingspan: " + toMetersAsString(wingspan) + lineSeparator() +
            "Height: " + toMetersAsString(height) + lineSeparator() +
            "Engines: " + engines + lineSeparator() +
            "Cruise Speed: " + cruiseSpeed + KPH + lineSeparator() +
            "Max Speed: " + cruiseSpeed + KPH + lineSeparator() +
            "Range: " + range + KILOMETERS + lineSeparator() +
            "Fuel Capacity: " + fuelCapacity + "l";
        return aircraft;
    }
}
