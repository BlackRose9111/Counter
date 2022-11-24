package com.blackrose.javaapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DataManager dataManager;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences("primary",0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        dataManager = new DataManager(sharedPreferences,editor);
        textView = findViewById(R.id.counterDisplay);
        textView.setText("0");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_VOLUME_UP){
            IncrementByFive();
        }
        else if(keyCode == KeyEvent.KEYCODE_VOLUME_DOWN){
            DecrementByFive();
        }




        return super.onKeyDown(keyCode, event);
    }

    private void DecrementByFive() {
        int number = dataManager.getCounter();
        number-=5;
        boolean bottomExists = dataManager.getBottomLimitExists();
        int topLimit = dataManager.getBottomLimit();
        if (bottomExists && number <= topLimit){
            number = topLimit;
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(100);
            ToneGenerator tone = new ToneGenerator(AudioManager.STREAM_MUSIC,100);
            tone.startTone(100);
        }
        dataManager.setCounter(number);
        textView.setText(Integer.toString(number));
    }

    private void IncrementByFive() {
        int number = dataManager.getCounter();
        number+=5;
        boolean topExists = dataManager.getTopLimitExists();
        int topLimit = dataManager.getTopLimit();
        if (topExists && number >= topLimit){
            number = topLimit;
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(100);
            ToneGenerator tone = new ToneGenerator(AudioManager.STREAM_MUSIC,100);
            tone.startTone(100);
        }
        dataManager.setCounter(number);
        textView.setText(Integer.toString(number));

    }

    @SuppressLint("SetTextI18n")
    public void increment(View view){
        int number = dataManager.getCounter();
        number++;
        boolean topExists = dataManager.getTopLimitExists();
        int topLimit = dataManager.getTopLimit();
        if (topExists && number >= topLimit){
            number = topLimit;
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(100);
            ToneGenerator tone = new ToneGenerator(AudioManager.STREAM_MUSIC,100);
            tone.startTone(100);
        }
        dataManager.setCounter(number);
        textView.setText(Integer.toString(number));



    }
    @SuppressLint("SetTextI18n")
    public void decrement(View view){
        int number = dataManager.getCounter();
        number--;
        boolean bottomExists = dataManager.getBottomLimitExists();
        int topLimit = dataManager.getBottomLimit();
        if (bottomExists && number <= topLimit){
            number = topLimit;
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(100);
            ToneGenerator tone = new ToneGenerator(AudioManager.STREAM_MUSIC,100);
            tone.startTone(100);
        }
        dataManager.setCounter(number);
        textView.setText(Integer.toString(number));



    }
    public void settings(View view){

        Intent intent = new Intent(MainActivity.this,SettingsPage.class);
        startActivity(intent);

    }
}