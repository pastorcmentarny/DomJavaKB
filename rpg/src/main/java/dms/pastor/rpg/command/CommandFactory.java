package dms.pastor.rpg.command;


import java.util.HashMap;
import java.util.Map;

// it used to list all command and list of all avaliable
public class CommandFactory {
    private final Map<Integer, Command> options;

    public CommandFactory() {
        this.options = new HashMap<>();
    }
}
