package com.example.jahid.acm.model;

/**
 * Created by jAHID on 11/10/2017.
 */

public class itemof {
    private String text,subtext,subtext2;
    private boolean isExpan;

    public itemof(String text, String subtext, boolean isExpan) {
        this.text = text;
        this.subtext = subtext;
        this.isExpan = isExpan;
    }
    public itemof(String text, String subtext,String subtext2, boolean isExpan) {
        this.text = text;
        this.subtext = subtext;
        this.subtext2 = subtext2;
        this.isExpan = isExpan;

    }
    public itemof(String text,boolean isExpan){

        this.text=text;
        this.isExpan=isExpan;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public boolean isExpan() {
        return isExpan;
    }

    public void setExpan(boolean expan) {
        isExpan = expan;
    }

    public String getSubtext2() {
        return subtext2;
    }

    public void setSubtext2(String subtext2) {
        this.subtext2 = subtext2;
    }
}
