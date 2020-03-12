package dms.pastor.prototypes.aberminegenerator.ui.web;

import dms.pastor.prototypes.aberminegenerator.Activity;
import org.springframework.stereotype.Service;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.NEW_LINE;

@Service
public class WorldMapService {

    private final Activity activity;

    public WorldMapService(Activity activity) {
        this.activity = activity;
    }

    public void generateNewWorld(){
        activity.regenerateWorld();
    }

    public String getPlayerInfo(){
        return activity.getWanderer().getInfo();
    }


    public String getMapAsString(){
        return activity.getMap().replace(NEW_LINE,EMPTY_STRING);
    }

    public void goNorth(){
        activity.walkNorth();
    }

    public void goEast(){
        activity.walkEast();
    }

    public void goSouth(){
        activity.walkSouth();
    }

    public void goWest(){
        activity.walkWest();
    }

}
