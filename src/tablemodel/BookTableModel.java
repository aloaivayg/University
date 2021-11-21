/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import entity.Book;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class BookTableModel extends AbstractTableModel {
    private String[] columnNames = {"SecurityID","Name","Salary","Type","Price"};
    private ArrayList<Book> listData = new ArrayList<Book>();
    private ArrayList<Object[]> listObject = new ArrayList<Object[]>();
   
    //constructor
    public BookTableModel(ArrayList<Book> listBook) {
        listData=listBook;
        for (int i = 0; i < listBook.size(); i++) {
            Book tempBook = listBook.get(i);
            Object[] temp = {tempBook.getBookID(), tempBook.getTitle(),tempBook.getCollection(),tempBook.getType(),tempBook.getPrice()};
            listObject.add(temp);
        }
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public int getRowCount() {
        return listObject.size();
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        return listObject.get(rowIndex)[columnIndex];
    }
    public String getColumnName(int column) {
        return columnNames[column];
    }
    public Class getColumnClass(int column) {
        return this.getValueAt(0, column).getClass();
    }
    public Object getObjectAtRow(int row) {
        return this.listData.get(row);
    }
}
