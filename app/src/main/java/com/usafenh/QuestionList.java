package com.usafenh;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuestionList {
    private static QuestionList sQuestionList;

    private List<Question> mQuestions;

    public static QuestionList get(Context context) {
        if (sQuestionList == null) {
            sQuestionList = new QuestionList(context);
        }
        return sQuestionList;
    }

    private QuestionList(Context context) {
        mQuestions = new ArrayList<>();

        mQuestions.add(new Question(R.string.q1, R.string.a1));
        mQuestions.add(new Question(R.string.q2, R.string.a2));
        mQuestions.add(new Question(R.string.q3, R.string.a3));
        mQuestions.add(new Question(R.string.q4, R.string.a4));
        mQuestions.add(new Question(R.string.q5, R.string.a5));
        mQuestions.add(new Question(R.string.q6, R.string.a6));
        mQuestions.add(new Question(R.string.q7, R.string.a7));
        mQuestions.add(new Question(R.string.q8, R.string.a8));
        mQuestions.add(new Question(R.string.q9, R.string.a9));
        mQuestions.add(new Question(R.string.q10, R.string.a10));
        mQuestions.add(new Question(R.string.q11, R.string.a11));
    }

    public List<Question> getQuestions() {
        return mQuestions;
    }

    public Question getQuestion(UUID id) {
        for (Question question : mQuestions) {
            if (question.getId().equals(id)) {
                return question;
            }
        }

        return null;
    }

    public int getQuestionIndex(UUID id) {
        for (int i = 0; i < mQuestions.size(); i++) {
            if (mQuestions.get(i).getId().equals(id)) {
                return i;
            }
        }

        return -1;
    }
}
