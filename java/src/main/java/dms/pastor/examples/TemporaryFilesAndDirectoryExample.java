package dms.pastor.examples;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemporaryFilesAndDirectoryExample {
    private static final String customPrefix = "data_";
    private static final String customFileSuffix = ".txt";
    private static final Path customBaseDirectory = FileSystems.getDefault().getPath("/Users/symonowd/Dropbox/banana");


     static String createTemporaryStorageWithExitOnClose() throws IOException {
        StringBuilder stringBuilder = new StringBuilder("");
        final Path tempDirectory = Files.createTempDirectory(customBaseDirectory, customPrefix);
        stringBuilder.append(tempDirectory);
        Path fileOne = Files.createTempFile(customBaseDirectory, customPrefix, customFileSuffix);
        stringBuilder.append(fileOne);
        Path fileTwo = Files.createTempFile(customBaseDirectory, customPrefix, customFileSuffix);
        stringBuilder.append(fileTwo);

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(tempDirectory)) {

            tempDirectory.toFile().deleteOnExit();
            for (Path file : directoryStream) {
                file.toFile().deleteOnExit();
                stringBuilder.append(file);
            }

        } catch (IOException ioException) {
            stringBuilder.append(ioException.getMessage());
        }

        return stringBuilder.toString();
    }

     static String createTemporaryFileWithPrefixAndSuffix() throws IOException {
        Path tmpCustomPrefixAndSuffix = Files.createTempFile(customPrefix, customFileSuffix);
        return tmpCustomPrefixAndSuffix.toString();
    }

     static String getCurrentTemporaryFilesPath() {
        return System.getProperty("java.io.tmpdir");
    }
}
