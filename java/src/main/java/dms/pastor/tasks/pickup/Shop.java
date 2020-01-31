package dms.pastor.tasks.pickup;

import lombok.Data;

import java.util.List;

@Data
public class Shop {
    private final int id;
    private final String name;
    private final List<OpenCloseTime> weeklyOpenCloseTimes; //only normal week are consider now

}
