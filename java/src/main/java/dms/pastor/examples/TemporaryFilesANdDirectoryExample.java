package dms.pastor.examples;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemporaryFilesANdDirectoryExample {
    private static final String customPrefix = "data_";
    private static final String customFileSuffix = ".txt";
    private static final Path customBaseDirectory = FileSystems.getDefault().getPath("/Users/symonowd/Dropbox/banana");

    public static void main(String[] args) throws IOException {
        getCurrentTemporaryFilesPath();
        createTemporaryFileWithPrefixAndSuffix();
        createTemporaryStorageWithExitOnClose();
    }

    private static void createTemporaryStorageWithExitOnClose() throws IOException {
        final Path tempDirectory = Files.createTempDirectory(customBaseDirectory, customPrefix);
        System.out.println(tempDirectory);
        Path fileOne = Files.createTempFile(customBaseDirectory, customPrefix, customFileSuffix);
        System.out.println(fileOne);
        Path fileTwo = Files.createTempFile(customBaseDirectory, customPrefix, customFileSuffix);
        System.out.println(fileTwo);

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(tempDirectory)) {

            tempDirectory.toFile().deleteOnExit();
            for (Path file : directoryStream) {
                file.toFile().deleteOnExit();
                System.out.println(file);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void createTemporaryFileWithPrefixAndSuffix() throws IOException {
        Path tmpCustomPrefixAndSuffix = Files.createTempFile(customPrefix, customFileSuffix);
        System.out.println(tmpCustomPrefixAndSuffix);
    }

    private static void getCurrentTemporaryFilesPath() {
        System.out.println(System.getProperty("java.io.tmpdir"));
    }
}
