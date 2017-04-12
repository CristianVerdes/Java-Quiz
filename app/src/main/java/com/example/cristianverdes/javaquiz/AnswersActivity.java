package com.example.cristianverdes.javaquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Cristian Verdes on 4/12/2017.
 */

public class AnswersActivity extends BaseActivity {
    TextView answers;

    public static void start(Context context) {
        Intent starter = new Intent(context, AnswersActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        answers = (TextView) findViewById(R.id.answers);

        String text = getString(R.string.all_answers);
        answers.setText(text);
    }
}
