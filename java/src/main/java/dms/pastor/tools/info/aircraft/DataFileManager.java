package dms.pastor.tools.info.aircraft;

import dms.pastor.tools.info.aircraft.converters.ToAircraftConverter;

import java.util.List;

import static dms.pastor.utils.file.TextFileUtils.loadFileFromResourceAsListOfStrings;

public class DataFileManager {

    public static List<Aircraft> getAircraftDataFromFile() {
        final var aircraftList = loadFileFromResourceAsListOfStrings("transport/airplane/airplanes.txt");
        return ToAircraftConverter.convert(aircraftList);
    }
}
