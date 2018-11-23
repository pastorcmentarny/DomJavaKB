package dms.pastor.tools.gibberishcheck;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.nio.file.FileSystems;
import java.util.List;

@Data
public class JobOpportunityAnalyser {

    private List<String> dictionary;
    private String job;

    public JobOpportunityAnalyser(String[] args){
       load(args);
    }

    private void load(String[] args) {
        dictionary = DataLoader.loadDictionary(args[0]);
        job = DataLoader.loadEmailFromRecruiter(args[1]);
    }

    public String analyse() {
        List<String> words = JobDescriptionToWordsConverter.convert(job);
        return null;
    }
}
