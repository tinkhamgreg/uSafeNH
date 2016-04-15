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

        for (int i = 0; i < 20; i++) {
            Question question = new Question("Is this a question?", "Yes, yes it is.");
            mQuestions.add(question);
        }
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
