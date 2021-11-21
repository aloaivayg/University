/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class Book implements Serializable{
    private String bookID;
    private String collection;
    private String type;
    private String title;
    private float price;
    private int yearOfRelease;
    
    public Book() {
        this.bookID = "";
        this.collection = "";
        this.type = "";
        this.title = "";
        this.price = 0.0f;
        this.yearOfRelease = 1900;
    }
    
    public Book(String bookID, String collection, String type, String title, float price, int yearOfRelease) {
        this.bookID= bookID;
        this.collection = collection;
        this.type = type;
        this.title = title;
        this.price = price;
        this.yearOfRelease = yearOfRelease;
    }

    public String getBookID() {
        return bookID;
    }

    public String getCollection() {
        return collection;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }
    
    
    public String getInfoAsString() {
        String str = this.getBookID();
        str += "," + this.getCollection();
        str += "," + this.getTitle();
        str += "," + this.getType();
        str += "," + this.getPrice();
        str += "," + this.getYearOfRelease();
        return str;
    }
    
}
