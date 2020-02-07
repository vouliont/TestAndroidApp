package com.vouliont.team.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        textView = findViewById(R.id.textView);
        textView.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            textView.setVisibility(View.VISIBLE);
        }
    }
}
