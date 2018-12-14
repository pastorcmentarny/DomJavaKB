package dms.pastor.tools.store;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.joining;

public class StorageManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(StorageManager.class);
    private Map<String, String> dataStorage = new HashMap<>();
    private final String fileName;

    public StorageManager(String fileName) {
        this.fileName = fileName;
    }

    String loadContentFromFile() {
        File file = getStorageFile();

        try {
            return FileUtils.readFileToString(file, UTF_8);
        } catch (Exception e) {

        }
        return "";
    }

    String saveContentToFile() {
        File file = getStorageFile();
        try {
            FileUtils.writeStringToFile(file, convertDataStorageToString(), UTF_8);
        } catch (Exception exception) {
            LOGGER.warn(format("Unable to save file due %s", exception.getMessage()));
        }
        return "";
    }

    private String convertDataStorageToString() {
        return dataStorage.entrySet().stream().map(Map.Entry::toString).collect(joining(";", "[", "]"));
    }

    private File getStorageFile() {
        ClassLoader classLoader = StorageManager.class.getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }

    public Optional<String> get(String key) {
        return Optional.ofNullable(dataStorage.get(key));
    }

    public void put(String key, String value) {
        dataStorage.put(key, value);
    }


    public int size() {
        return dataStorage.size();
    }
}
