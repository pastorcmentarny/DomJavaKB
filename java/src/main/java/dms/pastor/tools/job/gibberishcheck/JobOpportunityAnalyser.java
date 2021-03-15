package dms.pastor.tools.job.gibberishcheck;

import java.util.List;

class JobOpportunityAnalyser {

    public JobOpportunityAnalyser(String[] args) {
        load(args);
    }

    private void load(String[] args) {
        var email = DataLoader.loadEmailFromRecruiter(args[1]);
        List<String> words = JobDescriptionToWordsConverter.convert(email);
        //data = new Data(DataLoader.loadDictionary(args[0]), words);
    }

    public String analyse() {
        throw new RuntimeException("not implemented yet");
/*
        CrapCounter crapCounter = new CrapCounter(data);
        final CounterResult result = crapCounter.count();
        return getResult(result);
 */
    }

}
