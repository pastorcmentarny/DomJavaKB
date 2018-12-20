package dms.pastor.rpg.characteristics;

/**
 * @author Pastor
 * Created Feb 14, 2015 at 9:30:12 PM
 */
public class BattleStats extends Stats {
    private State state;

    public BattleStats(State state) {
        this.state = state;
    }

    public void updateState(State state) {
        this.state = state;
    }

    @Override
    public int getEvasion() {
        if (state.isWeak()) {
            return super.getEvasion() / 2;
        } else {
            return super.getEvasion();
        }

    }

    public void addHP(int hp) {
        setHP(getHP() + hp);
    }


}
