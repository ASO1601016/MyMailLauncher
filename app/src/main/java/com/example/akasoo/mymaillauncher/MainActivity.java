package com.example.akasoo.mymaillauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String address="";
    String title="";
    String memo="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RadioGroup radio = (RadioGroup)findViewById(R.id.radioGroup);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group,int checkedID){
                RadioButton radioButton = (RadioButton)findViewById(checkedID);
                String value = radioButton.getText().toString();
                address = value;
            }
        });





    }


    public void sousin(View view){
        TextView text = (TextView)findViewById(R.id.title);
        title=text.getText().toString();
        text = (TextView)findViewById(R.id.bun);
        memo=text.getText().toString();
        Uri uri = Uri.parse("mailto:" + address);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra(Intent.EXTRA_SUBJECT, title);
        intent.putExtra(Intent.EXTRA_TEXT, memo );
        startActivity(intent);
    }
}
