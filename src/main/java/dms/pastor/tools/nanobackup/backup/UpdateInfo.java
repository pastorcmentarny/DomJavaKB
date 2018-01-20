package dms.pastor.tools.nanobackup.backup;

import dms.pastor.tools.nanobackup.tools.Tools;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Pastor
 * @created 02.11.2011
 * <p>
 * It displays random message during perform backup task.
 */
public class UpdateInfo implements Runnable {
    Backup outer;
    private JTextArea label = null;
    private Random randomText = new Random();
    private ArrayList<String> lolText = new ArrayList<>();

    //TODO solve problem with using , Backup outer because of issue with GUI

    /**
     * Selecting random message and diplay on backup GUI
     *
     * @param label place where message is displayed
     * @param outer no idea why Engine class need be sent as parameter here,but i don't want argue with netbeans.
     *              <p>
     *              For some unknown reason i need use Engine as parameter to make it works.
     */
    public UpdateInfo(JTextArea label, Backup outer) {
        this.outer = outer;
        lolText = fillText(lolText);
        this.label = label;
    }

    public void run() {
        label.setForeground(Tools.getRandomColor());
        label.setText(lolText.get(randomText.nextInt(lolText.size())));
    }

    private ArrayList<String> fillText(ArrayList<String> lolText) {
        lolText.add("(Backup in progress)\n Zzzz .... ....");
        lolText.add("(Backup in progress)\n .... Zzzz ....");
        lolText.add("(Backup in progress)\n .... .... Zzzz");
        lolText.add("(Backup in progress)\n ZzZz ZzZz ZzZz");
        lolText.add("(Backup in progress)\n This can take ages ... sometimes.");
        lolText.add("(Backup in progress)\n This can take ages ... or even Epoch rarely.");
        lolText.add("(Backup in progress)\n This can take Era very very rarely ");
        lolText.add("(Backup in progress)\n This can take Eon rarely.");
        lolText.add("(Backup in progress)\n It is quite big one.Is it?");
        lolText.add("(Backup in progress)\n How are you today?\nHow feel your parents?\nIs your pets are healthy?\nDo not answer on above questions.This program doesn't  care and doesn't even listen you.");
        lolText.add("(Backup in progress)\n Advertisment:\n\n If you feel bored,see my irony caricature of homepage: http://pastor.ovh.org/ .\n\nEnd of crap Advertisment.");
        lolText.add("(Backup in progress)\n No. I am not planning implement show % progress  ");
        lolText.add("(Backup in progress)\n Are you trying beat Guiness recond in biggest and longest backup ever ???");
        lolText.add("(Backup in progress)\n What are you bakuping ?\n All porn websites with movies or what?");
        lolText.add("(Backup in progress)\n Are you doing backup of whole internet ???");
        lolText.add("(Backup in progress)\n Why you still looking here?\n This message will not replace your social (real & virtual) life.");
        lolText.add("(Backup in progress)\n I feel bored with doing backup of your stuff.I really do.");
        lolText.add("(Backup in progress)\n Time for joke.\nAfter riots John ask his friend from London.\nHow looks London after Riots?\nIt looks better in my new plasma 3D TV.");
        lolText.add("(Backup in progress)\n It seems like, it will be Endlessly job.");
        return lolText;
    }
}
