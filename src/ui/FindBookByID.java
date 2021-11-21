package ui;

import entity.Book;
import manager.Manager;

import javax.swing.*;
import java.awt.*;


public class FindBookByID extends JDialog{
    private Manager myManager;
    private JLabel lblID = new JLabel("Book ID");
    private JLabel lblCollection = new JLabel("Collection");
    private JLabel lblTitle = new JLabel("Title");
    private JLabel lblType = new JLabel("Type");
    private JLabel lblYoR = new JLabel("Year of Release");

    private JTextField txtID = new JTextField(25);
    private JTextField txtCollection = new JTextField(25);
    private JTextField txtTitle = new JTextField(25);
    private JTextField txtType = new JTextField(25);
    private JTextField txtYoR = new JTextField(25);

    private JButton btnExit = new JButton("Exit");

    private JPanel panel = new JPanel();

    public FindBookByID(Manager myManager, String id, Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.myManager = myManager;
        findBookByID(id);
        createAndShowUI();
    }

    private void createAndShowUI() {

        this.panel.add(lblID);
        this.panel.add(txtID);
        this.panel.add(lblCollection);
        this.panel.add(txtCollection);
        this.panel.add(lblTitle);
        this.panel.add(txtTitle);
        this.panel.add(lblType);
        this.panel.add(txtType);
        this.panel.add(lblYoR);
        this.panel.add(txtYoR);

        this.add(panel);

        this.txtID.setEditable(false);
        this.txtCollection.setEditable(false);
        this.txtTitle.setEditable(false);
        this.txtType.setEditable(false);
        this.txtYoR.setEditable(false);

        this.addListener();

        this.pack();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(320, 360);
        this.setVisible(true);
    }

    private void addListener() {
        
    }

    public void findBookByID(String id) {
        Book temp = this.myManager.getSecuritybyID(id);

        if (temp != null) {
            this.txtID.setText(temp.getBookID());
            this.txtCollection.setText(temp.getCollection());
            this.txtTitle.setText(temp.getTitle());
            this.txtType.setText(temp.getType());
            this.txtYoR.setText(Integer.toString(temp.getYearOfRelease()));
        } else {
            JOptionPane.showMessageDialog(this, "Book not found", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }


}
