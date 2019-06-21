package dms.pastor.tools.info.aircraft;

public class AirplaneFieldExtractor {
    private String[] fields;

    public AirplaneFieldExtractor(String[] fields) {
        this.fields = fields;
    }

    public String getModel() {
        return fields[0];
    }

    public String getVariant() {
        return fields[1];
    }

    public BodyType getBodyType() {
        return BodyType.getTypeFromLetter(fields[2]);
    }

    public Role getRole() {
        return Role.getTypeFromLetter(fields[3]);
    }

    public int getCockpitCrew() {
        return Integer.parseInt(fields[4]);
    }

    public int getPassengerCapacityOneClass() {
        return Integer.parseInt(fields[5]);
    }

    public int getLength() {
        return Integer.parseInt(fields[6]);
    }

    public int getWingspan() {
        return Integer.parseInt(fields[7]);
    }

    public int getHeight() {
        return Integer.parseInt(fields[8]);
    }

    public int getEngines() {
        return Integer.parseInt(fields[9]);
    }

    public int getCruiseSpeed() {
        return Integer.parseInt(fields[10]);
    }

    public int getMaxSpeed() {
        return Integer.parseInt(fields[11]);
    }

    public int getRange() {
        return Integer.parseInt(fields[12]);
    }

    public int getFuelCapacity() {
        return Integer.parseInt(fields[13]);
    }

}
