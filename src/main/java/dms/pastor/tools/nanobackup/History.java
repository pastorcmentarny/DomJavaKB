/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dms.pastor.tools.nanobackup;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dominik Symonowicz ( dominik.symonowicz@thebookpeople.co.uk )
 * 09-Jan-2012 10:49:45
 * UTF-8
 */
public class History {
    private static History history;
    public String messageHistory = ""; //TODO change that
    JFrame msgWindow;
    JTextArea messages;

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

    public void updateMessages() {
        messages.setText(messageHistory);
    }

}
