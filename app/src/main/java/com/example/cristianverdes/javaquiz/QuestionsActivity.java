package com.example.cristianverdes.javaquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Cristian Verdes on 4/12/2017.
 */

public class QuestionsActivity extends BaseActivity {
    private Context context = this;

    private static String username;
    private int questionId = 0;
    public int score = 0;

    ImageView image;
    TextView question;
    RadioGroup answers;
    RadioButton answerA;
    RadioButton answerB;
    RadioButton answerC;

    private Button nextQuestion;

    public static void start(Context context, String name) {
        Intent starter = new Intent(context, QuestionsActivity.class);
        starter.putExtra("name", name);
        context.startActivity(starter);
    }

    public static void nextQuestionStarter(Context context, int questionId, int score){
        Intent starter = new Intent(context, QuestionsActivity.class);
        starter.putExtra("questionId", questionId);
        starter.putExtra("score", score);
        context.startActivity(starter);
    }

    public void calculateScore(int checkerId){
        switch (questionId){
            case 0:
                if(checkerId == R.id.answer_a){
                    score++;
                }
                break;
            case 1:
                if(checkerId == R.id.answer_c){
                    score++;
                }
                break;
            case 2:
                if(checkerId == R.id.answer_a){
                    score++;
                }
                break;
            case 3:
                if(checkerId == R.id.answer_b){
                    score++;
                }
                break;
            case 4:
                if(checkerId == R.id.answer_c){
                    score++;
                }
                break;
            case 5:
                if(checkerId == R.id.answer_b){
                    score++;
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        questionId = getIntent().getIntExtra("questionId", 0);
        score = getIntent().getIntExtra("score", 0);

        if (questionId == 0){
            username = getIntent().getStringExtra("name");
        }

        image = (ImageView) findViewById(R.id.image);
        question = (TextView) findViewById(R.id.question);
        answers = (RadioGroup) findViewById(R.id.answers);
        answerA = (RadioButton) findViewById(R.id.answer_a);
        answerB = (RadioButton) findViewById(R.id.answer_b);
        answerC = (RadioButton) findViewById(R.id.answer_c);

        nextQuestion = (Button) findViewById(R.id.next_question_button);

        switch (questionId){
            case 0:
                image.setImageResource(R.drawable.android_1);
                question.setText(R.string.question_1);
                answerA.setText(R.string.question_1_answer_a);
                answerB.setText(R.string.question_1_answer_b);
                answerC.setText(R.string.question_1_answer_c);

                break;
            case 1:
                image.setImageResource(R.drawable.android_2);
                question.setText(R.string.question_2);
                answerA.setText(R.string.question_2_answer_a);
                answerB.setText(R.string.question_2_answer_b);
                answerC.setText(R.string.question_2_answer_c);
                break;
            case 2:
                image.setImageResource(R.drawable.android_3);
                question.setText(R.string.question_3);
                answerA.setText("0");
                answerB.setText("0.0");
                answerC.setText(R.string.question_3_answer_c);
                break;
            case 3:
                image.setImageResource(R.drawable.android_4);
                question.setText(R.string.question_4);
                answerA.setText(R.string.question_4_answer_a);
                answerB.setText(R.string.question_4_answer_b);
                answerC.setText(R.string.question_4_answer_c);
                break;
            case 4:
                image.setImageResource(R.drawable.android_5);
                question.setText(R.string.question_5);
                answerA.setText(R.string.question_5_answer_a);
                answerB.setText(R.string.question_5_answer_b);
                answerC.setText(R.string.question_5_answer_c);
                break;
            case 5:
                image.setImageResource(R.drawable.android_6);
                question.setText(R.string.question_6);
                answerA.setText(R.string.question_6_answer_a);
                answerB.setText(R.string.question_6_answer_b);
                answerC.setText(R.string.question_6_answer_c);
                break;
            default:
                FinishedQuizActivity.start(this, score, username);
        }

        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = answers.getCheckedRadioButtonId();
                // Calculate Score
                calculateScore(selectedId);
                // Increment question ID
                questionId++;
                QuestionsActivity.nextQuestionStarter(context, questionId, score);
            }
        });

    }
}
