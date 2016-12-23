package am.tsd.inchuner.program26.activities;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import am.tsd.inchuner.program26.R;

/**
 * Created by araratm on 7/29/16.
 */
public class BaseActivity extends Activity {

    private TextView poweredByTSDtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void initViews(){
        poweredByTSDtxt = (TextView) findViewById(R.id.powered_by_tsd_txt);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/segoeuisl.ttf");
        poweredByTSDtxt.setTypeface(type);
    }


}
