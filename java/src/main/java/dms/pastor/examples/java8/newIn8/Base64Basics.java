package dms.pastor.kb.java8.newIn8;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

final class Base64Basics {

    public static final String encrypt(String source){
        final byte[] encodedMessage = Base64.getEncoder().encode(source.getBytes());
        return  new String(encodedMessage);
    }

    public static final String decrypt(String source){
        final byte[] decodedMessage = Base64.getDecoder().decode(source.getBytes());
        return new String(decodedMessage);
    }

    public static final String loadFile(Path path){
        StringBuilder builder = new StringBuilder();
        try {
            Files.lines(path).forEach(line -> builder.append(line).append("\n"));
        } catch (IOException e) {
            return  "Something went wrong";
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        runBasics();
        boolean run = true;
        if(run){
            String source = "aGFydGxpbms6c2VjcmV0";
            final byte[] decodedMessage = Base64.getDecoder().decode(source.getBytes());
            System.out.println(new String(decodedMessage));
        }

    }

    public static void runBasics(){

        System.out.println("...START...");

        String originalMessage = loadFile(FileSystems.getDefault().getPath("C:\\file.txt"));
        System.out.println("... ... O MESSAGE: " + originalMessage);
        String encrypted = encrypt(originalMessage);
        System.out.println("... ... E MESSAGE: " + encrypted);
        final String decrypted = decrypt(encrypted);
        System.out.println("... ... D MESSAGE: " + decrypted);

    }
}
