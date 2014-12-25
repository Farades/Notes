package ru.mtplab.notes;

import java.util.Date;

/**
 * Created by tess on 24.12.2014.
 */
public class Note {

    private String data;
    private Date date;

    public Note() {
        this.data = "";
        this.date = new Date();
    }

    public Note(String data) {
        this.data = data;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return data;
    }
}
