package dms.pastor.tasks.paint.command;

import dms.pastor.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static dms.pastor.tasks.paint.command.CommandSyntaxCode.C;
import static dms.pastor.tasks.paint.command.CommandSyntaxCode.R;
import static dms.pastor.tasks.paint.command.CommandValidator.validateCommandParams;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	https://dominiksymonowicz.com/
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public final class ToCommandTransformer {

    private static final List<Command> COMMANDS;

    static {
        COMMANDS = new ArrayList<>();
        COMMANDS.add(new QuitCommand());
        COMMANDS.add(new ClearCanvasCommand());
        COMMANDS.add(new CreateCanvasCommand());
        COMMANDS.add(new CreateNewLineCommand());
        COMMANDS.add(new CreateNewRectangleCommand());
        COMMANDS.add(new FillEntireAreaCommand());
        COMMANDS.add(new UndoCommand());
        COMMANDS.add(new RedoCommand());
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

    private static void validateInput(String input) {
        if (StringUtils.isStringEmpty(input)) {
            throw new InvalidCommandSyntaxException("input is null or empty");
        }
    }


    private static Command getCommandFor(String[] input) {
        for (Command command : COMMANDS) {
            if (command.getSyntax().equals(input[0])) {
                if (C.equalsIgnoreCase(command.getSyntax())) {
                    return getCommand(input, new CreateCanvasCommand(), new ClearCanvasCommand());
                }
                if (R.equalsIgnoreCase(command.getSyntax())) {
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
