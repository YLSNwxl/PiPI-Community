package com.example.ylsn.unimportant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import static com.example.ylsn.unimportant.LoginActivity.butflag;

public class MyloveActivity extends AppCompatActivity {
    private LinearLayout mylove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylove);
        mylove=(LinearLayout)findViewById(R.id.mylove);
        if(butflag){
            mylove.setVisibility(View.GONE);
        }
    }
}
