package dms.pastor.rpg.game.quests;


public class QuestMonitor {

    private static QuestMonitor questMonitor;
    public QuestState bureaucracy = QuestState.AVAILABLE;
    public QuestState winWithOlaAtTower = QuestState.NOT_AVAILABLE;
    public final QuestState zombie = QuestState.NOT_AVAILABLE;
    public QuestState devilBridge = QuestState.AVAILABLE;
    public QuestState win100inRPSGame = QuestState.AVAILABLE;
    public final QuestState kittenQuestState = QuestState.NOT_AVAILABLE;
    public QuestState mutaSpiderQuestState = QuestState.NOT_AVAILABLE;
    public QuestState sleepingMonika = QuestState.AVAILABLE;


    //=========================////
    //\\SIDE QUESTS            \\\\
    private final boolean adamAlive = true;
    private final boolean alienQuestAvailable = false;
    private boolean coffeeStory = false;
    private boolean penDinasQuest = false;
    private boolean zombieKilled = false;
    private final boolean toiletLevelAvailable = false;
    private final boolean zombieQuestInProgress = false;
    private boolean zombieTalkPassed = false;
    private final boolean officeQuestCompleted = false;
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

    public boolean isToiletLevelAvailable() {
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
