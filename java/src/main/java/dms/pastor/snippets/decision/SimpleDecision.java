package dms.pastor.snippets.decision;

import java.util.List;
import java.util.stream.Collectors;

import static dms.pastor.utils.StringUtils.NEW_LINE;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class SimpleDecision implements Decision {
    private final List<Vote> votes;
    private final Citizen citizen;

    public SimpleDecision(List<Vote> voters, Citizen citizen) {
        this.votes = voters;
        this.citizen = citizen;
    }

    @Override
    public String getReasons() {
        final List<String> result = votes.stream()
            .filter(it -> !it.vote(citizen))
            .map(Vote::getRejectionReason)
            .collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder(citizen.getName());
        stringBuilder.append(" was rejected due:\n");
        result.forEach(reason -> stringBuilder.append(reason).append(NEW_LINE));
        stringBuilder.substring(0, stringBuilder.length() - 1);
        stringBuilder.trimToSize();
        return stringBuilder.toString();
    }

    @Override
    public boolean makeDecision() {
        return votes.stream().allMatch(it -> it.vote(citizen));
    }
}
