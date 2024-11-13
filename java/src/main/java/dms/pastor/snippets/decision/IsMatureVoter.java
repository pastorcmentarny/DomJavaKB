package dms.pastor.snippets.decision;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class IsMatureVoter implements Vote {
    private static final int MATURITY_AGE = 18;

    @Override
    public boolean vote(Citizen citizen) {
        return citizen.getAge() >= MATURITY_AGE;
    }

    @Override
    public String getRejectionReason() {
        return String.format("You need to be %d years old.", MATURITY_AGE);
    }
}
