package com.usafenh;

import android.content.Context;

public class UserData {
    private int schoolID;
    private int helpType;

    public void setSchoolID(int id) {
        schoolID = id;
    }

    public void setHelpType(int type) {
        helpType = type;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public String getSchoolName(Context resourceContext) {
        return resourceContext.getResources().getString(schoolID);
    }

    public int getHelpType() {
        return helpType;
    }

    public String getHelpString(Context resourceContext) {
        return resourceContext.getResources().getString(helpType);
    }
}
