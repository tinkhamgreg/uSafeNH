package com.usafenh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

//TODO: Convert this activity into the FAQ Activity
public class FAQFragment extends Fragment{

    private static final String TAG = "FAQFragment";
    private MainActivity mainActivity;

    private CategoryAdapter mCategoryAdapter;
    private RecyclerView mCategoryRecyclerView;

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

        mCategoryRecyclerView = (RecyclerView) v.findViewById(R.id.category_recycler_view);
        mCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));

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
        CategoryList categoryList = CategoryList.get();
        List<QuestionList> categories = categoryList.getCategories();

        if (mCategoryAdapter == null) {
            mCategoryAdapter = new CategoryAdapter(categories);
            mCategoryRecyclerView.setAdapter(mCategoryAdapter);
            mCategoryRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(mainActivity));
        } else {
            mCategoryAdapter.notifyDataSetChanged();
        }
    }
    
    private class CategoryHolder extends RecyclerView.ViewHolder {
        private QuestionAdapter mQuestionAdapter;
        private QuestionList mCategory;

        private RelativeLayout mCategoryLayout;
        private TextView mCategoryTextView;
        private ImageView mArrowImage;
        private RecyclerView mQuestionRecycler;

        public CategoryHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "CategoryHolder");

            mCategoryLayout = (RelativeLayout)itemView.findViewById(R.id.list_item_category_layout);
            mCategoryTextView = (TextView)itemView.findViewById(R.id.list_item_category_text_view);
            mArrowImage = (ImageView)itemView.findViewById(R.id.list_item_arrow_image);
            mQuestionRecycler = (RecyclerView)itemView.findViewById(R.id.question_recycler_view2);
        }

        public void bindCategory(final QuestionList category) {
            mCategory = category;

            if (mCategory.getCategoryTitleResource() > 0) {
                mCategoryTextView.setText(mCategory.getCategoryTitleResource());
            }

            if (mQuestionAdapter == null) {
                mQuestionAdapter = new QuestionAdapter(mCategory.getQuestions());
                mQuestionRecycler.setLayoutManager(new LinearLayoutManager(mainActivity));
                mQuestionRecycler.setAdapter(mQuestionAdapter);
                mQuestionRecycler.addItemDecoration(new SimpleDividerItemDecoration(mainActivity));
            } else {
                mQuestionAdapter.notifyDataSetChanged();
            }

            updateQuestionVisibility();

            mCategoryLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Set the category's show questions property
                    category.toggleShowQuestions();
                    updateQuestionVisibility();
                }
            });
        }

        private void updateQuestionVisibility() {
            if(mCategory.getShowQuestions()) {
                mQuestionRecycler.setVisibility(View.VISIBLE);
                mArrowImage.setImageResource(R.mipmap.up_arrow);
            } else {
                mArrowImage.setImageResource(R.mipmap.down_arrow);
                mQuestionRecycler.setVisibility(View.GONE);
            }
        }
    }

    private class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder> {
        private List<QuestionList> mCategories;

        public CategoryAdapter(List<QuestionList> Categories) {
            Log.d(TAG, "CategoryAdapter");
            mCategories = Categories;
        }

        @Override
        public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(mainActivity);
            View view = layoutInflater.inflate(R.layout.list_item_category, parent, false);

            return new CategoryHolder(view);
        }

        @Override
        public void onBindViewHolder(CategoryHolder holder, int position) {
            Log.d(TAG, "onBindViewHolder");
            QuestionList category = mCategories.get(position);
            holder.bindCategory(category);
        }

        @Override
        public int getItemCount() {
            Log.d(TAG, "getItemCount");
            return mCategories.size();
        }

    }

    private class QuestionHolder extends RecyclerView.ViewHolder {
        private Question mQuestion;

        private RelativeLayout mQuestionLayout;
        private TextView mQuestionTextView;
        private ImageView mArrowImage;
        private TextView mAnswerTextView;

        public QuestionHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "questionHolder");

            mQuestionLayout = (RelativeLayout)itemView.findViewById(R.id.list_item_question_layout);
            mQuestionTextView = (TextView)itemView.findViewById(R.id.list_item_question_text_view);
            mArrowImage = (ImageView)itemView.findViewById(R.id.list_item_arrow_image);
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

            updateAnswerVisibility();

            mQuestionLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Set the question's show answer property
                    question.toggleShowAnswer();
                    updateAnswerVisibility();
                }
            });
        }

        private void updateAnswerVisibility() {
            if(mQuestion.getShowAnswer()) {
                mAnswerTextView.setVisibility(View.VISIBLE);
                mArrowImage.setImageResource(R.mipmap.up_arrow);
            } else {
                mArrowImage.setImageResource(R.mipmap.down_arrow);
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
