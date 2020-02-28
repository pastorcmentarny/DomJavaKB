package dms.pastor.prototypes.aberminegenerator;

import dms.pastor.prototypes.aberminegenerator.ui.CommandLineUI;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Generator {

    public static void main(String[] args) {
        new CommandLineUI().game();
    }
}
