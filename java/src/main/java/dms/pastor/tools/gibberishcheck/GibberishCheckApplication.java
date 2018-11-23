package dms.pastor.tools.gibberishcheck;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.utils.FileUtils;
import lombok.AllArgsConstructor;

import java.nio.file.FileSystems;
import java.util.Objects;

@AllArgsConstructor
public class GibberishCheckApplication {
        static String basePath = FileSystems.getDefault().getPath(".").toAbsolutePath().toString();

    public static void main(String[] args) {
        args = new String[]{basePath + "/data/dict/recruiter-db.txt", basePath + "/src/test/resources/job-example.txt"};
        InputValidator.validateInput(args);
        JobOpportunityAnalyser jobOpportunityAnalyser = new JobOpportunityAnalyser(args);
        jobOpportunityAnalyser.analyse();
    }




}
