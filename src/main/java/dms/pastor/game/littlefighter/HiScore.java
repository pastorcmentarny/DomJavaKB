/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dms.pastor.game.littlefighter;

import java.io.*;
import java.util.ArrayList;

/**
 * Author Dominik Symonowicz
 * Created 2009
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class HiScore {

    ArrayList<Integer> scoreList = new ArrayList();
    int[] score = new int[10];
    private StringBuilder content = new StringBuilder();
    private FileReader fileLoader;
    private FileWriter fileSaver;
    private String fileName = "HiScore.txt";

    public void IsItHiScore(int exp) {
        for (int i = 0; i < score.length; i++) {
            if (exp > score[i]) {
                int temp = score[i];
                score[i] = exp;
                for (int j = i; j < score.length; i++) {
                    int subtemp = score[j];
                    score[j] = temp;
                }
            }
        }
        displayHiScore();
    }

    private void displayHiScore() {
        for (int i = 0; i < score.length; i++) {
            System.out.println(i + " place =" + score[i]);
        }
    }

    public void save2File(int exp) {
        try {
            fileLoader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileLoader);
            String allText = "";
            String t;
            int line = 0;
            while ((t = br.readLine()) != null) {
                System.out.println(t);
                allText = allText + t + "\n";
                line++;
            }
            System.out.println(allText);
            allText += exp + "\n";
            System.out.println(allText);

            fileLoader.close();
            fileSaver = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fileSaver);
            //checkScore(exp,singleScore,line);
            fileSaver.write(allText);
            fileSaver.close();

        } catch (IOException ex) {
        }
    }

    private void checkScore(int exp, String t, int line) {
        String[] temp = new String[line];
        temp = t.split("\n");
        for (String aTemp : temp) {
            System.out.println(aTemp);
        }
    }

    public void addToHiScore(int score) {
        try {
            fileLoader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileLoader);
            String singleScore;
            int line = 0;
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
                    line++;
                }
            }
            scoreList.add(score);
            sortScoreList();

            fileLoader.close();
            fileSaver = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fileSaver);
            for (Integer aScoreList : scoreList) {
                String x = aScoreList.toString() + "\n";
                fileSaver.write(x);
            }


            fileSaver.close();

        } catch (IOException ex) {
        }
    }

    public void sortScoreList() {
        for (int i = 1; i < scoreList.size(); i++) {
            int temp = 0;
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
