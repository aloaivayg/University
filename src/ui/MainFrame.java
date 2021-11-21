
package ui;

import entity.Book;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import manager.Manager;
import tablemodel.BookTableModel;

/**
 *
 * @author Administrator
 */
public class MainFrame extends JFrame {

    private Manager myManager;

    private JButton btnNewBook = new JButton("New Book");
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

        this.fillInTable();
        this.addListener();
        this.pack();
        this.setSize(500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    private void addListener() {
        this.btnNewBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doShowAddBookDialog();
            }
        });

        this.myTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    doShowEditDialog();
                }
            }
        });

        this.btnBackup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doBackup();
            }
        });

        this.btnRestore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doRestore();
                fillInTable();
            }
        });

        this.btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fillInTable();
            }
        });

        this.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doShowDeleteDialog();
                fillInTable();
            }
        });
         this.btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doSearch();
               
            }
        });
    }

    private void doBackup() {
        int num = this.myManager.saveByteData();
        System.out.println("Data is backed up, there are " + num + " book");
    }

    private void doRestore() {
        int num = this.myManager.getByteData();
        System.out.println("Data is restored , there are " + num + " book");
    }

    protected void fillInTable() {
        this.myTable.setModel(this.myManager.getBookTableModel());
    }

    private void doShowAddBookDialog() {
        AddBookDialog dialog = new AddBookDialog(myManager, this, "New Book Dialog", true);
    }

    private void doShowEditDialog() {
        String title = "Edit Book Dialog";
        int selRow = this.myTable.getSelectedRow();

        BookTableModel model = (BookTableModel) this.myTable.getModel();
        Book selectedBook = (Book) model.getObjectAtRow(selRow);

        EditBookDialog editDilog = new EditBookDialog(myManager, selectedBook, this, title, true);
    }

    private void doShowDeleteDialog() {
        DeleteBookDialog deleteDialog = new DeleteBookDialog(myManager, this, "Delete Book by ID");
    }
    private void doSearch(){
        String id = this.txtSearch.getText();
        FindBookByID find = new FindBookByID(myManager, id, this, id, rootPaneCheckingEnabled);
    }
}
