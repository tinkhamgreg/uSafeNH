package com.usafenh;

public class CategoryHelpingOthers extends QuestionList {
    private static CategoryHelpingOthers sQuestionList;

    public static CategoryHelpingOthers get() {
        if (sQuestionList == null) {
            sQuestionList = new CategoryHelpingOthers();
        }
        return sQuestionList;
    }

    private CategoryHelpingOthers() {
        super();

        categoryTitleResource = R.string.Category_Helping_Others;

        addQuestion(new Question(R.string.q5, R.string.a5));
        addQuestion(new Question(R.string.q6, R.string.a6));
        addQuestion(new Question(R.string.q7, R.string.a7));
        addQuestion(new Question(R.string.q8, R.string.a8));
        addQuestion(new Question(R.string.q9, R.string.a9));
        addQuestion(new Question(R.string.q13, R.string.a13));
        addQuestion(new Question(R.string.q14, R.string.a14));
        addQuestion(new Question(R.string.q19, R.string.a19));
        addQuestion(new Question(R.string.q22, R.string.a22));
        addQuestion(new Question(R.string.q26, R.string.a26));
        addQuestion(new Question(R.string.q33, R.string.a33));
    }
}

