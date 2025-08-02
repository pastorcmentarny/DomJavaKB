package dms.pastor.examples.lombok;

import lombok.ToString;

/*
 See package dms.pastor.examples.lombok.RefactorTest for an example
 */
@ToString
final class Reactor {
    private final Core[] cores = new Core[]{new Core(), new Core()};
    private boolean enabled;
    private String status;
    private int temperature;

}
