package dms.pastor.snippets.decision;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class IsMatureVoter implements Vote {
    private static final int MATURITY_AGE = 18;

    @Override
    public boolean vote(Citizen citizen) {
        return citizen.age() >= MATURITY_AGE;
    }

    @Override
    public String getRejectionReason() {
        return String.format("You need to be %d years old.", MATURITY_AGE);
    }
}
