/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import manager.Manager;

/**
 *
 * @author Administrator
 */
public class DeleteBookDialog extends JDialog {

    private Manager myManager;

    private JLabel lblID = new JLabel("Book ID");
    private JTextField txtID = new JTextField(20);

    private JButton btnDelete = new JButton("Delete");
    private JButton btnExit = new JButton("Exit");

    private JPanel panelFields = new JPanel();

    public DeleteBookDialog(Manager myManager, Frame frame, String string) {
        super(frame, string);
        this.myManager = myManager;
        this.createAndShowUI();

    }

    private void createAndShowUI() {
        this.panelFields.add(this.lblID);
        this.panelFields.add(this.txtID);
        this.panelFields.add(this.btnDelete);

        this.panelFields.add(this.btnExit);

        this.add(this.panelFields);

        this.addListener();
        this.pack();
        this.setSize(300, 220);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void addListener() {
        this.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doDelete();
            }
        });
        this.btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doExit();
            }
        });
    }

    private void doDelete() {
        String id = this.txtID.getText();

        if (this.myManager.deleteBookbyID(id)) {
            JOptionPane.showMessageDialog(this, "Book has been deleted", "Successful", JOptionPane.INFORMATION_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(this, "ID not exist", "Unsuccessful ", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void doExit() {
        refreshTable();
        this.dispose();
    }

    private void refreshTable() {
        MainFrame myMainframe = (MainFrame) this.getParent();
        myMainframe.fillInTable();
    }
}
