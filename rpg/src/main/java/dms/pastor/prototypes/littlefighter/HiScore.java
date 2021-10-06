/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dms.pastor.prototypes.littlefighter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 2009
 * WWW:	https://dominiksymonowicz.com/
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class HiScore {
    private static final Logger LOGGER = LoggerFactory.getLogger(HiScore.class);

    private final List<Integer> scoreList = new ArrayList<>();
    //   private final int[] score = new int[10];
    // --Commented out by Inspection (21/02/2018 15:56):private StringBuilder content = new StringBuilder();

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void setHighScoreFor(int points) {
//        for (int i = 0; i < score.length; i++) {
//            if (points > score[i]) {
//                int tempI = score[i];
//                score[i] = points;
//                for (int j = i; j < score.length; i++) {
//                    int tempJ = score[j];
//                    score[j] = tempI;
//                }
//            }
//        }
//        displayHiScore();
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

/*    private void displayHiScore() {
        for (int i = 0; i < score.length; i++) {
            System.out.println(i + " place =" + score[i]);
        }
    }*/

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void save2File(int exp) {
//        try {
//            fileLoader = new FileReader(fileName);
//            BufferedReader br = new BufferedReader(fileLoader);
//            StringBuilder allText = new StringBuilder();
//            String t;
//            int line = 0;
//            while ((t = br.readLine()) != null) {
//                System.out.println(t);
//                allText.append(t).append("\n");
//                line++;
//            }
//            System.out.println(allText);
//            allText.append(exp).append("\n");
//            System.out.println(allText);
//
//            fileLoader.close();
//            fileSaver = new FileWriter(fileName);
//            BufferedWriter bw = new BufferedWriter(fileSaver);
//            //checkScore(exp,singleScore,line);
//            fileSaver.write(allText.toString());
//            fileSaver.close();
//
//        } catch (IOException exception) {
//            LOGGER.warn(format("Unable save to file due %s", exception.getMessage()), exception);
//        }
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

/*    private void checkScore(int exp, String t, int line) {
        String[] temp;
        temp = t.split("\n");
        for (String aTemp : temp) {
            System.out.println(aTemp);
        }
    }*/

    void addToHiScore(int score) {
        String fileName = "HiScore.txt";
        try (FileReader fileLoader = new FileReader(fileName); BufferedReader br = new BufferedReader(fileLoader);
             FileWriter fileSaver = new FileWriter(fileName)
             //BufferedWriter bw = new BufferedWriter(fileSaver)
        ) {

            String singleScore;
            while ((singleScore = br.readLine()) != null) {
                if (singleScore.startsWith("0") ||
                        singleScore.startsWith("1") ||
                        singleScore.startsWith("2") ||
                        singleScore.startsWith("3") ||
                        singleScore.startsWith("4") ||
                        singleScore.startsWith("5") ||
                        singleScore.startsWith("6") ||
                        singleScore.startsWith("7") ||
                        singleScore.startsWith("8") ||
                        singleScore.startsWith("9")) {

                    System.out.println(singleScore);
                    scoreList.add(Integer.parseInt(singleScore));
                }
            }
            scoreList.add(score);
            sortScoreList();

            fileLoader.close();
            for (Integer aScoreList : scoreList) {
                String x = aScoreList.toString() + "\n";
                fileSaver.write(x);
            }

        } catch (IOException ex) {
            LOGGER.error(String.format("Unable to save file due %s", ex.getMessage()));
        }
    }

    private void sortScoreList() {
        for (int i = 1; i < scoreList.size(); i++) {
            int temp;
            int a = scoreList.get(i - 1);
            int b = scoreList.get(i);
            System.out.println("before>> a:" + a + " b:" + b);
            if (a < b) {
                temp = b;
                b = a;
                a = temp;
            }
            System.out.println("after>> a:" + a + " b:" + b + "\n");

        }

    }
}
