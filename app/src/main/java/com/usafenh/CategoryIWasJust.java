package com.usafenh;

public class CategoryIWasJust extends QuestionList {
    private static CategoryIWasJust sQuestionList;

    public static CategoryIWasJust get() {
        if (sQuestionList == null) {
            sQuestionList = new CategoryIWasJust();
        }
        return sQuestionList;
    }

    private CategoryIWasJust() {
        super();

        categoryTitleResource = R.string.Category_I_Was_Just;

        addQuestion(new Question(R.string.q1, R.string.a1));
        addQuestion(new Question(R.string.q4, R.string.a4));
        addQuestion(new Question(R.string.q11, R.string.a11));
        addQuestion(new Question(R.string.q30, R.string.a30));
    }
}

