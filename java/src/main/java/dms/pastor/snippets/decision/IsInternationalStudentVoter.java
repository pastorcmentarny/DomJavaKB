package dms.pastor.snippets.decision;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class IsInternationalStudentVoter implements Vote {
    @Override
    public boolean vote(Citizen citizen) {
        return !citizen.isResident() && citizen.age() >= 16 && citizen.age() <= 26;
    }

    @Override
    public String getRejectionReason() {
        return "You need be an international student.";
    }
}
