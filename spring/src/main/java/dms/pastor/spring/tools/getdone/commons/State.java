package dms.pastor.spring.tools.getdone.commons;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public enum State {
    CREATED(0),
    DRAFT(1),
    DELETED(2),
    BACKLOG(3),
    PLANNED(4),
    INPROGRESS(5),
    COMPLETED(6),
    ARCHIVED(7);

    private int state;

    public int state() {
        return state;
    }

    State(int state) {
        this.state = state;
    }

    //TODO temp validator method only
    public boolean isStateExists(String state) {
        for (State s : State.values()) {
            if (s.name().equalsIgnoreCase(state)) {
                return true;
            }
        }
        return false;
    }
}
