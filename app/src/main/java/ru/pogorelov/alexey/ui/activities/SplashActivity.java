package ru.pogorelov.alexey.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences preferencesTS;
    SharedPreferences preferencesDL;
    private final String SAVED_NUMBER_TS = "SAVED_NUMBER_TS";
    private final String SAVED_NUMBER_DL = "SAVED_NUMBER_DL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferencesTS = getSharedPreferences("NumberTs", MODE_PRIVATE);
        String savedTs = preferencesTS.getString(SAVED_NUMBER_TS, "");
        if (!savedTs.isEmpty()) {
            Intent intent1 = new Intent(this,InfoActivity.class);
            startActivity(intent1);
        } else {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

        preferencesDL = getSharedPreferences("NumberDL", MODE_PRIVATE);
        String savedDL = preferencesDL.getString(SAVED_NUMBER_DL, "");
        if (!savedDL.isEmpty()) {
            Intent intent1 = new Intent(this,InfoActivity.class);
            startActivity(intent1);
        } else {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

        finish();
    }
}
