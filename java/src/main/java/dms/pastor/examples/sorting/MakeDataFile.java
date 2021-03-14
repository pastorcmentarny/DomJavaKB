package dms.pastor.examples.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;


public class MakeDataFile {


    public static void main(String[] args) {

        BufferedWriter writer = null;
        Vector storedNums = new Vector();
        try {
            writer = new BufferedWriter(new FileWriter(args[0]));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        int numbers = Integer.parseInt(args[1]);
        int number;

        for (int i = 0; i < numbers; i++) {
            number = (int) (1000000 + (Math.random() * 8999999));
            try {
                if (writer != null) {
                    writer.write(number + "\n");
                }
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }

        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
