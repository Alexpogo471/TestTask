package ru.pogorelov.alexey.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.pogorelov.alexey.R;

public class RegistrationNumberActivity extends AppCompatActivity {

    private Button skipBtn, nextBtn;
    Context context;
    AlertDialog.Builder dialog;
    EditText numberTsEditText;
    SharedPreferences preferences;
    private final String SAVED_NUMBER_TS = "SAVED_NUMBER_TS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_number);

        numberTsEditText = findViewById(R.id.numberTsEditText);
        preferences = getSharedPreferences("NumberTs", MODE_PRIVATE);
        numberTsEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() <= 0) {
                    numberTsEditText.setError("Поле не может быть пустым");
                    nextBtn.setOnClickListener(null);
                } else {
                    numberTsEditText.setError(null);
                }

            }
        });


        nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberTs = numberTsEditText.getText().toString();
                if (!numberTs.isEmpty()) {
                    SharedPreferences.Editor ed = preferences.edit();
                    ed.putString(SAVED_NUMBER_TS, numberTsEditText.getText().toString());
                    ed.commit();
                    Intent intent = new Intent(RegistrationNumberActivity.this, NumberDriverLicenseActivity.class);
                    startActivity(intent);
                }
                else numberTsEditText.setError("Поле не может быть пустым");
            }
        });


        skipBtn = findViewById(R.id.skipBtn);

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = RegistrationNumberActivity.this;
                String message = "Если вы не введете регистрационный номер ТС, то вы не сможете следить за штрафами, выписанными на автомобиль";
                String button1 = "Ввести номер";
                String button2 = "Пропустить";

                dialog = new AlertDialog.Builder(context);
                dialog.setMessage(message);
                dialog.setPositiveButton(button1, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        dialog.cancel();
                    }
                });
                dialog.setNegativeButton(button2, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        Intent intent = new Intent(RegistrationNumberActivity.this, NumberDriverLicenseActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }

        });
    }

//    public static boolean reg(String st) {
//        Pattern p = Pattern.compile("/^[АВЕКМНОРСТУХ]\\\\d{3}(?<!000)[АВЕКМНОРСТУХ]{2}\\\\d{2,3}$/ui");
//        Matcher m = p.matcher(st);
//        return m.matches();
//    }
}
