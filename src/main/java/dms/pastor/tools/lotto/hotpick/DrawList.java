package dms.pastor.tools.lotto.hotpick;

import java.util.Collections;
import java.util.List;

public class DrawList<T extends Draw> {
    private final List<T> drawList;

    public DrawList(List<T> drawList) {
        this.drawList = drawList;
    }

    public List<T> getDrawList() {
        return Collections.unmodifiableList(drawList);
    }
}
