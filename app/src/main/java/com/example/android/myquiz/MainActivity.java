package com.example.android.myquiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int totalQuestions = 4;
    int totalScore = 0;
    int answer;
    int correctId;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submit(View view){
        RadioGroup radioGroup1 = findViewById(R.id.radioGroup1);
        answer = radioGroup1.getCheckedRadioButtonId();
        RadioButton radioButton1 =  findViewById(R.id.answer1B);
        correctId = radioButton1.getId();
        if(answer == correctId){
            totalScore ++;
        }

        CheckBox checkBox1 = findViewById(R.id.answer2A);
        CheckBox checkbox2 = findViewById(R.id.answer2B);
        CheckBox checkBox3 = findViewById(R.id.answer2C);
        CheckBox checkBox4 = findViewById(R.id.answer2D);
        if(checkBox1.isChecked() && checkbox2.isChecked() && checkBox3.isChecked()){
            totalScore ++;
        }

        RadioGroup radioGroup3 = findViewById(R.id.radioGroup3);
        answer = radioGroup3.getCheckedRadioButtonId();
        RadioButton radioButton2 = findViewById(R.id.right);
        correctId = radioButton2.getId();
        if(answer == correctId){
            totalScore ++;
        }

        EditText editText = findViewById(R.id.answer4);
        String answer = String.valueOf(editText.getText()).toLowerCase();
        if(answer.equals("kinetic") || answer.equals("kinetic energy")){
            totalScore ++;
        }

        message = "You have " + totalScore + " correct answers out of " + totalQuestions;

        /*Toast toast = Toast.makeText(getApplicationContext(),toastMessage,Toast.LENGTH_LONG);
        toast.show();*/

        // Reset all the fields.
        totalScore = 0;
        radioGroup1.clearCheck();
        radioGroup3.clearCheck();
        checkBox1.setChecked(false);
        checkbox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox4.setChecked(false);
        editText.setText("");

        Intent scoreIntent = new Intent(MainActivity.this, ScoreActivity.class);
        scoreIntent.putExtra("score",message );
        startActivity(scoreIntent);

    }
}
