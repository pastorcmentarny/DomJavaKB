package dms.pastor.prototypes.littlefighter;

import dms.pastor.utils.StringUtils;

/**
 * Author Dominik Symonowicz
 * Created 2009
 * WWW:	http:pastor.ovh.org
 * Github:	https:github.com/pastorcmentarny
 * Google Play:	https:play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class Status {

    private boolean isPoisoned;
    private int lengthOfPoison;
    private boolean isBerserk;
    private boolean isWeak;
    private boolean isBlind;

    public Status() {
        removeAllStatuses();
    }

    private void removeAllStatuses() {
        isPoisoned = false;
        isBerserk = false;
        isWeak = false;
        isBlind = false;
    }

    void purify() {
        removeAllStatuses();
    }

    String setActiveStatuses() {
        String activeStatuses = StringUtils.EMPTY_STRING;
        if (isPoisoned) {
            activeStatuses += "Poison ";
        }
        if (isBerserk) {
            activeStatuses += "Berserk ";
        }
        if (isWeak) {
            activeStatuses += "Weak ";

        }
        if (isBlind) {
            activeStatuses += "Blind ";
        }
        return activeStatuses;
    }


    void setPoisoned() {
        isPoisoned = true;
    }

    private void noPoison() {
        isPoisoned = false;
    }

    void setBerserk() {
        isBerserk = true;
    }

    public void noBerserk() {
        isBerserk = false;
    }

    public void setWeak() {
        isWeak = true;
    }

    public void noWeak() {
        isWeak = false;
    }

    public void setBlind() {
        isBlind = true;
    }

    void decreaseLengthOfPoison() {
        lengthOfPoison--;
        if (lengthOfPoison == 0) {
            noPoison();
        }
    }

    void setLengthOfPoison(int number) {
        this.lengthOfPoison = number;
    }

    public boolean isPoisoned() {
        return isPoisoned;
    }

    public int getLengthOfPoison() {
        return lengthOfPoison;
    }

    public boolean isBerserk() {
        return isBerserk;
    }

    public boolean isWeak() {
        return isWeak;
    }

    public boolean isBlind() {
        return isBlind;
    }
}
