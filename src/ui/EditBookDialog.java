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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import manager.Manager;

/**
 *
 * @author Administrator
 */
public class EditBookDialog extends JDialog {
    private Manager myManager;
    private Book  editedBook;
    
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

    private JButton btnUpdate = new JButton("Update");
    private JButton btnExit = new JButton("Exit");

    private JPanel panelFields = new JPanel();

    public EditBookDialog(Manager myCManager, Book editedBook, Frame frame, String string, boolean bln) {
        super(frame, string, bln);
        this.myManager = myManager;
        this.editedBook = editedBook;
        this.createAndShowUI();
    }

    
 
    private void createAndShowUI() {
        
        this.txtID.setEditable(false);
        this.panelFields.add(this.lblID);
        this.panelFields.add(this.txtID);
        this.panelFields.add(this.lblTitle);
        this.panelFields.add(this.txtTitle);
        this.panelFields.add(this.lblCollection);

        this.cmbxCollection.addItem("movie");
        this.cmbxCollection.addItem("music");
        this.cmbxCollection.addItem("game");
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

        this.panelFields.add(this.btnUpdate);
        this.panelFields.add(this.btnExit);
        this.panelFields.add(this.lblError);

        this.add(this.panelFields);
        
        this.doFillData();
        
        this.addListener();
        
        
        this.pack();
        this.setSize(320, 260);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void addListener() {
        this.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doUpdateCD();
            }
        });

        this.btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doExit();
            }
        });
        
    }

    private void doFillData() {
        this.txtID.setText(this.editedBook.getBookID());
        this.txtTitle.setText(this.editedBook.getTitle());
        this.txtPrice.setText(String.valueOf(this.editedBook.getPrice()));
        this.txtYoR.setText(String.valueOf(this.editedBook.getYearOfRelease()));
        
        this.cmbxCollection.setSelectedItem(this.editedBook.getCollection());
        
        if(this.editedBook.getType().equals("Tranh"))
        {
            radBtnTranh.setSelected(true);
        }
        else
        {
            radBtnChu.setSelected(true);
        }
        
        
    }

    private void doUpdateCD() {
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

        if (this.myManager.updateBookInfo(tempBook)) {
            System.out.println("Successful");
            refreshTable();
        } else {
            System.out.println("UnSuccessful");
        }
    }
    private void doExit() {
        refreshTable();
        this.dispose();
    }
    
    private void refreshTable()
    {
        MainFrame myMainframe = (MainFrame)this.getParent();
        myMainframe.fillInTable();
    }
}
