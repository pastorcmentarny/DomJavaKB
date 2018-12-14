package dms.pastor.game.rpg.quests;


public class QuestMonitor {

    private static QuestMonitor questMonitor;
    public QuestState bureaucrracy = QuestState.AVALIABLE;
    public QuestState winWithOlaAtTower = QuestState.NOT_AVALIABLE;
    public QuestState zombie = QuestState.NOT_AVALIABLE;
    public QuestState devilBridge = QuestState.AVALIABLE;
    public QuestState win100inRPSGame = QuestState.AVALIABLE;
    public QuestState kittenQuestState = QuestState.NOT_AVALIABLE;
    public QuestState mutaSpiderQuestState = QuestState.NOT_AVALIABLE;
    public QuestState sleepingMonika = QuestState.AVALIABLE;


    //=========================////
    //\\SIDE QUESTS            \\\\
    public boolean adamAlive = true;
    boolean alienQuestAvailable = false;
    boolean coffeeStory = false;
    boolean penDinasQuest = false;
    boolean zombieKilled = false;
    private boolean toiletLevelAvailable = false;
    private boolean zombieQuestInProgress = false;
    private boolean zombieTalkPassed = false;
    private boolean officeQuestCompleted = false;
    private boolean monikaQuestCompleted = false;

    private QuestMonitor() {

    }

    public static synchronized QuestMonitor getQuestMonitor() {

        if (questMonitor == null) {
            questMonitor = new QuestMonitor();
        }
        return questMonitor;
    }

    public boolean isAdamAlive() {
        return adamAlive;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        //FIXME log.error("Clone not supported exception!");
        throw new CloneNotSupportedException();
    }

    public boolean isOfficeQuestCompleted() {
        return officeQuestCompleted;
    }

    public boolean isMonikaQuestCompleted() {
        return monikaQuestCompleted;
    }

    public void setMonikaQuestCompleted() {
        monikaQuestCompleted = true;
    }

    public boolean isAlienQuestAvailable() {
        return alienQuestAvailable;
    }

    public boolean isCoffeeStoryTold() {
        return coffeeStory;
    }

    public void setCoffeeStory(boolean coffeeStory) {
        this.coffeeStory = coffeeStory;
    }

    public boolean isPenDinasQuestCompleted() {
        return penDinasQuest;
    }

    public void setPenDinasQuestState(boolean penDinasQuest) {
        this.penDinasQuest = penDinasQuest;
    }

    public boolean isNicolasInTower() {
        return true;
        //TODO implement
    }

    public boolean isToiletLevelAvaliable() {
        return toiletLevelAvailable;
    }

    public void setZombieKilled() {
        zombieKilled = true;
    }

    public boolean isZombieQuestNotStarted() {
        return !zombieQuestInProgress;
    }

    public boolean isZombieKilled() {
        return zombieKilled;
    }

    public void passZombieTalk() {
        zombieTalkPassed = true;
    }

    public boolean isZombieQuestStarted() {
        return zombieQuestInProgress;
    }


}
