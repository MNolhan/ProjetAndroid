package com.example.projetandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.projetandroid.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences preferences = getSharedPreferences("ProjetAndroid", MODE_PRIVATE);
        String savedName = preferences.getString("username", "");
        binding.textInputEditText.setText(savedName);

        int bestScore = preferences.getInt("bestScore", -1);
        if (bestScore != -1) {
            binding.txtBestScore.setText("🏅 Meilleur score : " + bestScore + " / 5");
        } else {
            binding.txtBestScore.setText("Vous n'avez pas de Meilleur Score");
        }

        binding.btnQuizz.setOnClickListener(view -> {
            String nom = binding.textInputEditText.getText().toString().trim();
            if (nom.isEmpty()) {
                Log.d(TAG, "Input Vide");
                Snackbar.make(view, "Veuillez entrer votre nom", Snackbar.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity.this, Quizz.class);

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username", nom);
                editor.apply();

                intent.putExtra("username", nom);
                Log.i(TAG, "Start Activity --> Quizz");
                startActivity(intent);
            }
        });

        binding.btnClear.setOnClickListener(view -> {
            SharedPreferences.Editor editor = preferences.edit();
            Log.i(TAG, "Suppression du username des SharedPreferences");
            editor.remove("username");
            editor.remove("bestScore");
            editor.apply();
            Snackbar.make(view, "Suppression de vos préférences réussie", Snackbar.LENGTH_SHORT).show();
            binding.textInputEditText.setText("");
            binding.txtBestScore.setText("");
        });

        binding.btnNight.setOnClickListener(view -> {
            int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
            if (currentNightMode == Configuration.UI_MODE_NIGHT_YES) {
                Log.i(TAG, "Passage en mode clair");
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                Log.i(TAG, "Passage en mode sombre");
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("ProjetAndroid", MODE_PRIVATE);
        int bestScore = preferences.getInt("bestScore", -1);
        if (bestScore != -1) {
            binding.txtBestScore.setText("🏅 Meilleur score : " + bestScore + " / 5");
        } else {
            binding.txtBestScore.setText("Vous n'avez pas de Meilleur Score");
        }
    }
}
