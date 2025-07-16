package com.example.projetandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.projetandroid.databinding.ActivityResultatBinding;

public class Resultat extends AppCompatActivity {

    private ActivityResultatBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int score = getIntent().getIntExtra("score", 0);
        int total = getIntent().getIntExtra("total", 5);

        binding.txtResult.setText("Ton score : " + score + " / " + total);

        SharedPreferences preferences = getSharedPreferences("ProjetAndroid", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt("lastScore", score);

        int bestScore = preferences.getInt("bestScore", -1);
        if (score > bestScore) {
            editor.putInt("bestScore", score);
        }

        editor.apply();

        String message;
        switch (score) {
            case 0:
                message = "🪓 Tu n’es point le forgeron le plus affûté du village... retourne casser des cailloux !";
                break;
            case 1:
                message = "🧹 Une flamme vacille en toi, écuyer... mais tu n’es pas encore chevalier.";
                break;
            case 2:
                message = "🏹 Tu vises parfois juste, apprenti du royaume.";
                break;
            case 3:
                message = "🛡 Tu aurais survécu à la taverne... mais pas à une bataille !";
                break;
            case 4:
                message = "🧙 Merlin serait presque fier… sauf pour la question oubliée, gueux !";
                break;
            case 5:
                message = "👑 Par le Saint Graal ! Tu es digne du trône, chevalier érudit !";
                break;
            default:
                message = "Erreur dans la magie des scores...";
        }

        binding.txtMessage.setText(message);

        binding.btnRetourAccueil.setOnClickListener(view -> finish());

        binding.btnRelancerQuizz.setOnClickListener(view -> {
            getSharedPreferences("ProjetAndroid", MODE_PRIVATE)
                    .edit()
                    .remove("lastScore")
                    .apply();
            Intent intent = new Intent(this, Quizz.class);
            startActivity(intent);
            finish();
        });
    }
}
