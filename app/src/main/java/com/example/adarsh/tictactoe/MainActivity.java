package com.example.adarsh.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    static Button button;
    private Button butnexit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonClick();
        butnexit=(Button)findViewById(R.id.exitbut);
        butnexit.setOnClickListener(new View.OnClickListener() {
                                     @Override

                                     public void onClick(View v) {
                                         finish();
                                     }
                                 }
        );
    }
    public  void buttonClick(){
        button = (Button) findViewById(R.id.playbut);
        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {


                Intent showtictactoeIntent = new Intent("com.example.adarsh.tictactoe.nameActivity");

                startActivity(showtictactoeIntent);

            }
        });
    }
}