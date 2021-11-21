/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Book;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class BookDAO {
     private String pathStr = "Data";
    private String fileNameChar = "Book_Data_Character.txt";
    private String fileNameByte = "Book_Data_Byte.txt";

    public BookDAO() {
        this.createFolder();
    }

  
    public void createFolder() {
        File folder = new File(pathStr);
        if (folder.exists()) {
            System.out.println("Folder exist");
        } else {
            folder.mkdirs();
            System.out.println("Folder created");
        }
    }

  
    public void saveListBookasByte(ArrayList<Book> listBook) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(pathStr + "\\" + fileNameByte);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(listBook);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                fos.close();
                oos.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public ArrayList<Book> readListBookasByte() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Book> listBook = new ArrayList<>();
        try {
            fis = new FileInputStream(pathStr + "\\" + fileNameByte);
            ois = new ObjectInputStream(fis);
            listBook = (ArrayList<Book>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                fis.close();
                ois.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return listBook;
    }

    public void saveListBookasChar(ArrayList<Book> listStudent) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(pathStr + "\\" + fileNameChar);
            bw = new BufferedWriter(fw);

            for (int i = 0; i < listStudent.size(); i++) {
                bw.write(listStudent.get(i).getInfoAsString());
                bw.newLine();
            }

            bw.flush();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                fw.close();
                bw.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
