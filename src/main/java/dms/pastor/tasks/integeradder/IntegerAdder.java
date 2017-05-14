package dms.pastor.tasks.integeradder;

import com.sun.istack.internal.NotNull;

import java.io.*;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * This is an example of using args from main(String[] args) method.
 * <p>
 * <p>
 * About program:
 * It will take arguments and each argument is a path to file.
 * Each file can have any number of lines from 1 to N.
 * Each line can contain only one integer.
 * All of the numbers from all of the files should be added to the final result.
 * The result is just one number and it will be displayed usingS System.out.println() method
 */

class IntegerAdder {

    public int add(@NotNull String path) throws IOException {
        validatePath(path);
        File inputFile = new File(path);
        return loadIntegers(inputFile);
    }

    private int loadIntegers(File inputFile) throws IOException {
        int sum = 0;
        try (FileInputStream fis = new FileInputStream(inputFile);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                sum += Integer.valueOf(strLine);
            }
        }
        return sum;
    }

    private void validatePath(@NotNull String path) {
        if (path == null || path.isEmpty() || !new File(path).isFile()) {
            throw new IllegalArgumentException("Path is crap");
        }
    }

    int calculateTotalSum(String[] paths) throws IOException {
        int sum = 0;
        if (paths != null) {
            for (String integer : paths) {
                sum += add(integer);
            }
        } else {
            throw new IllegalArgumentException("You need provide arguments that are numbers to add");
        }
        return sum;
    }

}
