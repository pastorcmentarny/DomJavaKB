package dms.pastor.tools.forty;

import dms.pastor.domain.exception.SomethingWentTerribleWrongError;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FortyBeforeFortyHtmlApplication {

    public static void main(String[] args) {
        HtmlGenerator html = new HtmlGenerator();
        System.out.println(html.generate());
        System.out.println(html.saveAsHtml());

        openHtmlFile();
    }

    private static void openHtmlFile() {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().open(new File("B:\\GitHub\\denva\\src\\templates\\40b440.html"));
            } catch (IOException exception) {
                throw new SomethingWentTerribleWrongError(exception.getMessage());
            }
        } else {
            throw new SomethingWentTerribleWrongError("Current device is not supported");
        }
    }
}
