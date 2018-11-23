package dms.pastor.tools.gibberishcheck;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.utils.FileUtils;

import java.util.Objects;

public class InputValidator {
    static void validateInput(String[] args) {
        if (Objects.isNull(args) || args.length != 2) {
            throw new SomethingWentWrongException("You need provide args with paths");
        }

        if (!FileUtils.isFilesExists(args)) {
            throw new SomethingWentWrongException("At least one of argument contains invalid path to file");
        }
    }
}
