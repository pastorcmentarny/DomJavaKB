package dms.pastor.snippets.decision;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class IsInternationalStudentVoter implements Vote {
    @Override
    public boolean vote(Citizen citizen) {
        return !citizen.isResident() && citizen.getAge() >= 16 && citizen.getAge() <= 26;
    }

    @Override
    public String getRejectionReason() {
        return "You need be an international student.";
    }
}
