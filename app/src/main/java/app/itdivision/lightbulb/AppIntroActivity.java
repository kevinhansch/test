package app.itdivision.lightbulb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class AppIntroActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_app_intro);

        addSlide(AppIntroFragment.newInstance("Welcome!", "Learn from yesterday, Live for today, Hope for tomorrow.", R.mipmap.library_image_1, ContextCompat.getColor(getApplicationContext(),R.color.colorRed)));
        addSlide(AppIntroFragment.newInstance("Together with Lightbulb!", "Increase your knowledge faster, and Study as if you will live forever!", R.mipmap.logo, ContextCompat.getColor(getApplicationContext(),R.color.colorLightBlue)));

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent=new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent intent=new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }
}
