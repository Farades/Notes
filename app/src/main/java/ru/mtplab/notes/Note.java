package ru.mtplab.notes;

import java.util.Date;

/**
 * Created by tess on 24.12.2014.
 */
public class Note {

    private String title;
    private String data;
    private Date date;

    public Note() {
        this.title = "";
        this.data = "";
        this.date = new Date();
    }

    public Note(String title, String data) {

    }
}
