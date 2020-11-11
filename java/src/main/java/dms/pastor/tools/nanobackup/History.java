/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dms.pastor.tools.nanobackup;

import javax.swing.*;
import java.awt.*;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.NEW_LINE;
import static java.awt.Color.BLACK;
import static java.awt.Color.GREEN;

/**
 * Author Dominik Symonowicz
 * Created: 09-Jan-2012 10:49:45
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 *
 * This is my first project after graduation in 2010. Do not expect too much :)
 */
@SuppressWarnings("MagicNumber") //TOO OLD PROJECT  TO TAKE CARE OF MAGIC NUMBERS
public class History {
    private static History history;
    private String messageHistory = EMPTY_STRING;
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
        msgWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
        messages.setFont(new Font("Tahoma", Font.PLAIN, 14));
        messages.setBackground(BLACK);
        messages.setForeground(GREEN);
        messages.setEditable(false);
        messages.setWrapStyleWord(true);
        messages.setLineWrap(true);
        messages.setAutoscrolls(true);
        msgPanel.add(sp);
        msgWindow.add(msgPanel);
        msgWindow.setVisible(true);
    }

    public void addMessage(String message) {
        messageHistory += message + NEW_LINE;
        if (msgWindow != null) {
            updateMessages();
        }
    }

    private void updateMessages() {
        messages.setText(messageHistory);
    }

    public void closeWindow() {
        msgWindow.dispose();
        msgWindow = null;
    }

    public String getMessages() {
        return messageHistory;
    }

    public void clearMessages() {
        messageHistory = EMPTY_STRING;
    }
}
