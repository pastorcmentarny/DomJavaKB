package dms.pastor.tools.coder;


import dms.pastor.domain.exception.SomethingWentTerribleWrongError;

import static dms.pastor.tools.coder.DomCoder.loadSourceFile;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CodecAppRunner {

    public static void main(String[] args) {
        validateInput(args);
        final String content = loadSourceFile();
        switch (args[0]) {
            case "e":
            case "E":
            case "encode":
                System.out.println(new DomEncoder(content).encode());
                break;
            case "d":
            case "D":
            case "decode":
                System.out.println(new DomDecoder(content).decode());
                break;
            default:
                throw new SomethingWentTerribleWrongError("What you want ?");
        }
    }

    private static void validateInput(String[] args) {
        if (args == null || args.length != 1) {
            throw new SomethingWentTerribleWrongError();
        }
    }
}
