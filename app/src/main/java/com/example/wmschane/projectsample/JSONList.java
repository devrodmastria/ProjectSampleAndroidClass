package com.example.wmschane.projectsample;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

public class JSONList {

    private static final String FILENAME = "ListObjects.json";

    private ArrayList<ListObject> mListObjects;
    private JSONSerializer mSerializer;
    private static ListObject sListObjectList;
    private Context mAppContext;

	public JSONList(Context appContext) {
		
        mAppContext = appContext;
        mSerializer = new JSONSerializer(mAppContext, FILENAME);

		try {
			// Try to load ListObject data from the ListObject JSON file
			// If the file is there, then the serializer object will load it
			mListObjects = mSerializer.loadListObjects();
		}
		catch (FileNotFoundException e) {
			// If file not found then create it with the following initial values
			mListObjects = new ArrayList<ListObject>();

			ListObject s1 = new ListObject();
			s1.setRoom("Basement");
			s1.setCheckbox(false);
			s1.setOnText("OFF");
			mListObjects.add(s1);
			ListObject s2 = new ListObject();
			s2.setRoom("Garage");
			s2.setCheckbox(true);
			s2.setOnText("ON");
			mListObjects.add(s2);
			ListObject s3 = new ListObject();
			s3.setRoom("Living Room");
			s3.setCheckbox(false);
			s3.setOnText("OFF");
			mListObjects.add(s3);

			// Save the initial list of ListObjects to a new file
			saveListObjects();
		}
		catch (Exception e) {
			// Some IO error other than file not found
			Log.e("JSONList","Error loading ListObjects: ", e);
		}
    }

	public boolean saveListObjects()
	{
        try {
            mSerializer.saveListObjects(mListObjects);
            return true;
        } 
        catch (Exception e) {
            Log.e("JSONList", "Error saving ListObjects: ", e);
            return false;
        }
	}
    
    public ArrayList<ListObject> getListObjects() {
        return mListObjects;
    }
}

