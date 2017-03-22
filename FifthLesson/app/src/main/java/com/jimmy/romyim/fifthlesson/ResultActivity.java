package com.jimmy.romyim.fifthlesson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        this.resultText = (TextView)findViewById(R.id.result);
        this.backButton = (Button)findViewById(R.id.back);
        this.intent = new Intent();
        this.result = getIntent().getBooleanExtra("result", false);
        this.order = getIntent().getIntExtra("order", 0);
        if (this.result) {
            this.order++;
            this.resultText.setText(getResources().getText(R.string.true_result));
        }
        else
            this.resultText.setText(getResources().getText(R.string.wrong_result));
        this.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (order == 5)
                    resultText.setText(getResources().getText(R.string.result));
                else {
                    intent.putExtra("order", order);
                    ResultActivity.this.setResult(0, intent);
                    ResultActivity.this.finish();
                }
            }
        });
    }


    Button backButton;
    TextView resultText;

    int order;
    Intent intent;
    Boolean result;
}
