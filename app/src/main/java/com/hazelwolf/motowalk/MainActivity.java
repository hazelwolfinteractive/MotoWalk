package com.hazelwolf.motowalk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hazelwolf.motowalk.data.Profile;
import com.hazelwolf.motowalk.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private String name = "";
    private Profile profile = new Profile();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.button.setOnClickListener(this::displayName);
        profile.setDeviceId("Device Id: " + android_id);
        binding.setProfile(profile);
    }

    private void displayName(View v){
        name = binding.inputView.getText().toString();
        if(!name.isEmpty()) {
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
            binding.inputView.setText("");
        }
        else {
            Toast.makeText(this, "Name is empty, please enter a name", Toast.LENGTH_SHORT).show();
        }

        // Hide Keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        assert inputMethodManager != null;
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);

        binding.invalidateAll();
    }
}