package com.usafenh;

public class CategoryWhatIs extends QuestionList {
    private static CategoryWhatIs sQuestionList;

    public static CategoryWhatIs get() {
        if (sQuestionList == null) {
            sQuestionList = new CategoryWhatIs();
        }
        return sQuestionList;
    }

    private CategoryWhatIs() {
        super();

        categoryTitleResource = R.string.Category_What_Is;

        addQuestion(new Question(R.string.q2, R.string.a2));
        addQuestion(new Question(R.string.q3, R.string.a3));
        addQuestion(new Question(R.string.q12, R.string.a12));
        addQuestion(new Question(R.string.q20, R.string.a20));
    }
}

