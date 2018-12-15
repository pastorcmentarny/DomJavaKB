package dms.pastor.game.rpg.characteristics;

import java.util.ArrayList;

/**
 * @author domhome
 * <p>
 * you need set set/get , update , add to afterTurn and afterStep setXXX - set
 * state clearXXX - clear state updateXXXafterTurn - update state
 */
public class State {

    //POISON
    public boolean isPoisoned = false;
    private int poisonedTurnLeft = 0;
    private int poisonDamage = 0;
    private final ArrayList<Attribute> currentAttributes;
    //STUNNED
    private boolean stunned = false;
    private int stunnedTurns = 0;
    //WEAKNESS
    private boolean weak;
    private int weakTurns;
    //DISEASE
    private boolean disease;
    private int diseaseTurns;
    //CURSE
    private boolean curse = false;
    private int curseTurns;

    public State(ArrayList<Attribute> currentAttributes) {
        this.currentAttributes = currentAttributes;
    }

    public void afterStep() {
        System.out.println(updateAfterTurn());
    }

    public void afterTurn() {
        System.out.println(updateAfterTurn());
    }

    private String updateAfterTurn() {
        StringBuilder sb = new StringBuilder();
        if (isPoisoned) {
            poisonedTurnLeft--;
            if (poisonedTurnLeft < 1) {
                clearPoison();
            } else {
                sb.append("Poisoned(").append(poisonedTurnLeft).append(");");
            }
        }

        if (stunned) {
            stunnedTurns--;
            if (stunnedTurns < 1) {
                clearStun();
            } else {
                sb.append("Stunned(").append(stunnedTurns).append(");");

            }
        }

        if (weak) {
            weakTurns--;
            if (weakTurns < 1) {
                clearWeakness();
            } else {
                sb.append("Weakness(").append(weakTurns).append(");");
            }
        }

        if (disease) {
            diseaseTurns--;
            if (diseaseTurns < 1) {
                clearWeakness();
            } else {
                sb.append("Disease(").append(diseaseTurns).append(");");
            }
        }

        if (curse) {
            curseTurns--;
            if (curseTurns < 1) {
                clearCurse();
            } else {
                sb.append("Cursed(").append(curseTurns).append(");");
            }
        }

        return sb.toString();
    }

    public void setPoisoned(int turns, int damage) {
        isPoisoned = true;
        poisonedTurnLeft = turns;
        poisonDamage = damage;
        currentAttributes.add(Attribute.POISONED);
    }

    private void clearPoison() {
        isPoisoned = false;
        poisonedTurnLeft = -1;
        poisonDamage = 0;
        currentAttributes.remove(Attribute.POISONED);
    }

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(int turns) {
        stunned = true;
        stunnedTurns = turns;
        currentAttributes.add(Attribute.STUNNED);
    }

    private void clearStun() {
        stunned = false;
        stunnedTurns = 0;
        currentAttributes.remove(Attribute.STUNNED);
    }

    public void setWeakness(int turns) {
        weak = true;
        weakTurns = turns;
        currentAttributes.add(Attribute.WEAKNESS);
    }

    public boolean isWeak() {
        return weak;
    }

    private void clearWeakness() {
        weak = false;
        weakTurns = 0;
        currentAttributes.remove(Attribute.WEAKNESS);
    }

    public void setDisease(int turns) {
        disease = true;
        diseaseTurns = turns;
        currentAttributes.add(Attribute.DISEASE);
    }

    public boolean hasDisease() {
        return disease;
    }

    private void clearDisease() {
        disease = false;
        diseaseTurns = 0;
        currentAttributes.remove(Attribute.DISEASE);
    }

    public boolean isCursed() {
        return curse;
    }

    public void setCurse(int turns) {
        curse = true;
        curseTurns = turns;
        currentAttributes.add(Attribute.CURSE);
    }

    private void clearCurse() {
        disease = false;
        diseaseTurns = 0;
        currentAttributes.remove(Attribute.CURSE);
    }

    public void clearAllNegativeStates() {
        clearCurse();
        clearDisease();
        clearPoison();
        clearWeakness();
    }

}
