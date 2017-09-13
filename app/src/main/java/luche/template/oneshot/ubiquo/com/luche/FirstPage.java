package luche.template.oneshot.ubiquo.com.luche;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.kogitune.activity_transition.ActivityTransition;
import com.transitionseverywhere.AutoTransition;
import com.transitionseverywhere.Transition;

public class FirstPage extends AppCompatActivity {

    protected ViewGroup viewGroup;
    protected View lineOne,lineTwo;
    protected Button button;
    protected ImageView logo,bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.requestFeature( Window.FEATURE_ACTIVITY_TRANSITIONS);
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        setContentView(R.layout.activity_first_page);
        ActivityTransition.with(getIntent()).to(findViewById(R.id.img)).start(savedInstanceState);

        viewGroup = (ViewGroup)findViewById(R.id.firstPageViewGroup);
        lineOne = viewGroup.findViewById(R.id.first_separator);
        lineTwo = viewGroup.findViewById(R.id.second_separator);
        button = viewGroup.findViewById(R.id.phoneButton);
        logo = viewGroup.findViewById(R.id.img);
        bg = viewGroup.findViewById(R.id.bg);




    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if(hasFocus){

            //parte dopo 600ms e dura 800ms = 1400ms
            linesAndBackGroundAnimation();
            //parte dopo 1400ms e dura 2000ms = 3400ms
            logoAnimation();
        }


    }

    protected void linesAndBackGroundAnimation(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Transition fadeIn = new AutoTransition();
                //quanto deve durare la transizione
                fadeIn.setDuration(800);
                //interpolatore
                fadeIn.setInterpolator(new FastOutSlowInInterpolator());

                //animazione
                com.transitionseverywhere.TransitionManager.beginDelayedTransition(viewGroup, fadeIn);
                bg.setVisibility(View.VISIBLE);

                //allarga le due linee
                lineOne.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
                lineTwo.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;


            }
        },600);
    }

    protected void logoAnimation(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                ValueAnimator anim = new ValueAnimator();
                anim.setIntValues(ContextCompat.getColor(FirstPage.this,R.color.pureBlack), ContextCompat.getColor(FirstPage.this,R.color.pureWhite));
                anim.setEvaluator(new ArgbEvaluator());
                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        //logo.setBackgroundColor((Integer)valueAnimator.getAnimatedValue());
                        logo.setColorFilter((Integer)valueAnimator.getAnimatedValue());
                    }
                });

                anim.setDuration(2000);
                anim.start();

                //logo.setColorFilter(ContextCompat.getColor(FirstPage.this,R.color.pureWhite),PorterDuff.Mode.MULTIPLY);
            }
        },1400);
    }



}
