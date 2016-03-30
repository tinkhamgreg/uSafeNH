package com.usafenh;

import android.content.Context;

public class UserData {
    private int schoolID;
    private int userType;

    public void setSchoolID(int id) {
        schoolID = id;
    }

    public void setUserType(int type) {
        userType = type;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public String getSchoolName(Context resourceContext) {
        return resourceContext.getResources().getString(schoolID);
    }

    public int getUserType() {
        return userType;
    }

    public String getUserString(Context resourceContext) {
        return resourceContext.getResources().getString(userType);
    }
}
