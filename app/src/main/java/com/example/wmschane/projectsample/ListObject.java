package com.example.wmschane.projectsample;

import org.json.JSONException;
import org.json.JSONObject;

public class ListObject {

    private Boolean checkbox;
    private String onText;
    private String room;

    public ListObject(){

    }

    public ListObject(String room, boolean checkBox, String onText){

        this.room = room;
        this.checkbox = checkBox;
        this.onText = onText;
    }

    public ListObject(JSONObject json) throws JSONException {
        room = json.getString("room");
        checkbox = json.getBoolean("checkbox");
        onText = json.getString("onText");
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("room", room);
        json.put("checkbox", checkbox);
        json.put("onText", onText);
        return json;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getOnText() {
        return onText;
    }

    public void setOnText(String onText) {
        this.onText = onText;
    }

    public Boolean getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(Boolean checkbox) {
        this.checkbox = checkbox;
    }
}
