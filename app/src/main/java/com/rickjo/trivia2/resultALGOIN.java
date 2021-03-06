package com.rickjo.trivia2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class resultALGOIN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_algoin);

        TextView result = (TextView) findViewById(R.id.result);
        TextView hiscore = (TextView) findViewById(R.id.hiscore);

        int score = getIntent().getIntExtra("algoinScore", 0);
        result.setText(score + "");

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highScore = settings.getInt("ALGOIN_SCORE", 0);

        if (score > highScore){
            hiscore.setText("High Score : " + score);

            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("ALGOIN_SCORE", score);
            editor.commit();
        }else {
            hiscore.setText("Skor Tertinggi : " + highScore);
        }
    }

    public void returnMenu(View view){
        startActivity(new Intent(getApplicationContext(), start.class));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), start.class));
    }
}
