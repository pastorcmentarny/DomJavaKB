package dms.pastor.game.rpg.characteristics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Skills {

    private static int noa = 6;
    private int strength;
    private int charisma;
    private int intelligence;
    private int vitality;
    private int dexterity; //zręczność,sprawność,zwinność)
    private int psychokinesis;

    private Skills() {
    }

    public Skills(int strength, int verbal, int intelligence, int vitality, int dexterity, int psychokinesis) {
        super();
        this.strength = strength;
        this.vitality = vitality;
        this.charisma = verbal;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.psychokinesis = psychokinesis;
    }


    private static Skills addToCharacteristic(Skills skills, int max, boolean psycho) {

        Random random = new Random();
        boolean notAdded = true;
        SkillsType[] tmp = SkillsType.values();
        ArrayList<SkillsType> skillsType = new ArrayList<>();
        skillsType.addAll(Arrays.asList(tmp));

        if (!psycho) {
            skillsType.remove(SkillsType.psychokinesis);
        }

        while (notAdded) {
            if (skillsType.isEmpty()) {
                notAdded = true;//TODO bug ?
                return skills;
            }
            int randomNumber = random.nextInt(skillsType.size());


            switch (skillsType.get(randomNumber)) {
                case charisma:
                    if (skills.charisma >= max) {
                        skillsType.remove(SkillsType.charisma);
                    } else {
                        skills.charisma++;
                        notAdded = false;
                    }
                    break;
                case dexterity:
                    if (skills.dexterity >= max) {
                        skillsType.remove(SkillsType.dexterity);
                    } else {
                        skills.dexterity++;
                        notAdded = false;
                    }
                    break;
                case intelligence:
                    if (skills.intelligence >= max) {
                        skillsType.remove(SkillsType.intelligence);
                    } else {
                        skills.intelligence++;
                        notAdded = false;
                    }
                    break;
                case psychokinesis:
                    if (psycho) {
                        if (skills.psychokinesis >= max) {
                            skillsType.remove(SkillsType.psychokinesis);
                        } else {
                            skills.psychokinesis++;
                            notAdded = false;
                        }
                    }
                    break;
                case strength:
                    if (skills.strength >= max) {
                        skillsType.remove(SkillsType.strength);
                    } else {
                        skills.strength++;
                        notAdded = false;
                    }
                    break;
                case vitality:
                    if (skills.vitality >= max) {
                        skillsType.remove(SkillsType.vitality);
                    } else {
                        skills.vitality++;
                        notAdded = false;
                    }
                    break;
            }

        }
        return skills;
    }

    public static void addRandomSkill(Skills skills, SkillsType[] types) {
        SkillsType[] selected = types == null ? SkillsType.values() : types;
        addSkillFromSkillType(skills, selected[new Random().nextInt(selected.length)]);
    }

    public static void addRandomSkillFromSkillType(Skills skills, SkillsType[] types) {
        SkillsType[] selected = types == null ? SkillsType.values() : types;
        addSkillFromSkillType(skills, selected[new Random().nextInt(selected.length)]);
    }

    private static void addSkillFromSkillType(Skills skills, SkillsType type) {
        switch (type) {
            case strength:
                skills.strength += 1;
                break;
            case charisma:
                skills.charisma += 1;
                break;
            case intelligence:
                skills.intelligence += 1;
                break;
            case vitality:
                skills.vitality += 1;
                break;
            case dexterity:
                skills.dexterity += 1;
                break;
            case psychokinesis:
                skills.psychokinesis += 1;
            default:
                //ERROR
        }
    }

    public static Skills generateZeroSkills() {
        return generateOneNumberForAllSkills(0, false);
    }

    public static Skills generateOneNumberForAllSkills(int i, boolean psycho) {
        if (psycho) {
            return new Skills(i, i, i, i, i, i);
        } else {
            return new Skills(i, i, i, i, i, 0);
        }
    }

    public static Skills generateRandomSkills(int pts, int max, boolean psycho, Skills initSkills) {

        Skills skills;

        if (initSkills != null) {
            skills = initSkills;
        } else {
            skills = new Skills(1, 1, 1, 1, 1, 0);
        }

        if (psycho) {
            skills.setPsychokinesis(2);
        }
        if (pts > noa) {
            for (int i = noa; i <= pts; i++) {
                switch (new Random().nextInt(noa)) {
                    case 0:
                        if (skills.getStrength() < max) {
                            skills.setStrength(skills.getStrength() + 1);
                        } else {
                            skills = addToCharacteristic(skills, max, psycho);
                        }

                        break;
                    case 1:
                        if (skills.getIntelligence() < max) {
                            skills.setIntelligence(skills.getIntelligence() + 1);
                        } else {
                            skills = addToCharacteristic(skills, max, psycho);
                        }
                        break;

                    case 2:
                        if (skills.getVitality() < max) {
                            skills.setVitality(skills.getVitality() + 1);
                        } else {
                            skills = addToCharacteristic(skills, max, psycho);
                        }
                        break;
                    case 3:
                        if (skills.getDexterity() < 10) {
                            skills.setDexterity(skills.getDexterity() + 1);
                        } else {
                            skills = addToCharacteristic(skills, max, psycho);
                        }
                        break;
                    case 4:
                        if (skills.getCharisma() < max) {
                            skills.setCharisma(skills.getCharisma() + 1);
                        } else {
                            skills = addToCharacteristic(skills, max, psycho);
                        }
                        break;
                    case 5:
                        if (psycho && skills.getPsychokinesis() < max) {
                            skills.setPsychokinesis(skills.getPsychokinesis() + 1);
                        } else {
                            skills = addToCharacteristic(skills, max, psycho);
                        }
                }
            }
        }
        //log.debug(skills.toString());
        return skills;
    }

    public void addSkillsToSkills(Skills bonusSkills) {
        strength += bonusSkills.getStrength();
        charisma += bonusSkills.getCharisma();
        intelligence += bonusSkills.getIntelligence();
        vitality += bonusSkills.getVitality();
        dexterity += bonusSkills.getDexterity();
        psychokinesis += bonusSkills.getPsychokinesis();
    }

    public int getVerbal() {
        return charisma;
    }

    public void setVerbal(int verbal) {
        this.charisma = verbal;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getPsychokinesis() {
        return psychokinesis;
    }

    public void setPsychokinesis(int psychokinesis) {
        this.psychokinesis = psychokinesis;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    @Override
    public String toString() {
        return "Skills{" + "strength=" + strength + ", charisma=" + charisma + ", intelligence=" + intelligence + ", vitality=" + vitality + ", dexterity=" + dexterity + ", psychokinesis=" + psychokinesis + '}';
    }

    public int getInitiative() {
        return dexterity * 8 + intelligence * 3 + charisma * 5;
    }


    public String getShortInfo() {
        return "Str:" + strength + " char:" + charisma + " Int:" + intelligence + " Vit:" + vitality + " Dex:" + dexterity + " Psy:" + psychokinesis;
    }


}
