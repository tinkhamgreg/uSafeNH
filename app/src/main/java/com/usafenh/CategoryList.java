package com.usafenh;

import java.util.ArrayList;
import java.util.List;

public class CategoryList {
    protected static CategoryList sCategoryList;

    private List<QuestionList> mCategories;

    public static CategoryList get() {
        if (sCategoryList == null) {
            sCategoryList = new CategoryList();
        }
        return sCategoryList;
    }

    protected CategoryList() {
        mCategories = new ArrayList<>();

        mCategories.add(CategoryIWasJust.get());
        mCategories.add(CategoryWhatIs.get());
        mCategories.add(CategoryHelpingOthers.get());
        mCategories.add(CategoryCollegePolicy.get());
    }

    public List<QuestionList> getCategories() {
        return mCategories;
    }
}
