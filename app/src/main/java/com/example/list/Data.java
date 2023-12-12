package com.example.list;

import com.example.edit.Text;

public class Data {
    private String time;
    private String content;

    private Boolean box;
    private Text txt;

    private int id;
    public Data() {}

    public Data(String time, String content,Boolean box) {
        this.time = time;
        this.content = content;
        this.box = false;
        this.id=0;
        txt=new Text();
    }

    public String getCurTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getid(   ) {
        return  id;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Boolean getCheckBox() {
        return box;
    }

    public boolean isSelected() {
        return box ;
    }

    public void setSelected(boolean selected) {
        box=selected;



}}
