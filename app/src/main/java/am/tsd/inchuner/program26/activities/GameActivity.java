package am.tsd.inchuner.program26.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import am.tsd.inchuner.program26.R;
import am.tsd.inchuner.program26.constant.QuestionConstant;

/**
 * Created by araratm on 7/28/16.
 */
public class GameActivity extends BaseActivity {

    private TextView questionTxt;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;
    private Button nextQuestionBtn;

    private int currentQuestion = -1;
    private int totalCorrect;
    private int totalWrong;

    private String correctText;
    private List<String> answersList = new ArrayList<String>();

    private View.OnClickListener onCLickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initViews();
    }

    @Override
    protected void initViews(){
        super.initViews();
        questionTxt = (TextView) findViewById(R.id.activity_game_question_txt);
        answerBtn1 = (Button) findViewById(R.id.activity_game_answer_btn_1);
        answerBtn2 = (Button) findViewById(R.id.activity_game_answer_btn_2);
        answerBtn3 = (Button) findViewById(R.id.activity_game_answer_btn_3);
        answerBtn4 = (Button) findViewById(R.id.activity_game_answer_btn_4);
        nextQuestionBtn = (Button) findViewById(R.id.activity_game_next_btn);

        onCLickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == answerBtn1 || v == answerBtn2 || v == answerBtn3 || v == answerBtn4){
                    Button b = (Button) v;

                    removeListeners();

                    if(b.getText().equals(correctText)){
                        b.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangle_button_correct));
                        totalCorrect ++;
                    }else{
                        b.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangle_button_wrong));
                        getTrueAnswerButton().setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangle_button_correct));
                        totalWrong ++;
                    }

                }else if(v == nextQuestionBtn){
                    loadQuestion();
                }
            }
        };

        nextQuestionBtn.setOnClickListener(onCLickListener);

        loadQuestion();
    }

    private void addListeners(){
        answerBtn1.setOnClickListener(onCLickListener);
        answerBtn2.setOnClickListener(onCLickListener);
        answerBtn3.setOnClickListener(onCLickListener);
        answerBtn4.setOnClickListener(onCLickListener);

        answerBtn1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangle_button));
        answerBtn2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangle_button));
        answerBtn3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangle_button));
        answerBtn4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangle_button));

        nextQuestionBtn.setVisibility(View.INVISIBLE);
    }

    private void removeListeners(){
        answerBtn1.setOnClickListener(null);
        answerBtn2.setOnClickListener(null);
        answerBtn3.setOnClickListener(null);
        answerBtn4.setOnClickListener(null);

        nextQuestionBtn.setVisibility(View.VISIBLE);
    }

    private void loadQuestion(){
        currentQuestion++;

        if(currentQuestion >= QuestionConstant.questions.size()){
            showGameOver();
            return;
        }

        answersList = new ArrayList<>();
        correctText = QuestionConstant.questions.get(currentQuestion).getAnswerTrue();
        questionTxt.setText(QuestionConstant.questions.get(currentQuestion).getQuestion());

        answersList.add(correctText);
        answersList.add(QuestionConstant.questions.get(currentQuestion).getAnswerWrong1());
        answersList.add(QuestionConstant.questions.get(currentQuestion).getAnswerWrong2());
        answersList.add(QuestionConstant.questions.get(currentQuestion).getAnswerWrong3());

        Collections.shuffle(answersList);

        for(int i = 0; i < answersList.size(); i++){
            switch (i){
                case 0:
                    answerBtn1.setText(answersList.get(i));
                    break;
                case 1:
                    answerBtn2.setText(answersList.get(i));
                    break;
                case 2:
                    answerBtn3.setText(answersList.get(i));
                    break;
                case 3:
                    answerBtn4.setText(answersList.get(i));
                    break;
                default:
                    break;
            }
        }

        addListeners();
    }

    private Button getTrueAnswerButton(){
        Button b = answerBtn1;

        if(correctText.equals(answerBtn2.getText())){
            b = answerBtn2;
        }else if(correctText.equals(answerBtn3.getText())){
            b = answerBtn3;
        }else if(correctText.equals(answerBtn4.getText())){
            b = answerBtn4;
        }

        return b;
    }

    private void showGameOver(){
        Intent intent = new Intent(this, GameOverActivity.class);
        intent.putExtra("CorrectAnswers", totalCorrect);
        intent.putExtra("WrongAnswers", totalWrong);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

    }
}
