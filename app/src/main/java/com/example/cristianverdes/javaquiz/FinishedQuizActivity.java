package com.example.cristianverdes.javaquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Cristian Verdes on 4/12/2017.
 */

public class FinishedQuizActivity extends BaseActivity {

    public static void start(Context context, int score, String username) {
        Intent starter = new Intent(context, FinishedQuizActivity.class);
        starter.putExtra("score", score);
        starter.putExtra("username", username);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_quiz);

        ImageView image = (ImageView) findViewById(R.id.image);
        image.setImageResource(R.drawable.android_7);

        String username = getIntent().getStringExtra("username");
        int score = getIntent().getIntExtra("score", 0);

        TextView displayMessage = (TextView) findViewById(R.id.congratulation_text_view);
        TextView displayScore = (TextView) findViewById(R.id.score_text_view);

        String displayMessageS = "Congratulation " + username +"!";
        String displayScoreS = "You scored: " + Integer.toString(score) + " points.";

        displayMessage.setText(displayMessageS);
        displayScore.setText(displayScoreS);

        Button answersAndExplantions = (Button) findViewById(R.id.answers_and_explanations_button);
        answersAndExplantions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnswersActivity.start(FinishedQuizActivity.this);
            }
        });
    }
}