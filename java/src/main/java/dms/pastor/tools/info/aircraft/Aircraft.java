package dms.pastor.tools.info.aircraft;

import lombok.Builder;
import lombok.Data;

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
    private int speed;
    private int range;

    public String info() {
        String aircraft = "Model: " + model + '(' + variant + ')' + System.lineSeparator() +
            "Body Type: " + bodyType + System.lineSeparator() +
            "Role: " + role + System.lineSeparator() +
            "Cockpit crew: " + cockpitCrew + System.lineSeparator() +
            "Passenger Capacity: " + passengerCapacityOneClass + System.lineSeparator() +
            "Length: " + engines + System.lineSeparator() +
            "Wingspan: " + wingspan + System.lineSeparator() +
            "Height: " + height + System.lineSeparator() +
            "Engines: " + engines + System.lineSeparator() +
            "Speed: " + speed + System.lineSeparator() +
            "Range: " + range;
        return aircraft;
    }
}
