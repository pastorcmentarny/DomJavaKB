package dms.pastor.tools.job.gibberishcheck;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.utils.file.FileUtils;

import java.util.Objects;

class InputValidator {
    static void validateInput(String[] args) {
        if (Objects.isNull(args) || args.length != 2) {
            throw new SomethingWentWrongException("You need provide args with paths");
        }

        if (!FileUtils.isFilesExists(args)) {
            throw new SomethingWentWrongException("At least one of argument contains invalid path to file");
        }
    }
}
