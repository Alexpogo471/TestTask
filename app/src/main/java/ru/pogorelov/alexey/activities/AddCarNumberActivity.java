package ru.pogorelov.alexey.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import ru.pogorelov.alexey.R;

public class AddCarNumberActivity extends AppCompatActivity {

    EditText editInputTs;
    SharedPreferences preferences;
    private final String SAVED_NUMBER_TS = "SAVED_NUMBER_TS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_number);

        preferences = getSharedPreferences("NumberTs", MODE_PRIVATE);

        editInputTs = findViewById(R.id.editInputTs);
        editInputTs.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() <= 0) {
                    editInputTs.setError("Поле не может быть пустым");
                } else {
                    editInputTs.setError(null);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_ts,menu);
        return true;
    }

    public void onMenuClick(MenuItem item){
        if (item.getItemId() == R.id.SaveTs){
            String numberTs = editInputTs.getText().toString();
            Intent intent = new Intent(this,InfoActivity.class);
            if (!numberTs.isEmpty()) {
                SharedPreferences.Editor ed = preferences.edit();
                ed.putString(SAVED_NUMBER_TS, editInputTs.getText().toString());
                ed.commit();
                startActivity(intent);
            }
            else editInputTs.setError("Поле не может быть пустым");

        }
    }
}
