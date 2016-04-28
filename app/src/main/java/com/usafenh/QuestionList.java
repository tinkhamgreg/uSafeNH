package com.usafenh;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuestionList {
    private static QuestionList sQuestionList;

    protected int categoryTitleResource;

    private List<Question> mQuestions;

    private Boolean showQuestions = false;

    public static QuestionList get() {
        if (sQuestionList == null) {
            sQuestionList = new QuestionList();
        }
        return sQuestionList;
    }

    protected QuestionList() {
        mQuestions = new ArrayList<>();
    }

    protected void addQuestion(Question newQuestion) {
        mQuestions.add(newQuestion);
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

    public int getCategoryTitleResource() {
        return categoryTitleResource;
    }

    public Boolean getShowQuestions() {
        return showQuestions;
    }

    public void toggleShowQuestions() {
        showQuestions = !showQuestions;
    }
}
