package com.example.thenotes;

import java.util.Date;

public class Note {
    private String mTitle;
    private String mNoteText;
    private Date mNoteCreationDate;

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmNoteText() {
        return mNoteText;
    }

    public void setmNoteText(String mNoteText) {
        this.mNoteText = mNoteText;
    }

    public Date getmNoteCreationDate() {
        return mNoteCreationDate;
    }

    public void setmNoteCreationDate(Date mNoteCreationDate) {
        this.mNoteCreationDate = mNoteCreationDate;
    }
}
