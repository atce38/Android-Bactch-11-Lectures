package com.abidingtech.www.androidbactch11.Lecture15;


import com.orm.SugarRecord;

public class Book extends SugarRecord {
     String title;
     String edition;

    public Book() {
    }

    public Book(String title, String edition) {
        this.title = title;
        this.edition = edition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}
