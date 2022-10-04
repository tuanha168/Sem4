package com.t2009e.class3navigation.listview;

public class ListItem {
    String title;
    String position;
    String location;

    public ListItem(String title, String position, String location) {
        this.title = title;
        this.position = position;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
