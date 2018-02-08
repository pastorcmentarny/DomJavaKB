package dms.pastor.game.littlefighter;

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
    private boolean isBerserked;
    private boolean isWeak;
    private boolean isBlind;
    private boolean toBeGaga; //gaga - zdziecinnieć; zramoleć;

    public Status() {
        isPoisoned = false;
        isBerserked = false;
        isWeak = false;
        isBlind = false;
        toBeGaga = false;
    }

    public void purify() {
        isPoisoned = false;
        isBerserked = false;
        isWeak = false;
        isBlind = false;
        toBeGaga = false;
    }

    public String checkStatus() {
        String activeStatuses = "";
        if (isPoisoned) {
            activeStatuses += "Poison ";
        }
        if (isBerserked) {
            activeStatuses += "Beserk ";
        }
        if (isWeak) {
            activeStatuses += "Weak ";

        }
        if (isBlind) {
            activeStatuses += "Blind ";
        }
        return activeStatuses;
    }


    public void isPoisoned() {
        isPoisoned = true;
    }

    private void noPoison() {
        isPoisoned = false;
    }

    public boolean isItPoisoned() {
        return isPoisoned;
    }

    public void isBeserked() {
        isBerserked = true;
    }

    public void noBerserk() {
        isBerserked = false;
    }

    public void isWeak() {
        isWeak = true;
    }

    public void noWeak() {
        isWeak = false;
    }

    public void isBlind() {
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
