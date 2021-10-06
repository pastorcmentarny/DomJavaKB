package dms.pastor.tools.coder;

import dms.pastor.domain.exception.SomethingWentTerribleWrongError;

import static dms.pastor.tools.coder.DomCoder.loadSourceFile;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class CodecAppRunner {

    private CodecAppRunner() {
    }

    public static void main(String[] args) {
        validateInput(args);
        final String content = loadSourceFile();
        switch (args[0]) {
            case "e", "E", "encode" -> System.out.println(new DomEncoder(content).encode());
            case "d", "D", "decode" -> System.out.println(new DomDecoder(content).decode());
            default -> throw new SomethingWentTerribleWrongError("What you want ?");
        }
    }

    private static void validateInput(String[] args) {
        if (args == null || args.length != 1) {
            throw new SomethingWentTerribleWrongError();
        }
    }
}
