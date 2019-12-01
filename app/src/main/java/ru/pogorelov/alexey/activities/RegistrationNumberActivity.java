package ru.pogorelov.alexey.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ru.pogorelov.alexey.R;

public class RegistrationNumberActivity extends AppCompatActivity {

    private Button skipBtn;
    Context context;
    AlertDialog.Builder dialog;
    EditText numberTsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_number);

        numberTsEditText = findViewById(R.id.numberTsEditText);
        numberTsEditText.requestFocus();

//        final String regex = "/^[АВЕКМНОРСТУХ]\\d{3}(?<!000)[АВЕКМНОРСТУХ]{2}\\d{2,3}$/ui";
//        InputFilter filter = new InputFilter() {
//            @Override
//            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
//                return source.toString().matches(regex) ? null : numberTsEditText.getText();
//            }
//        };
//        numberTsEditText.setFilters(new InputFilter[]{filter});



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
                        Intent intent = new Intent(RegistrationNumberActivity.this,NumberDriverLicenseActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }

        });


    }

}