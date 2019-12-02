package ru.pogorelov.alexey.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.pogorelov.alexey.R;

public class InfoActivity extends AppCompatActivity {

    TextView textViewNumberRegistration, textViewNumberDL;
    Button buttonAddCar,buttonAddDriver;
    SharedPreferences preferencesTS;
    SharedPreferences preferencesDL;
    private final String SAVED_NUMBER_TS = "SAVED_NUMBER_TS";
    private final String SAVED_NUMBER_DL = "SAVED_NUMBER_DL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        buttonAddCar = findViewById(R.id.buttonAddCar);
        buttonAddDriver = findViewById(R.id.buttonAddDriver);

        textViewNumberRegistration = findViewById(R.id.textViewNumberRegistration);
        preferencesTS = getSharedPreferences("NumberTs", MODE_PRIVATE);
        String savedTs = preferencesTS.getString(SAVED_NUMBER_TS, "");
        if (savedTs != null) {
            textViewNumberRegistration.setText(savedTs);
            textViewNumberRegistration.setVisibility(View.VISIBLE);
            buttonAddCar.setVisibility(View.GONE);
        }

        textViewNumberDL = findViewById(R.id.textViewNumberDL);
        preferencesDL = getSharedPreferences("NumberDL", MODE_PRIVATE);
        String savedDL = preferencesDL.getString(SAVED_NUMBER_DL, "");
        if (savedDL != null) {
            textViewNumberDL.setText(savedDL);
            textViewNumberDL.setVisibility(View.VISIBLE);
            buttonAddDriver.setVisibility(View.GONE);
        }


    }
}
