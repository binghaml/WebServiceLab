package com.example.levi.webservicelab.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Levi on 4/25/2016.
 */
public class Course implements Serializable {

    public static final String ID = "id", SHORT_DESC = "shortDesc", LONG_DESC = "longDesc", PRE_REQS = "prereqs";

    public String mCourseId;
    public String mShortDescription;
    public String mLongDescription;
    public String mPrereqs;

    public Course(String mCourseId, String mShortDescription, String mLongDescription, String mPrereqs) {
        this.mCourseId = mCourseId;
        this.mShortDescription = mShortDescription;
        this.mLongDescription = mLongDescription;
        this.mPrereqs = mPrereqs;
    }

    /**  * Parses the json string, returns an error message if unsuccessful.  * Returns course list if success.
     * @param courseJSON  * @return reason or null if successful.
     */
    public static String parseCourseJSON(String courseJSON, List<Course> courseList) {
        String reason = null;
        if (courseJSON != null) {
            try {
                JSONArray arr = new JSONArray(courseJSON);
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Course course = new Course(obj.getString(Course.ID), obj.getString(Course.SHORT_DESC)
                            , obj.getString(Course.LONG_DESC), obj.getString(Course.PRE_REQS));
                    courseList.add(course);
                }
            } catch (JSONException e) {
                reason =  "Unable to parse data, Reason: " + e.getMessage();
            }
        }
        return reason;
    }

    public String getmCourseId() {
        return mCourseId;
    }

    public void setmCourseId(String mCourseId) throws IllegalArgumentException{
        if(mCourseId == null){
            throw new IllegalArgumentException("Course ID is null");
        } else if(mCourseId.length() <= 5) {
            throw new IllegalArgumentException("Course ID was too short");
        } else {
            this.mCourseId = mCourseId;
        }
    }

    public String getmShortDescription() {
        return mShortDescription;
    }

    public void setmShortDescription(String mShortDescription) {
        this.mShortDescription = mShortDescription;
    }

    public String getmLongDescription() {
        return mLongDescription;
    }

    public void setmLongDescription(String mLongDescription) {
        this.mLongDescription = mLongDescription;
    }

    public String getmPrereqs() {
        return mPrereqs;
    }

    public void setmPrereqs(String mPrereqs) {
        this.mPrereqs = mPrereqs;
    }



}
