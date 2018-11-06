package dms.pastor.examples.lombok;

import lombok.ToString;

@ToString
final class Reactor {
    private Core[] cores = new Core[]{new Core(),new Core()};
    private boolean enabled;
    private String status;
    private int temperature;

}
