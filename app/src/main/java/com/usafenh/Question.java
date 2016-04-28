package com.usafenh;

import java.util.UUID;

public class Question {
    private UUID mId;
    private String question;
    private String answer;
    private int questionResource;
    private int answerResource;
    private boolean showAnswer;

    public Question(String q, String a) {
        // Generate unique identifier
        mId = UUID.randomUUID();
        question = q;
        answer = a;
        showAnswer = false;
    }

    public Question(int q, int a) {
        // Generate unique identifier
        mId = UUID.randomUUID();
        questionResource = q;
        answerResource = a;
        showAnswer = false;
    }

    public UUID getId() {
        return mId;
    }

    public String getQuestion() {
        return question;
    }

    public int getQuestionResource() {
        return questionResource;
    }

    public String getAnswer() {
        return answer;
    }

    public int getAnswerResource() {
        return answerResource;
    }

    public boolean getShowAnswer() {
        return showAnswer;
    }

    public void toggleShowAnswer() {
        showAnswer = !showAnswer;
    }
}