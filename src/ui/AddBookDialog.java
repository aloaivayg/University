/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Book;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import manager.Manager;

/**
 *
 * @author Administrator
 */
public class AddBookDialog extends JDialog {

    private Manager myManager;

    private JLabel lblID = new JLabel("Book ID");
    private JLabel lblTitle = new JLabel("Book Title");
    private JLabel lblCollection = new JLabel("Book Collection");
    private JLabel lblType = new JLabel("Book Type");
    private JLabel lblPrice = new JLabel("Book Price");
    private JLabel lblYoR = new JLabel("Book Year of Release");
    private JLabel lblError = new JLabel();

    private JTextField txtID = new JTextField(20);
    private JTextField txtTitle = new JTextField(20);
    private JTextField txtPrice = new JTextField(20);
    private JTextField txtYoR = new JTextField(20);

    private JComboBox<String> cmbxCollection = new JComboBox<String>();

    private JRadioButton radBtnTranh = new JRadioButton("Truyện tranh");
    private JRadioButton radBtnChu = new JRadioButton("Truyện chữ");
    private ButtonGroup groupType = new ButtonGroup();

    private JButton btnAdd = new JButton("Add");
    private JButton btnClear = new JButton("Clear");
    private JButton btnExit = new JButton("Exit");

    private JPanel panelFields = new JPanel();

    public AddBookDialog(Manager myManager, Frame frame, String string, boolean bln) {
        super(frame, string, bln);
        this.myManager = myManager;
        this.createAndShowUI();
    }

    private void createAndShowUI() {
        this.panelFields.add(this.lblID);
        this.panelFields.add(this.txtID);
        this.panelFields.add(this.lblTitle);
        this.panelFields.add(this.txtTitle);
        this.panelFields.add(this.lblCollection);

        this.cmbxCollection.addItem("Tiểu thuyết");
        this.cmbxCollection.addItem("Viễn tưởng");
        this.cmbxCollection.addItem("Hành động");
        this.panelFields.add(cmbxCollection);

        this.panelFields.add(this.lblType);

        this.panelFields.add(radBtnTranh);
        this.panelFields.add(radBtnChu);
        this.radBtnTranh.setSelected(true);

        this.groupType.add(radBtnChu);
        this.groupType.add(radBtnTranh);

        this.panelFields.add(this.lblPrice);
        this.panelFields.add(this.txtPrice);
        this.panelFields.add(this.lblYoR);
        this.panelFields.add(this.txtYoR);

        this.panelFields.add(this.btnAdd);
        this.panelFields.add(this.btnClear);
        this.panelFields.add(this.btnExit);
        this.panelFields.add(this.lblError);

        this.add(this.panelFields);

        this.addListener();
        this.pack();
        this.setSize(320, 370);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void addListener() {
        this.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doClear();
            }
        });

        this.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doAddBook();
                doClear();
            }
        });

        this.btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doExit();
            }
        });

    }

    private void doClear() {
        this.txtID.setText("");
        this.txtTitle.setText("");
        this.txtPrice.setText("");
        this.txtYoR.setText("");
    }

    private void doAddBook() {

        if (isValidate()) {
            String id, collect, type, title;
            float price;
            int year;

            id = this.txtID.getText();
            collect = (String) this.cmbxCollection.getSelectedItem();
            if (this.radBtnChu.isSelected()) {
                type = "Truyện chữ";
            } else {
                type = "Truyện tranh";
            }
            title = this.txtTitle.getText();
            price = Float.parseFloat(this.txtPrice.getText());
            year = Integer.parseInt(this.txtYoR.getText());

            Book tempBook = new Book(id, collect, type, title, price, year);

            if (this.myManager.addBook(tempBook)) {
                System.out.println("Successful");
                refreshTable();
            } else {
                System.out.println("UnSuccessful");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error", "Field blank", JOptionPane.ERROR_MESSAGE);
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

    private boolean isValidate() {
        boolean result = true;

        if (this.txtID.getText().length() == 0) {
            result = false;
        }
        if (this.txtTitle.getText().length() == 0) {
            result = false;
        }
        if (this.txtPrice.getText().length() == 0) {
            result = false;
        }
        if (this.txtYoR.getText().length() == 0) {
            result = false;
        }

        return result;
    }

}
