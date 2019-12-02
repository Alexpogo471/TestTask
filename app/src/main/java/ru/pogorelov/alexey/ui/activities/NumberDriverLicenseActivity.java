package ru.pogorelov.alexey.ui.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.pogorelov.alexey.R;

public class NumberDriverLicenseActivity extends AppCompatActivity {

    private Button skipBtnDs, nextBtnDs;
    Context context;
    AlertDialog.Builder dialog;
    EditText numberDsEditText;
    SharedPreferences preferences;
    private final String SAVED_NUMBER_DL = "SAVED_NUMBER_DL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_driver_license);

        numberDsEditText = findViewById(R.id.numberDsEditText);
        numberDsEditText.requestFocus();

        numberDsEditText = findViewById(R.id.numberDsEditText);
        preferences = getSharedPreferences("NumberDL",MODE_PRIVATE);

        numberDsEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!validate(numberDsEditText.getText().toString())){
                    numberDsEditText.setError("Номер ВУ введен некорректно");
                    nextBtnDs.setOnClickListener(null);
                }
                if (validate(numberDsEditText.getText().toString())){
                    buttonNextListener();
                }
            }
        });

        skipBtnDs = findViewById(R.id.skipBtnDs);
        skipBtnDs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = NumberDriverLicenseActivity.this;
                String message = "Если вы не введете регистрационный номер водительского удостоверения, то вы не сможете следить за штрафами, выписанными на водителя";
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
                        Intent intent = new Intent(context, WalkthroughtContainerActivity.class);
                        startActivity(intent);

                    }
                });
                dialog.show();
            }

        });

        nextBtnDs = findViewById(R.id.nextBtnDs);
        buttonNextListener();
    }

    public static boolean validate(String st) {
        Pattern p = Pattern.compile("^\\d{2}\\d{2}\\d{6}$");
        Matcher m = p.matcher(st);
        return m.find();
    }

    public void buttonNextListener(){
        nextBtnDs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberDL = numberDsEditText.getText().toString();
                if (!numberDL.isEmpty()) {
                    SharedPreferences.Editor ed = preferences.edit();
                    ed.putString(SAVED_NUMBER_DL, numberDsEditText.getText().toString());
                    ed.commit();
                    Intent intent = new Intent(NumberDriverLicenseActivity.this, WalkthroughtContainerActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
