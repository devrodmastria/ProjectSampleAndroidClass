package com.example.wmschane.projectsample;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.util.ArrayList;
import java.util.HashMap;

public class XMLListHandler extends DefaultHandler {

    String currentItem;
    HashMap<String, Object> map;
    ArrayList<HashMap<String, Object>> settings;

    public ArrayList<HashMap<String, Object>> getSettings() {
        return settings;
    }

    @Override
    public void startDocument() throws SAXException {
        settings = new ArrayList<>();
    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws SAXException {

        if (qName.equals("row"))
            map = new HashMap<>();
        else
            currentItem = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName,
                           String qName) throws SAXException
    {
        if (qName.equals("row"))
            settings.add(map);
    }

    @Override
    public void characters(char ch[], int start, int length) {
        String s = new String(ch, start, length);

        switch(currentItem)
        {
            case "room": map.put("room", s); break;
            case "checkbox":
                if (s.equals("true")) map.put("checkbox", true);
                else map.put("checkbox", false);
                break;
            case "ontext": map.put("ontext", s);
        }
    }
}