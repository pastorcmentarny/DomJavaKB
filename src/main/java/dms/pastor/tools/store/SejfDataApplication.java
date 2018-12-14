package dms.pastor.tools.store;

import dms.pastor.utils.ValidatorUtils;

import java.io.File;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * loadData
 * saveData
 * addValue
 * displayValueFor
 * modifyValue
 * <p>
 * This is tool to collect some data in pseudo encrypted way. It does not offer any security!
 */
public class SejfDataApplication {

    public static void main(String[] args) {
        final String path = Paths.get(".").toAbsolutePath().normalize().toString() + "/src/main/resources/argos.dsf";
        args = new String[]{path, "test"};
        System.out.println(path);

        validate(args);
        StorageManager storageManager = new StorageManager(args[0]);
        ValueOperations valueOperations = new ValueOperations(storageManager, args[1]);
        new SejfCLI(valueOperations).menu();


    }

    @SuppressWarnings({"ConstantConditions", "ParameterCanBeLocal"}) //TODO temp only
    private static void validate(String[] args) {
        if (Objects.isNull(args) || args.length != 2) {
            throw new IllegalArgumentException("Set path to file  and access phrase.");
        }
        if (new File(args[0]).isFile()) {
            throw new IllegalArgumentException("Path to file is invalid.");
        }
        ValidatorUtils.validateIfNotEmpty(args[1], "access phrase");
    }
}
