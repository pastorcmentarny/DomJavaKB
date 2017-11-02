package dms.pastor.tools.tube;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataUploader {

    public List<Station> load(String path) {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            return lines.map(this::parseStation).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private <R> Station parseStation(String station) {
        return ToStationConverter.convert(station);
    }
}