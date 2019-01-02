package app.itdivision.lightbulb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Spinner;

import com.github.paolorotolo.appintro.AppIntroFragment;

public class Splash extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //temp
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1.5s = 1500ms
                SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
                boolean firstStart = prefs.getBoolean("firstStart", true);

                if(firstStart){
                    Intent intent = new Intent(Splash.this, AppIntroActivity.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Splash.this, Login.class);
                    startActivity(intent);
                }
            }
        }, 1500);

    }


    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}