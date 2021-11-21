/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import dao.BookDAO;
import entity.Book;
import java.util.ArrayList;
import tablemodel.BookTableModel;

/**
 *
 * @author Administrator
 */
public class Manager {

    private ArrayList<Book> listBook;
    private BookDAO myDao;

    public Manager() {
        listBook = new ArrayList<>();
        myDao = new BookDAO();
    }

//    public BookManager(ArrayList<Book> listBook) {
//        this.listBook = listBook;
//        myDao = new BookDAO();
//    }

    public boolean addBook(Book book) {
        boolean res = false;
        Book tempSecuiry = this.getSecuritybyID(book.getBookID());
        if (tempSecuiry == null) {
            this.listBook.add(book);
            res = true;
        }

        return res;
    }

    public Book getSecuritybyID(String id) {
        Book resSecurity = null;
        for (int i = 0; i < this.listBook.size(); i++) {
            if (this.listBook.get(i).getBookID().equalsIgnoreCase(id)) {
                return listBook.get(i);
            }
        }
        return resSecurity;
    }

    public boolean deleteBookbyID(String id) {
        boolean res = false;
        Book tempBook = this.getSecuritybyID(id);
        if (tempBook != null) {
            this.listBook.remove(tempBook);
            res = true;
        }
        return res;
    }

    public ArrayList<Book> getCDbyType(String type) {
        ArrayList<Book> tempList = new ArrayList<>();
        for (int i = 0; i < this.listBook.size(); i++) {
            if (this.listBook.get(i).getType().equalsIgnoreCase(type)) {
                tempList.add(listBook.get(i));
            }
        }
        return tempList;
    }

    public ArrayList<Book> getBookbyCollection(String collection) {
        ArrayList<Book> tempList = new ArrayList<>();
        for (int i = 0; i < this.listBook.size(); i++) {
            if (this.listBook.get(i).getCollection().equalsIgnoreCase(collection)) {
                tempList.add(listBook.get(i));
            }
        }
        return tempList;
    }

    public ArrayList<Book> getBookbyTitle(String title) {
        ArrayList<Book> tempList = new ArrayList<>();
        for (int i = 0; i < this.listBook.size(); i++) {
            if (this.listBook.get(i).getTitle().equalsIgnoreCase(title)) {
                tempList.add(listBook.get(i));
            }
        }
        return tempList;
    }

    public boolean updateBookInfo(Book book) {
        boolean isSucc = false;
        for (int i = 0; i < this.listBook.size(); i++) {
            if (this.listBook.get(i).getBookID().equalsIgnoreCase(book.getBookID())) {
                this.listBook.remove(i);
                this.listBook.add(i, book);
                isSucc = true;
                break;

            }
        }
        return isSucc;
    }
    
  
    public ArrayList<Book> getListBook() {
        return listBook;
    }

    public int saveByteData() {
        this.myDao.saveListBookasByte(listBook);
        return this.listBook.size();
    }

    public int getByteData() {
        this.listBook = this.myDao.readListBookasByte();
        return this.listBook.size();
    }

    public int saveCharData() {
        this.myDao.saveListBookasChar(listBook);
        return this.listBook.size();
    }
    
    public BookTableModel getBookTableModel() {
        BookTableModel cdTableModel = new BookTableModel(listBook);
        return cdTableModel;
    }
}
