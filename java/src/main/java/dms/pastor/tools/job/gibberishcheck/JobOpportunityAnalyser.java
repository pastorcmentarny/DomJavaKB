package dms.pastor.tools.job.gibberishcheck;

import java.util.List;

class JobOpportunityAnalyser {
    private Data data;

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

    private String getResult(CounterResult result) {
        if (result.getPercentage() > 30) {
            return String.format("This job description contains too much recruiter's gibberish to be worth consider. Result %s%%.", result.getPercentageAsString());
        }
        if (result.getPercentage() > 5) {
            return String.format("This job description do not contains too much recruiter's gibberish. It is worth to be read. Result %s %%.", result.getPercentageAsString());
        }
        return "Job description is gibberish free!";
    }
}
