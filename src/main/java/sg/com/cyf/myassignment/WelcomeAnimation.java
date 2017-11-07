package sg.com.cyf.myassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeAnimation extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_animation);

        imageView=(ImageView) findViewById(R.id.imageView);
        textView=(TextView)findViewById(R.id.textView);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.welcome_animation);
        imageView.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
              finish();
                startActivity(new Intent(getApplicationContext(),ConverterActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });
    }
}
