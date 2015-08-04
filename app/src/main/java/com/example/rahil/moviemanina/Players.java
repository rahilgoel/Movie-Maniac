package com.example.rahil.moviemanina;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

/**
 * Created by rahil on 6/16/2015.
 */
public class Players extends Activity implements View.OnClickListener {
    RelativeLayout rev_lay;
    ImageButton single,multi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.players);
        rev_lay=(RelativeLayout) findViewById(R.id.rev);
        single =(ImageButton) findViewById(R.id.single);
        multi =(ImageButton) findViewById(R.id.multi);
        single.setOnClickListener(this);
        multi.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.single:
                Intent j=new Intent(Players.this,GameActivitySingle.class);
                startActivity(j);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                Intent myIntent = new Intent(Players.this, MyService.class);
                stopService(myIntent);

                break;
            case R.id.multi:
                Intent i=new Intent(Players.this, Word.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                Intent myIntent2 = new Intent(Players.this, MyService.class);
                stopService(myIntent2);
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent myIntent = new Intent(Players.this, MyService.class);
            stopService(myIntent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
