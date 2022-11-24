package com.blackrose.javaapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class SettingsPage extends AppCompatActivity {
    DataManager dataManager;
    Switch topLimitSwitch;
    Switch bottomLimitSwitch;
    TextView topLimit;
    TextView bottomLimit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
        dataManager = DataManager.getInstance();
        topLimitSwitch = findViewById(R.id.topLimitExists);
        topLimitSwitch.setChecked(dataManager.getTopLimitExists());
        topLimitSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> dataManager.setTopLimitExists(isChecked));
        bottomLimitSwitch = findViewById(R.id.bottomLimitExists);
        bottomLimitSwitch.setChecked(dataManager.getBottomLimitExists());
        bottomLimitSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> dataManager.setBottomLimmitExists(isChecked));
        //
        topLimit = findViewById(R.id.topLimit);
        topLimit.setText(Integer.toString(dataManager.getTopLimit()));
        topLimit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int number = Integer.parseInt(topLimit.getText().toString());
                dataManager.setTopLimit(number);

            }
        });
        //
        bottomLimit = findViewById(R.id.bottomLimit);
        bottomLimit.setText(Integer.toString(dataManager.getBottomLimit()));
        bottomLimit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int number = Integer.parseInt(bottomLimit.getText().toString());
                dataManager.setBottomLimit(number);

            }
        });

    }
    public void mainMenu(View view){
        Intent intent = new Intent(SettingsPage.this,MainActivity.class);
        startActivity(intent);
    }
}