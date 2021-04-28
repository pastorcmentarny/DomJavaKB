package dms.pastor.tools.trips.common.options;

import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.Stations;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * tag-command-pattern
 * <p>
 * The command pattern is a behavioral design pattern
 * An object is used to encapsulate all information needed to perform an action or trigger an event at a later time.
 * Four terms always associated with the command pattern are command, receiver, invoker and client.
 * - The command object knows about receiver and invokes a method of the receiver.
 * - The receiver object to execute these methods is also stored in the command object by aggregation.
 * - The invoker object knows how to execute a command, and optionally does bookkeeping about the command execution.
 * - The client object decides which receiver objects it assigns to the command objects, and which commands it assigns to the invoker.
 * <p>
 * Used in GUI buttons and menu items , multi-level undo (memento pattern
 * <p>
 * Source: Wikipedia
 */
@FunctionalInterface
public interface Option {
    void choose(Stations stations, StationType type);

    default String getCommandTitle(int commandCode) {
        return "Unknown";
    }
}
