package com.jimmy.romyim.fifthlesson;


import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        order = 0;
        this.answer = (RadioGroup)findViewById(R.id.radio_group);
        this.question = (TextView)findViewById(R.id.question);
        this.sureButton = (Button)findViewById(R.id.OK);
        this.spectificQuestion = this.getResources().getStringArray(R.array.question);
        this.question.setText(this.spectificQuestion[order]);
        this.intent = new Intent(MainActivity.this, ResultActivity.class);
        this.answer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.answer1)
                    result = true;
                else
                    result = false;
                intent.putExtra("result", result);
                intent.putExtra("order", order);
            }
        });
        this.sureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.answer.clearCheck();
        order = data.getIntExtra("order", 0);
        this.question.setText(this.spectificQuestion[order]);
    }

    RadioGroup answer;
    TextView question;
    Button sureButton;

    static int order;
    Intent intent;
    Boolean result;
    String[] spectificQuestion;
}
