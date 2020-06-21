package dms.pastor.tasks.pickup;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Shop {
    private int id;
    private String name;
    private List<OpenCloseTime> weeklyOpenCloseTimes; //only normal week are consider now

}
