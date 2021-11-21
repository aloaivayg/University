
package uis;

import manager.Manager;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private Manager myManager;

    private JButton btnNewBook = new JButton("Add Security");
    private JButton btnBackup = new JButton("Backup");
    private JButton btnRestore = new JButton("Restore");
    private JButton btnRefresh = new JButton("Refresh");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnSearch = new JButton("Search by ID");
    private JTextField txtSearch = new JTextField(30);

    private JPanel panelBtn = new JPanel();
    private JPanel panelTbl = new JPanel();
    private JPanel panelSearch = new JPanel();

    private JTable myTable = new JTable();
    private JScrollPane myScroll = new JScrollPane();

    public MainFrame(String string) {
        super(string);
        this.myManager = new Manager();
        this.creatAndShowUI();
    }

    public void creatAndShowUI() {
        this.panelSearch.add(txtSearch);
        this.panelSearch.add(btnSearch);
        this.add(panelSearch, BorderLayout.NORTH);
        this.panelBtn.add(this.btnNewBook);
        this.panelBtn.add(this.btnBackup);
        this.panelBtn.add(this.btnRestore);
        this.panelBtn.add(this.btnRefresh);
        this.panelBtn.add(this.btnDelete);

        this.add(this.panelBtn, BorderLayout.SOUTH);

        this.myScroll.getViewport().add(this.myTable);
        this.panelTbl.add(this.myScroll);

        this.add(this.myScroll, BorderLayout.CENTER);

        this.pack();
        this.setSize(500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
