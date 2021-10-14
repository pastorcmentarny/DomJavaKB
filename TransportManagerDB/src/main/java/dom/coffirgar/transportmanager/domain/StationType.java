package dom.coffirgar.transportmanager.domain;

public enum StationType {
    TUBE,
    OVERGROUND,
    TRAIN,
    TUBE_OVERGROUND,
    TRAIN_OVERGROUND,
    TUBE_TRAIN,
    TUBE_OVERGROUND_TRAIN;


    public static boolean isTubeType(StationType type) {
        return type == TUBE || type == TUBE_TRAIN ||  type == TUBE_OVERGROUND || type == TUBE_OVERGROUND_TRAIN;
    }

    public static boolean isOvergroundType(StationType type) {
        return type == OVERGROUND || type == TUBE_OVERGROUND || type == TRAIN_OVERGROUND ||  type == TUBE_OVERGROUND_TRAIN;
    }

    public static boolean isTrainType(StationType type) {
        return type == TRAIN || type == TUBE_TRAIN || type == TRAIN_OVERGROUND || type == TUBE_OVERGROUND_TRAIN;
    }
}
