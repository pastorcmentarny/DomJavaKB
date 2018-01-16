package dms.pastor.tools.lotto.hotpick;

import java.util.List;

public class DrawList {
    private final List<HotPickDraw> drawList;

    public DrawList(List<HotPickDraw> drawList) {
        this.drawList = drawList;
    }

    public List<HotPickDraw> getDrawList() {
        return drawList;
    }
}
