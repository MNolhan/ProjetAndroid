package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import com.example.projetandroid.databinding.ActivityQuizzBinding;
import java.util.List;

public class Quizz extends AppCompatActivity {

    private ActivityQuizzBinding binding;
    private int INDEX = 0;
    private int score = 0;
    private List<Helper.Question> questionList;
    private long elapsedTime = 0;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizzBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        questionList = Helper.getRandomQuestions(5);
        startTimer();
        showQuestion();

        binding.btnNext.setOnClickListener(v -> {
            int checkedId = binding.radioGroup.getCheckedRadioButtonId();
            int selected = binding.radioGroup.indexOfChild(findViewById(checkedId));

            if (selected == questionList.get(INDEX).correctIndex) score++;

            INDEX++;
            if (INDEX < questionList.size()) {
                showQuestion();
            } else {
                timer.cancel();
                Intent intent = new Intent(this, Resultat.class);
                intent.putExtra("score", score);
                intent.putExtra("total", questionList.size());
                startActivity(intent);
                finish();
            }
        });

        binding.Back.setOnClickListener(v -> {
            timer.cancel();
            finish();
        });
    }

    private void showQuestion() {
        Helper.Question q = questionList.get(INDEX);
        binding.txtQuestion.setText(q.question);
        binding.radioGroup.removeAllViews();

        for (String option : q.options) {
            RadioButton rb = new RadioButton(this);
            rb.setText(option);
            binding.radioGroup.addView(rb);
        }
    }

    private void startTimer() {
        timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                elapsedTime++;
                binding.txtTimer.setText("Temps : " + elapsedTime + "s");
            }

            @Override
            public void onFinish() {
                binding.txtTimer.setText("Temps écoulé");
            }
        };
        timer.start();
    }
}
