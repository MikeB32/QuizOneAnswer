package am.tsd.inchuner.program26.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import am.tsd.inchuner.program26.MainActivity;
import am.tsd.inchuner.program26.R;

/**
 * Created by araratm on 7/28/16.
 */
public class GameOverActivity extends BaseActivity {

    private TextView correctTxt;
    private TextView wrongTxt;
    private Button restartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        initViews();
    }

    @Override
    protected void initViews(){
        super.initViews();
        correctTxt = (TextView) findViewById(R.id.game_over_result_correct_txt);
        wrongTxt = (TextView) findViewById(R.id.game_over_result_wrong_txt);
        restartBtn = (Button) findViewById(R.id.game_over_restart_btn);

        int correctAnswers = getIntent().getExtras().getInt("CorrectAnswers");
        int wrongAnswers = getIntent().getExtras().getInt("WrongAnswers");

        correctTxt.setText("Ճիշտ: " + correctAnswers);
        wrongTxt.setText("Սխալ: " + wrongAnswers);
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainScreen();
            }
        });
    }

    @Override
    public void onBackPressed() {
        showMainScreen();
    }

    private void showMainScreen(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
