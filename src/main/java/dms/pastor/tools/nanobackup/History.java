/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dms.pastor.tools.nanobackup;

import javax.swing.*;
import java.awt.*;

/**
 * Author Dominik Symonowicz
 * Created: 09-Jan-2012 10:49:45
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings("MagicNumber") //TOO OLD PROJECT  TO TAKE CARE OF MAGIC NUMBERS
public class History {
    private static History history;
    private String messageHistory = ""; //TODO change that
    private JFrame msgWindow;
    private JTextArea messages;

    public static synchronized History getHistoryGUI() {
        if (history == null) {
            history = new History();
        }
        return history;
    }

    public void showHistoryOfMessages() {
        Dimension d = new Dimension(425, 550);
        msgWindow = new JFrame("History of messages");
        msgWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        msgWindow.setSize(d);
        msgWindow.setResizable(false);
        JPanel msgPanel = new JPanel();
        msgPanel.setSize(d);
        messages = new JTextArea(messageHistory);
        JScrollPane sp = new JScrollPane(messages);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        msgWindow.getContentPane().add(sp);
        messages.setSize(400, 500);
        messages.setRows(30);
        messages.setFont(new java.awt.Font("Tahoma", 0, 14));
        messages.setBackground(Color.BLACK);
        messages.setForeground(Color.GREEN);
        messages.setEditable(false);
        messages.setWrapStyleWord(true);
        messages.setLineWrap(true);
        messages.setAutoscrolls(true);
        msgPanel.add(sp);
        msgWindow.add(msgPanel);
        msgWindow.setVisible(true);
    }

    public void addMessage(String message) {
        messageHistory += message + "\n";
        if (msgWindow != null) {
            updateMessages();
        }
    }

    private void updateMessages() {
        messages.setText(messageHistory);
    }

}
