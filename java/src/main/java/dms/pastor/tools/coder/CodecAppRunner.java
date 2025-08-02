package dms.pastor.tools.coder;

import dms.pastor.domain.exception.SomethingWentTerribleWrongError;

import static dms.pastor.tools.coder.DomCoder.loadSourceFile;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2016
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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
