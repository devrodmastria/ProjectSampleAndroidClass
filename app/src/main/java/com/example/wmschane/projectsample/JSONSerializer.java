package com.example.wmschane.projectsample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.content.Context;

public class JSONSerializer {

    private Context mContext;
    private String mFilename;

    public JSONSerializer(Context c, String f) {
        mContext = c;
        mFilename = f;
        File file = new File(mFilename);
        if (file.exists())
            file.delete();
    }

    public ArrayList<ListObject> loadListObjects() throws IOException, JSONException {
        ArrayList<ListObject> objects = new ArrayList<ListObject>();
        BufferedReader reader = null;
        try {
            // open and read the file into a StringBuilder
            InputStream in = mContext.openFileInput(mFilename);

            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                // line breaks are omitted and irrelevant
                jsonString.append(line);
            }
            // parse the JSON using JSONTokener
            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            // build the array of objects from JSONObjects

            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObj = array.getJSONObject(i);
                objects.add(new ListObject(jsonObj));
            }
        } catch (FileNotFoundException e) {
        	// If the JSON data file was not found, throw this same exception
        	// back to the calling code and let it decide how to handle it
            throw e;
        } finally {
            if (reader != null)
                reader.close();
}
        return objects;
    }

    public void saveListObjects(ArrayList<ListObject> objects) throws JSONException, IOException {
        // build an array in JSON
        JSONArray array = new JSONArray();
        for (ListObject c : objects)
            array.put(c.toJSON());

        // write the file to disk
        Writer writer = null;
        try {
            OutputStream out = mContext.openFileOutput(mFilename, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        } 
        finally {
            if (writer != null)
                writer.close();
        }
    }
}
