package com.example.thenotes;

import java.util.Date;

public class Note {
    private String mTitle;
    private String mNoteText;
    private Date mNoteCreationDate;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getNoteText() {
        return mNoteText;
    }

    public void setNoteText(String mNoteText) {
        this.mNoteText = mNoteText;
    }

    public Date getNoteCreationDate() {
        return mNoteCreationDate;
    }

    public void setNoteCreationDate(Date mNoteCreationDate) {
        this.mNoteCreationDate = mNoteCreationDate;
    }
}
