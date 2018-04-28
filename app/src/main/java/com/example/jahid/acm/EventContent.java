package com.example.jahid.acm;

/**
 * Created by jhasan on 1/12/17.
 */

public class EventContent {
    private String textT;
    private String textP;
    private int imageid;

    public EventContent(String textT, String textP, int imageid) {
        this.textT = textT;
        this.textP = textP;
        this.imageid = imageid;
    }

    public String getTextT() {
        return textT;
    }

    public String getTextP() {
        return textP;
    }

    public int getImageid() {
        return imageid;
    }
}
