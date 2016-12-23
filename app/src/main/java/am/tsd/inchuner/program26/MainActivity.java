package am.tsd.inchuner.program26;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import am.tsd.inchuner.program26.activities.BaseActivity;
import am.tsd.inchuner.program26.activities.GameActivity;

public class MainActivity extends BaseActivity {

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    @Override
    protected void initViews(){
        super.initViews();
        startButton = (Button) findViewById(R.id.main_activity_start_btn);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
    }
}
