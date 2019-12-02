package ru.pogorelov.alexey.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.pogorelov.alexey.R;

public class AddNumberDriverActivity extends AppCompatActivity {

    EditText editInputDl;
    SharedPreferences preferences;
    private final String SAVED_NUMBER_DL = "SAVED_NUMBER_DL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_number_driver);

        preferences = getSharedPreferences("NumberDL", MODE_PRIVATE);

        editInputDl = findViewById(R.id.editInputDl);
        editInputDl.requestFocus();
        editInputDl.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!validate(editInputDl.getText().toString())){
                    editInputDl.setError("Номер ВУ введен некорректно");

                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_dl,menu);
        return true;
    }

    public void onMenuClick(MenuItem item){
        if (item.getItemId() == R.id.SaveDl){
            String numberDl = editInputDl.getText().toString();
            Intent intent = new Intent(this,InfoActivity.class);
            if (!numberDl.isEmpty()) {
                SharedPreferences.Editor ed = preferences.edit();
                ed.putString(SAVED_NUMBER_DL, editInputDl.getText().toString());
                ed.commit();
                startActivity(intent);
            }
            else editInputDl.setError("Поле не может быть пустым");

        }
    }

    public static boolean validate(String st) {
        Pattern p = Pattern.compile("^\\d{2}\\d{2}\\d{6}$");
        Matcher m = p.matcher(st);
        return m.find();
    }

}
