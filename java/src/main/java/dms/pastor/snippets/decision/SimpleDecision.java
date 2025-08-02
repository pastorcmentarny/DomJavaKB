package dms.pastor.snippets.decision;

import java.util.List;

import static dms.pastor.utils.StringUtils.NEW_LINE;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class SimpleDecision implements Decision {
    private final List<Vote> votes;
    private final Citizen citizen;

    public SimpleDecision(List<Vote> voters, Citizen citizen) {
        this.votes = voters;
        this.citizen = citizen;
    }

    public String getReasons() {
        final List<String> result = votes.stream()
                .filter(it -> !it.vote(citizen))
                .map(Vote::getRejectionReason)
                .toList();
        StringBuilder stringBuilder = new StringBuilder(citizen.name());
        stringBuilder.append(" was rejected due:\n");
        result.forEach(reason -> stringBuilder.append(reason).append(NEW_LINE));
        stringBuilder.substring(0, stringBuilder.length() - 1);
        stringBuilder.trimToSize();
        return stringBuilder.toString();
    }

    public boolean makeDecision() {
        return votes.stream().allMatch(it -> it.vote(citizen));
    }
}
