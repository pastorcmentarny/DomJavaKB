package dms.pastor.tools.gibberishcheck;

import lombok.AllArgsConstructor;

import java.nio.file.FileSystems;

@AllArgsConstructor
public class GibberishCheckApplication {
    static final String BASE_PATH = FileSystems.getDefault().getPath(".").toAbsolutePath().toString();

    public static void main(String[] args) {
        args = new String[]{BASE_PATH + "/data/dict/recruiter-db.txt", BASE_PATH + "/src/test/resources/job-example.txt"};
        InputValidator.validateInput(args);
        JobOpportunityAnalyser jobOpportunityAnalyser = new JobOpportunityAnalyser(args);
        jobOpportunityAnalyser.analyse();
    }




}
