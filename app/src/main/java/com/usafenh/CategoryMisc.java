package com.usafenh;

public class CategoryMisc extends QuestionList {
    private static CategoryMisc sQuestionList;

    public static CategoryMisc get() {
        if (sQuestionList == null) {
            sQuestionList = new CategoryMisc();
        }
        return sQuestionList;
    }

    private CategoryMisc() {
        super();

        categoryTitleResource = R.string.Category_Misc;

        addQuestion(new Question(R.string.q15, R.string.a15));
        addQuestion(new Question(R.string.q16, R.string.a16));
        addQuestion(new Question(R.string.q17, R.string.a17));
        addQuestion(new Question(R.string.q18, R.string.a18));
        addQuestion(new Question(R.string.q23, R.string.a23));
        addQuestion(new Question(R.string.q24, R.string.a24));
        addQuestion(new Question(R.string.q25, R.string.a25));
        addQuestion(new Question(R.string.q27, R.string.a27));
        addQuestion(new Question(R.string.q28, R.string.a28));
        addQuestion(new Question(R.string.q29, R.string.a29));
        addQuestion(new Question(R.string.q32, R.string.a23));
    }
}

