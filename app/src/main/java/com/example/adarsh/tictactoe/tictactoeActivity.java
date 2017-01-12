package com.example.adarsh.tictactoe;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class tictactoeActivity extends AppCompatActivity{




    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9,reset_but;
    Button[] barray;
    boolean turn=true;
    private int turn_chance=0;
    private Button backbutn;
    String tv1,tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

        Intent in = getIntent();
        tv1= in.getExtras().getString("location1");
        tv2=in.getExtras().getString("location2");



        button1=(Button)findViewById(R.id.b1);
        button2=(Button)findViewById(R.id.b2);
        button3=(Button)findViewById(R.id.b3);
        button4=(Button)findViewById(R.id.b4);
        button5=(Button)findViewById(R.id.b5);
        button6=(Button)findViewById(R.id.b6);
        button7=(Button)findViewById(R.id.b7);
        button8=(Button)findViewById(R.id.b8);
        button9=(Button)findViewById(R.id.b9);
        reset_but=(Button)findViewById(R.id.reset);
        backbutn=(Button)findViewById(R.id.back);

        barray=new Button[]{button1,button2,button3,button4,button5,button6,button7,button8,button9};

        for(Button b:barray){
            b.setOnClickListener(new View.OnClickListener() {
                                         @Override

                                         public void onClick(View v) {
                                             Button b=(Button)v;
                                             buttonClicked(b);

                                         }
                                     }
            );
        }
        reset_but.setOnClickListener(new View.OnClickListener() {
                                                    @Override

                                                    public void onClick(View v) {

                                                        for(Button b_set:barray){
                                                            b_set.setText("");
                                                            b_set.setClickable(true);
                                                            turn=true;
                                                        }


                                                    }
                                                }
        );
        backbutn.setOnClickListener(new View.OnClickListener() {
                                     @Override

                                     public void onClick(View v) {
                                         finish();
                                     }
                                 }
        );

    }
    public void buttonClicked(Button b){

        if(turn){
            b.setTextColor(Color.parseColor("#F5101EE7"));
            b.setText("X");
        }
        else{
            b.setTextColor(Color.parseColor("#FFFF003B"));
            b.setText("O");
        }
        b.setClickable(false);
        turn=!turn;
        check_winner();


    }
    public void check_winner(){
        boolean winner=false;
        if(button1.getText()==button2.getText() && button2.getText()==button3.getText()
                && !button1.isClickable())
            winner=true;
        if(button4.getText()==button5.getText() && button5.getText()==button6.getText()
                && !button4.isClickable())
            winner=true;
        if(button7.getText()==button8.getText() && button8.getText()==button9.getText()
                && !button7.isClickable())
            winner=true;


        if(button1.getText()==button4.getText() && button4.getText()==button7.getText()
                && !button1.isClickable())
            winner=true;
        if(button2.getText()==button5.getText() && button5.getText()==button8.getText()
                && !button2.isClickable())
            winner=true;
        if(button3.getText()==button6.getText() && button6.getText()==button9.getText()
                && !button3.isClickable())
            winner=true;


        if(button1.getText()==button5.getText() && button5.getText()==button9.getText()
                && !button1.isClickable())
            winner=true;
        if(button3.getText()==button5.getText() && button5.getText()==button7.getText()
                && !button3.isClickable())
            winner=true;
         if(winner){

            if(turn) {
                toast(tv2+" wins");
                for (Button bcheck:barray){
                    bcheck.setClickable(false);
                }

            }
            else if(!turn) {
                toast(tv1+" wins");
                for (Button bcheck:barray){
                    bcheck.setClickable(false);
                }


            }


        }
        else{
            if(!button1.isClickable() && !button2.isClickable() && !button3.isClickable() &&
            !button4.isClickable() && !button5.isClickable() && !button6.isClickable() &&
                    !button7.isClickable()&& !button8.isClickable()&& !button9.isClickable()
                    && !winner)
            toast("tap RESET");
        }

    }
    public void toast(String message){
        Toast toas_t=Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT);
        toas_t.setGravity(Gravity.CENTER,0,0);
        toas_t.show();
    }



}
