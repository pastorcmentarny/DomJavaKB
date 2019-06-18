package dms.pastor.tools.info.aircraft;

import dms.pastor.tools.info.aircraft.converters.ToAircraftConverter;

import static dms.pastor.utils.file.TextFileUtils.loadFileFromResourceAsString;

public class DataFileManager {

    public static Aircraft getAircraftDataFromFile() {
        final var aircraft = loadFileFromResourceAsString("transport/airplane/airplanes.txt");
        return ToAircraftConverter.convert(aircraft);
    }
}
