package dms.pastor.examples.java21;

import java.util.List;
import java.util.regex.Pattern;

public class VariousExamples {
    public static void main(String[] args) {
        runExamples();
    }

    private static void runExamples() {
        var emoji = Character.toChars(0x1F685);
        System.out.println(emoji);
        System.out.println(Character.isEmoji(0x1F685));
        System.out.println(Character.isEmojiComponent(0x1F685));
        System.out.println(Character.isEmojiModifier(0x1F685));
        System.out.println(Character.isEmojiModifierBase(0x1F685));
        System.out.println(Character.isEmojiPresentation(0x1F685));
        System.out.println(Character.isExtendedPictographic(0x1F685));

        // You can use emoji properties in Regex
        System.out.println(Pattern.compile("\\p{IsEmoji}").matcher("\uD83D\uDE84").matches());

        var many_very = "very ".repeat(10);
        System.out.println("ServiceNow is " + many_very + "slow.");

        // new indexof overload method
        System.out.println("saint sainsbuyrs sailor".indexOf("sai",1,3));

        // splitWithDelimiters
        var result = "saint sainsbuyrs sailor".splitWithDelimiters("sai",3);
        for(var x : result){
            System.out.println(x);
        }


        //List.of("wroclaw","aberystwyth","london").stream().

    }


}