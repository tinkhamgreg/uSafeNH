package com.usafenh;

public class ConstantValues {
    //School related constants
    public static final String SCHOOL_TOKEN = "schoolResourceID";
    public static final int SCHOOL_UNH = R.string.UNH;
    public static final int SCHOOL_SAINT_ANSELM = R.string.Saint_Anselm;
    public static final int SCHOOL_KEENE_STATE = R.string.Keene_State;
    public static final int SCHOOL_WHITE_MOUNTAIN =R.string.White_Mountain;

    public static final String HELP_TYPE_TOKEN = "helpTypeResourceID";
    public static final int CRISIS_CENTERS = R.string.Crisis_centers;
    public static final int LOCAL_POLICE = R.string.Local_police;
    public static final int LOCAL_HOSPITAL = R.string.Local_hospital;
    public static final int CAMPUS_RESOURCES = R.string.Campus_resources;

    public static int getInfoReference(UserData userData) {
        switch(userData.getSchoolID()) {
            case SCHOOL_UNH:
                switch(userData.getHelpType()) {
                    case CRISIS_CENTERS:
                        return R.string.UNH_Crisis_centers;
                    case CAMPUS_RESOURCES:
                        return R.string.UNH_Campus_resources;
                    case LOCAL_HOSPITAL:
                        return R.string.UNH_Local_hospital;
                    case LOCAL_POLICE:
                        return R.string.UNH_Local_police;
                }
                break;
            case SCHOOL_KEENE_STATE:
                switch(userData.getHelpType()) {
                    case CRISIS_CENTERS:
                        return R.string.Keene_State_Crisis_centers;
                    case CAMPUS_RESOURCES:
                        return R.string.Keene_State_Campus_resources;
                    case LOCAL_HOSPITAL:
                        return R.string.Keene_State_Local_hospital;
                    case LOCAL_POLICE:
                        return R.string.Keene_State_Local_police;
                }
                break;
            case SCHOOL_SAINT_ANSELM:
                switch(userData.getHelpType()) {
                    case CRISIS_CENTERS:
                        return R.string.Saint_Anselm_Crisis_centers;
                    case CAMPUS_RESOURCES:
                        return R.string.Saint_Anselm_Campus_resources;
                    case LOCAL_HOSPITAL:
                        return R.string.Saint_Anselm_Local_hospital;
                    case LOCAL_POLICE:
                        return R.string.Saint_Anselm_Local_police;
                }
                break;
            case SCHOOL_WHITE_MOUNTAIN:
                switch(userData.getHelpType()) {
                    case CRISIS_CENTERS:
                        return R.string.White_Mountain_Crisis_centers;
                    case CAMPUS_RESOURCES:
                        return R.string.White_Mountain_Campus_resources;
                    case LOCAL_HOSPITAL:
                        return R.string.White_Mountain_Local_hospital;
                    case LOCAL_POLICE:
                        return R.string.White_Mountain_Local_police;
                }
                break;
        }

        return 0;
    }
}
