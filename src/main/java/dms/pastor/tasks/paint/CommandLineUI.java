package dms.pastor.tasks.paint;

import dms.pastor.tasks.paint.canvas.Canvas;
import dms.pastor.tasks.paint.command.Command;
import dms.pastor.tasks.paint.command.InvalidCommandSyntaxException;
import dms.pastor.tasks.paint.command.QuitCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static dms.pastor.tasks.paint.canvas.Canvas.noCanvas;
import static dms.pastor.tasks.paint.command.ToCommandTransformer.toCommand;

/**
 * Author Dominik Symonowicz
 * Created 14/07/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CommandLineUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineUI.class);
    private final Scanner scanner;
    private final Canvas canvas = noCanvas();
    private boolean running;
    private String input;

    public CommandLineUI(Scanner scanner) {
        this.scanner = scanner;
    }

    public void runApplication() {
        running = true;
        while (running) {
            System.out.print("Enter command:");

            getInputFromUser();

            try {
                runCommandFor();
            } catch (InvalidCommandSyntaxException e) {
                System.out.println(e.getMessage());
                LOGGER.warn(e.getMessage());
            }

            draw();
        }
    }

    private void getInputFromUser() {
        input = scanner.nextLine();
        System.out.println(input);
    }

    private void runCommandFor() {
        Command command = toCommand(input);
        if (command != null) {
            if (command instanceof QuitCommand) {
                running = false;
            } else {
                command.execute(canvas);
            }
        }
    }

    private void draw() {
        System.out.println(canvas.getImageAsString());
    }

}
