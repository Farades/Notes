package ru.mtplab.notes;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tess on 24.12.2014.
 */
public class Note {

    private String data;
    private String date;

    public Note(String data) {
        this.data = data;
        SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yy hh:mm");
        Date date = new Date();
        this.date = dt.format(date);
    }

    @Override
    public String toString() {
        return data;
    }

    public String getDate() {
        return this.date;
    }
}
