package com.hazelwolf.motowalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String name = "";
    private Button mSubmit;
    private TextView mInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSubmit = findViewById(R.id.button);
        mInput = findViewById(R.id.inputView);
        mSubmit.setOnClickListener(this::displayName);
    }

    private void displayName(View v){
        name = mInput.getText().toString();
        if(!name.isEmpty()) {
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
            mInput.setText("");
        }
        else {
            Toast.makeText(this, "Name is empty, please enter a name", Toast.LENGTH_SHORT).show();
        }

        // Hide Keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);

    }
}