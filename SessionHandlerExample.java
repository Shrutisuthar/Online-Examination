/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.awt.event.ActionListener;
import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 *
 * @author Shruti
 */
public class SessionHandlerExample implements ActionListener {

    private static final int SESSION_TIMEOUT = 30 * 1000; // 30 sec timeout for testing purposes
    private final Timer invalidationTimer = new Timer(SESSION_TIMEOUT, this);
    private final JFrame frm = new JFrame("Session test frame");
    /**
     * 
     */
    public SessionHandlerExample() {
        initUI();
    }

    /**
     * 
     */
    private void initUI() {
        final JTextArea text = new JTextArea(20, 80);
        frm.add(new JScrollPane(text));
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setVisible(true);
        invalidationTimer.setRepeats(false);
        invalidationTimer.restart();

        // register listener to get all mouse/key events
        final AWTEventListener l = new AWTEventListener() {

            @Override
            public void eventDispatched(AWTEvent event) {
                // if any input event invoked - restart the timer to prolong the session
                invalidationTimer.restart();
            }
        };
        Toolkit.getDefaultToolkit().addAWTEventListener(l, AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // provide session invalidation here (show login dialog or do something else)
        JOptionPane.showMessageDialog(frm, "Your session is invalide");
        invalidationTimer.restart();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new SessionHandlerExample();
            }
        });
    }
}
