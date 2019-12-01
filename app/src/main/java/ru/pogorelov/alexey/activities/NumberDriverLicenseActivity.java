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

public class NumberDriverLicenseActivity extends AppCompatActivity {

    private Button skipBtnDs;
    Context context;
    AlertDialog.Builder dialog;
    EditText numberDsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_driver_license);

        numberDsEditText = findViewById(R.id.numberDsEditText);
        numberDsEditText.requestFocus();

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
    }
}
