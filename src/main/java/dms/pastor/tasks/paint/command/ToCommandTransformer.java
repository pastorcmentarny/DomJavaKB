package dms.pastor.tasks.paint.command;

import java.util.ArrayList;
import java.util.List;

import static dms.pastor.tasks.paint.command.CommandValidator.validateCommandParams;
import static dms.pastor.utils.ValidatorUtils.validateIfStringNotEmpty;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public final class ToCommandTransformer {

    private static final List<Command> commands;

    static {
        commands = new ArrayList<>();
        commands.add(new QuitCommand());
        commands.add(new ClearCanvasCommand());
        commands.add(new CreateCanvasCommand());
        commands.add(new CreateNewLineCommand());
        commands.add(new CreateNewRectangleCommand());
        commands.add(new FillEntireAreaCommand());
        commands.add(new UndoCommand());
        commands.add(new RedoCommand());
    }

    private ToCommandTransformer() {
    }

    public static Command toCommand(String input) {
        validateInput(input);

        final String[] commandParams = input.split(" ");
        final Command command = getCommandFor(commandParams);

        validateCommandParams(command, input);
        return command;
    }

    //TODO improve readability
    private static void validateInput(String input) {
        if (!validateIfStringNotEmpty(input)) {
            throw new InvalidCommandSyntaxException("input is null or empty");
        }
    }

    //TODO improve quality
    private static Command getCommandFor(String[] input) {
        for (Command command : commands) {
            if (command.getSyntax().equals(input[0])) {
                if (command.getSyntax().equalsIgnoreCase("C")) {
                    return getCommand(input, new CreateCanvasCommand(), new ClearCanvasCommand());
                }
                if (command.getSyntax().equalsIgnoreCase("R")) {
                    return getCommand(input, new CreateNewRectangleCommand(), new RedoCommand());
                }
                return command;
            }
        }
        throw new InvalidCommandSyntaxException("command not found");
    }

    private static Command getCommand(String[] input, Command cmdWithArgs, Command cmdWithoutArgs) {
        if (input.length > 1) {
            return cmdWithArgs;
        } else {
            return cmdWithoutArgs;
        }
    }
}
