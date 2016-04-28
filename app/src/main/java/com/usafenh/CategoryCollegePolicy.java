package com.usafenh;

public class CategoryCollegePolicy extends QuestionList {
    private static CategoryCollegePolicy sQuestionList;

    public static CategoryCollegePolicy get() {
        if (sQuestionList == null) {
            sQuestionList = new CategoryCollegePolicy();
        }
        return sQuestionList;
    }

    private CategoryCollegePolicy() {
        super();

        categoryTitleResource = R.string.Category_College_Policy;

        addQuestion(new Question(R.string.q10, R.string.a10));
        addQuestion(new Question(R.string.q21, R.string.a21));
        addQuestion(new Question(R.string.q31, R.string.a31));
        addQuestion(new Question(R.string.q34, R.string.a34));
    }
}

