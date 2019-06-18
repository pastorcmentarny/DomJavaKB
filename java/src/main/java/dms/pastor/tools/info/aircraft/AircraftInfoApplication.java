package dms.pastor.tools.info.aircraft;

public class AircraftInfoApplication {

    public static void main(String[] args) {
        DataFileManager.getAircraftDataFromFile().forEach(System.out::println);
    }
}
