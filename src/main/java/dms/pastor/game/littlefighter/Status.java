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
    // --Commented out by Inspection (21/02/2018 15:56):private boolean toBeGaga; //gaga - zdziecinnieć; zramoleć;

    public Status() {
        isPoisoned = false;
        isBerserk = false;
        isWeak = false;
        isBlind = false;
        //toBeGaga = false;
    }

    void purify() {
        isPoisoned = false;
        isBerserk = false;
        isWeak = false;
        isBlind = false;
        //toBeGaga = false;
    }

    String setActiveStatuses() {
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


    void setPoisoned() {
        isPoisoned = true;
    }

    private void noPoison() {
        isPoisoned = false;
    }

    boolean isItPoisoned() {
        return isPoisoned;
    }

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void noBerserk() {
//        isBerserk = false;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void setWeak() {
//        isWeak = true;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void noWeak() {
//        isWeak = false;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void setBlind() {
//        isBlind = true;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

    void decreaseLengthOfPoison() {
        lengthOfPoison--;
        if (lengthOfPoison == 0) {
            noPoison();
        }
    }

    void setLengthOfPoison(int length) {
        this.lengthOfPoison = length + 2;
    }


}
