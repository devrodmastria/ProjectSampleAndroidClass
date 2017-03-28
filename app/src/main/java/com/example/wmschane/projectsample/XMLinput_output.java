package com.example.wmschane.projectsample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.content.Context;
import android.util.Log;

public class XMLinput_output {

    private final String FILENAME = "project.xml";
    private Context context = null;

    public XMLinput_output(Context context)
    {
        String string = "<?xml version=\"1.0\"?>" +
            "<settings>" +
            "<row><room>Bedroom 1</room><checkbox>true</checkbox><ontext>ON</ontext></row>" +
            "<row><room>Kitchen</room><checkbox>false</checkbox><ontext>ON</ontext></row>" +
            "</settings>";

        this.context = context;
        try {
            FileOutputStream out = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            out.write(string.getBytes());
            out.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }


    public ArrayList<HashMap<String, Object>> readFile() {
        try {
            // get the XML reader
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader xmlreader = parser.getXMLReader();

            // set content handler
            XMLListHandler theXMLHandler = new XMLListHandler();
            xmlreader.setContentHandler(theXMLHandler);

            // read the file from internal storage
            FileInputStream in = context.openFileInput(FILENAME);

            // parse the data
            InputSource is = new InputSource(in);
            xmlreader.parse(is);

            // set the feed in the activity
            ArrayList<HashMap<String, Object>> settings = theXMLHandler.getSettings();
            return settings;
        }
        catch (Exception e) {
            Log.e("Settings Reader", e.toString());
            return null;
        }
    }
}
