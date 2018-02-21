package dms.pastor.game.littlefighter;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 2009
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class Status {

    private boolean isPoisoned;
    private int lengthOfPoison;
    private boolean isBerserk;
    private boolean isWeak;
    private boolean isBlind;
    private boolean toBeGaga; //gaga - zdziecinnieć; zramoleć;

    public Status() {
        isPoisoned = false;
        isBerserk = false;
        isWeak = false;
        isBlind = false;
        toBeGaga = false;
    }

    public void purify() {
        isPoisoned = false;
        isBerserk = false;
        isWeak = false;
        isBlind = false;
        toBeGaga = false;
    }

    public String setActiveStatuses() {
        String activeStatuses = EMPTY_STRING;
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


    public void setPoisoned() {
        isPoisoned = true;
    }

    private void noPoison() {
        isPoisoned = false;
    }

    public boolean isItPoisoned() {
        return isPoisoned;
    }

    public void setBeserk() {
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

    public void decreaseLengthOfPoison() {
        lengthOfPoison--;
        if (lengthOfPoison == 0) {
            noPoison();
        }
    }

    public void setLengthOfPoison(int length) {
        this.lengthOfPoison = length + 2;
    }


}
