package com.usafenh;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.util.Log;

import java.util.List;

//TODO: Convert this activity into the FAQ Activity
public class FAQFragment extends Fragment{

    private static final String TAG = "FAQFragment";
    private MainActivity mainActivity;

    private QuestionAdapter mAdapter;
    private RecyclerView mQuestionRecyclerView;

    private UserData userData;

    public static FAQFragment newInstance() {
        FAQFragment fragment = new FAQFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        mainActivity = (MainActivity)getActivity();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");
        View v = inflater.inflate(R.layout.fragment_faq, container, false);

        mQuestionRecyclerView = (RecyclerView) v.findViewById(R.id.question_recycler_view);
        mQuestionRecyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));

        updateUI();

        return v;
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume() called");
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        Log.d(TAG, "updateUI() called");
        QuestionList questionList = QuestionList.get(mainActivity);
        List<Question> questions = questionList.getQuestions();

        if (mAdapter == null) {
            mAdapter = new QuestionAdapter(questions);
            mQuestionRecyclerView.setAdapter(mAdapter);
            mQuestionRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(mainActivity));
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class QuestionHolder extends RecyclerView.ViewHolder {
        private Question mQuestion;

        private TextView mQuestionTextView;
        private CheckBox mShowAnswerCheckBox;
        private TextView mAnswerTextView;

        public QuestionHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "questionHolder");

            mQuestionTextView = (TextView)itemView.findViewById(R.id.list_item_question_text_view);
            mShowAnswerCheckBox = (CheckBox)itemView.findViewById(R.id.list_item_show_answer_check_box);
            mAnswerTextView = (TextView)itemView.findViewById(R.id.list_item_answer_text_view);
        }

        public void bindQuestion(final Question question) {
            mQuestion = question;

            if (mQuestion.getQuestionResource() > 0) {
                mQuestionTextView.setText(mQuestion.getQuestionResource());
            } else {
                mQuestionTextView.setText(mQuestion.getQuestion());
            }

            if (mQuestion.getAnswerResource() > 0) {
                mAnswerTextView.setText(mQuestion.getAnswerResource());
            } else {
                mAnswerTextView.setText(mQuestion.getAnswer());
            }

            mShowAnswerCheckBox.setChecked(mQuestion.getShowAnswer());
            updateAnswerVisibility();

            mShowAnswerCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    // Set the question's show answer property
                    question.togglShowAnswer();
                    updateAnswerVisibility();
                }
            });
        }

        private void updateAnswerVisibility() {
            if(mQuestion.getShowAnswer()) {
                mAnswerTextView.setVisibility(View.VISIBLE);
            } else {
                mAnswerTextView.setVisibility(View.GONE);
            }
        }
    }

    private class QuestionAdapter extends RecyclerView.Adapter<QuestionHolder> {
        private List<Question> mQuestions;

        public QuestionAdapter(List<Question> questions) {
            Log.d(TAG, "QuestionAdapter");
            mQuestions = questions;
        }

        @Override
        public QuestionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(mainActivity);
            View view = layoutInflater.inflate(R.layout.list_item_question, parent, false);

            return new QuestionHolder(view);
        }

        @Override
        public void onBindViewHolder(QuestionHolder holder, int position) {
            Log.d(TAG, "onBindViewHolder");
            Question question = mQuestions.get(position);
            holder.bindQuestion(question);
        }

        @Override
        public int getItemCount() {
            Log.d(TAG, "getItemCount");
            return mQuestions.size();
        }

    }

    // Used to create dividing lines between questions
    public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
        private Drawable mDivider;

        public SimpleDividerItemDecoration(Context context) {
            mDivider = ContextCompat.getDrawable(context, R.drawable.line_divider);
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();

            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();

                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
    }
}
