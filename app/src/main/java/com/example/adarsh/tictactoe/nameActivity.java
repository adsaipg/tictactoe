package com.example.adarsh.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class nameActivity extends AppCompatActivity {
    Button passButton,backbut;
    EditText playerName1,playerName2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        playerName1 = (EditText) findViewById(R.id.playerid1);
        playerName2 = (EditText) findViewById(R.id.playerid2);
        backbut=(Button)findViewById(R.id.backButton);
        backbut.setOnClickListener(new View.OnClickListener() {
                                        @Override

                                        public void onClick(View v) {
                                            finish();
                                        }
                                    }
        );


        buttonClick();
    }
    public  void buttonClick(){
        passButton = (Button) findViewById(R.id.proceedButton);
        passButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {



                if(playerName1.getText().toString().equalsIgnoreCase(null) && playerName2.getText().toString()==null){
                    Toast toas_t = Toast.makeText(getApplicationContext(), "Enter both player's name", Toast.LENGTH_SHORT);
                    toas_t.setGravity(Gravity.CENTER, 0, 0);
                    toas_t.show();
                }
                else{

                    Intent i = new Intent("com.example.adarsh.tictactoe.tictactoeActivity");
                    i.putExtra("location1", playerName1.getText().toString());
                    i.putExtra("location2", playerName2.getText().toString());
                    startActivity(i);
                    playerName1.setText("");
                    playerName2.setText("");
                }

            }
        });
    }
}
