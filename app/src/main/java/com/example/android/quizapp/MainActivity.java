package com.example.android.quizapp;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // counter for correct answers
    private int answer_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void beginQuiz(View view) {
        setContentView(R.layout.quiz_layout);
    }

    private void radioGroupAnswerCheck(@IdRes int idRadioGroup, @IdRes int idCorrectRadioButton, @StringRes int idCorrectAnswerText) {
        //  checking answer for question 2
        RadioGroup rg = findViewById(idRadioGroup);
        RadioButton rb = findViewById(idCorrectRadioButton);
        //set green to correct answer
        rb.setTextColor(getResources().getColor(R.color.green));
        //check if answer selected and if it correct
        int selectedRadioButtonID = rg.getCheckedRadioButtonId();
        if (selectedRadioButtonID != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonID);
            String selectedRadioButtonText = selectedRadioButton.getText().toString();
            if (selectedRadioButtonText.equals(getString(idCorrectAnswerText)))
                answer_count++;
            else
                selectedRadioButton.setTextColor(getResources().getColor(R.color.red));
        }

    }

    private void textAnswerCheck(@IdRes int idCorrectAnswerHeader, @IdRes int idCorrectAnswerView, @IdRes int idAnswer, @StringRes int correctAnswerString) {
        // setting answer to be visible
        final TextView correctAnswerHeader = findViewById(idCorrectAnswerHeader);
        final TextView correctAnswerView = findViewById(idCorrectAnswerView);
        correctAnswerHeader.setVisibility(View.VISIBLE);
        correctAnswerView.setVisibility(View.VISIBLE);
        // checking if user introduced the correct answer
        final EditText answerView = findViewById(idAnswer);
        final String answer1_string = answerView.getText().toString();
        if (answer1_string.equalsIgnoreCase(getString(correctAnswerString))) {
            answerView.setTextColor(getResources().getColor(R.color.green));
            answer_count++;
        } else
            answerView.setTextColor(getResources().getColor(R.color.red));
    }

    private void displayToastResult() {
        // display Toast message with number of correct answers
        String toastMessage = getString(R.string.toast_message, answer_count);
        if (answer_count < 6) {
            if (answer_count != 1)
                toastMessage += " " + getString(R.string.multiple_answers) + " !";
            else
                toastMessage += " " + getString(R.string.single_answer) + " !";
            toastMessage += "\n" + getString(R.string.not_passed);
        } else
            toastMessage += " " + getString(R.string.multiple_answers) + " !\n" + getString(R.string.congrats);
        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
    }

    public void submitAnswers(View view) {

        //check if answer for Q1 is correct
        textAnswerCheck(R.id.q1_answer_header, R.id.q1_correct_answer, R.id.question_1_answer, R.string.continent);
        //check if answer for Q2 is correct
        radioGroupAnswerCheck(R.id.question_2_answer, R.id.q2_2, R.string.south_east);
        //check if answer for Q3 is correct
        radioGroupAnswerCheck(R.id.question_3_answer, R.id.q3_1, R.string.bucharest);

        //check if answer for Q4 is correct (multiple choices possible)
        int wrongAnswer = 0;
        CheckBox q4_1 = findViewById(R.id.q4_1);
        q4_1.setTextColor(getResources().getColor(R.color.green));
        CheckBox q4_2 = findViewById(R.id.q4_2);
        if (q4_2.isChecked()) {
            q4_2.setTextColor(getResources().getColor(R.color.red));
            wrongAnswer = 1;
        }
        CheckBox q4_3 = findViewById(R.id.q4_3);
        q4_3.setTextColor(getResources().getColor(R.color.green));
        CheckBox q4_4 = findViewById(R.id.q4_4);
        if (q4_4.isChecked()) {
            q4_4.setTextColor(getResources().getColor(R.color.red));
            wrongAnswer = 1;
        }
        CheckBox q4_5 = findViewById(R.id.q4_5);
        if (q4_5.isChecked()) {
            q4_5.setTextColor(getResources().getColor(R.color.red));
            wrongAnswer = 1;
        }
        CheckBox q4_6 = findViewById(R.id.q4_6);
        if (q4_6.isChecked()) {
            q4_6.setTextColor(getResources().getColor(R.color.red));
            wrongAnswer = 1;
        }
        CheckBox q4_7 = findViewById(R.id.q4_7);
        q4_7.setTextColor(getResources().getColor(R.color.green));
        CheckBox q4_8 = findViewById(R.id.q4_8);
        q4_8.setTextColor(getResources().getColor(R.color.green));

        if (q4_1.isChecked() && q4_3.isChecked() && q4_7.isChecked() && q4_8.isChecked() && wrongAnswer == 0)
            answer_count++;

        //check if answer for Q5 is correct
        radioGroupAnswerCheck(R.id.question_5_answer, R.id.q5_2, R.string.y2004);
        //check if answer for Q6 is correct
        textAnswerCheck(R.id.q6_answer_header, R.id.q6_correct_answer, R.id.question_6_answer, R.string.counties);
        //check if answer for Q8 is correct
        radioGroupAnswerCheck(R.id.question_7_answer, R.id.q7_3, R.string.sibiu);

        //check if answer for Q8 is correct
        wrongAnswer = 0;
        CheckBox q8_1 = findViewById(R.id.q8_1);
        ImageView image8_1 = findViewById(R.id.image8_1);
        image8_1.setBackgroundColor(getResources().getColor(R.color.green));
        CheckBox q8_2 = findViewById(R.id.q8_2);
        if (q8_2.isChecked()) {
            ImageView image8_2 = findViewById(R.id.image8_2);
            image8_2.setBackgroundColor(getResources().getColor(R.color.red));
            wrongAnswer = 1;
        }
        CheckBox q8_3 = findViewById(R.id.q8_3);
        if (q8_3.isChecked()) {
            ImageView image8_3 = findViewById(R.id.image8_3);
            image8_3.setBackgroundColor(getResources().getColor(R.color.red));
            wrongAnswer = 1;
        }
        CheckBox q8_4 = findViewById(R.id.q8_4);
        ImageView image8_4 = findViewById(R.id.image8_4);
        image8_4.setBackgroundColor(getResources().getColor(R.color.green));
        CheckBox q8_5 = findViewById(R.id.q8_5);
        if (q8_5.isChecked()) {
            ImageView image8_5 = findViewById(R.id.image8_5);
            image8_5.setBackgroundColor(getResources().getColor(R.color.red));
            wrongAnswer = 1;
        }
        CheckBox q8_6 = findViewById(R.id.q8_6);
        ImageView image8_6 = findViewById(R.id.image8_6);
        image8_6.setBackgroundColor(getResources().getColor(R.color.green));
        if (q8_1.isChecked() && q8_4.isChecked() && q8_6.isChecked() && wrongAnswer == 0)
            answer_count++;

        //check if answer for Q9 is correct
        radioGroupAnswerCheck(R.id.question_9_answer, R.id.q9_1, R.string.danube);
        //check if answer for Q10 is correct
        radioGroupAnswerCheck(R.id.question_10_answer, R.id.q10_2, R.string.black_sea);

        //hide submit button so it can not be resubmitted
        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setVisibility(View.GONE);

        //display Toast message with the result of the quiz (number of correct answers and if the test was successful or not)
        displayToastResult();
    }

}
