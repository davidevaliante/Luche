package luche.template.oneshot.ubiquo.com.luche;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import com.kogitune.activity_transition.ActivityTransition;
import com.kogitune.activity_transition.fragment.FragmentTransitionLauncher;
import com.transitionseverywhere.AutoTransition;
import com.transitionseverywhere.ChangeBounds;
import com.transitionseverywhere.ChangeText;
import com.transitionseverywhere.Fade;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.TransitionSet;
import com.transitionseverywhere.extra.Scale;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FirstPage extends AppCompatActivity {

    protected ViewGroup viewGroup;
    protected View lineOne,lineTwo,fakeView;
    protected Button button;
    protected ImageView logo,bg;
    protected LinearLayout ticketsGroup,ticketsGroupTwo,ticketsGroup3, ticketsGroup4;
    protected TextView tourText;

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
        ticketsGroup = viewGroup.findViewById(R.id.ticketsButtonGroup);
        tourText = viewGroup.findViewById(R.id.tourText);
        ticketsGroupTwo = viewGroup.findViewById(R.id.ticketsButtonGroupTwo);
        ticketsGroup3 = viewGroup.findViewById(R.id.ticketsButtonGroup3);
        ticketsGroup4 = viewGroup.findViewById(R.id.ticketsButtonGroup4);
        fakeView = viewGroup.findViewById(R.id.fakeView);

        if(savedInstanceState==null){
            //parte dopo 600ms e dura 800ms = 1400ms
            linesAndBackGroundAnimation();
            //parte dopo 1400ms e dura 2000ms = 3400ms
            logoAnimation();
            buttonsAnimation();
            tourTextAnimator();
        }

        ticketsGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CitySelector selector = CitySelector.newInstance();

                selector.show(getSupportFragmentManager(),"city_selector");
            }
        });

        ticketsGroup4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toOrganizzatori = new Intent(FirstPage.this,Organizzatori.class);
                startActivity(toOrganizzatori);
            }
        });


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if(hasFocus){

        }
    }

    protected void buttonsAnimation(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Transition fadeIn = new AutoTransition();
                //quanto deve durare la transizione
                fadeIn.setDuration(1000);
                //interpolatore
                fadeIn.setInterpolator(new FastOutSlowInInterpolator());
                com.transitionseverywhere.TransitionManager.beginDelayedTransition(ticketsGroup, fadeIn);
                ticketsGroup.setVisibility(View.VISIBLE);
                ticketsGroupTwo.setVisibility(View.VISIBLE);
                ticketsGroup3.setVisibility(View.VISIBLE);
                ticketsGroup4.setVisibility(View.VISIBLE);


                ValueAnimator anim = new ValueAnimator();
                anim.setIntValues(ContextCompat.getColor(FirstPage.this,R.color.pureWhite), ContextCompat.getColor(FirstPage.this,R.color.yellow));
                anim.setEvaluator(new ArgbEvaluator());
                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        //logo.setBackgroundColor((Integer)valueAnimator.getAnimatedValue());

                        GradientDrawable drawable = (GradientDrawable)ticketsGroup.getBackground().mutate();
                        drawable.setStroke(5, (Integer)valueAnimator.getAnimatedValue()); // set stroke width and stroke color
                        // ticketsGroup.setBackgroundColor((Integer)valueAnimator.getAnimatedValue());
                    }
                });
                anim.setStartDelay(1200);
                anim.setDuration(1500);
                anim.start();

                ValueAnimator anim2 = new ValueAnimator();
                anim2.setIntValues(ContextCompat.getColor(FirstPage.this,R.color.pureWhite), ContextCompat.getColor(FirstPage.this,R.color.orange));
                anim2.setEvaluator(new ArgbEvaluator());
                anim2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        //logo.setBackgroundColor((Integer)valueAnimator.getAnimatedValue());

                        GradientDrawable drawable = (GradientDrawable)ticketsGroupTwo.getBackground().mutate();
                        drawable.setStroke(5, (Integer)valueAnimator.getAnimatedValue()); // set stroke width and stroke color
                        // ticketsGroup.setBackgroundColor((Integer)valueAnimator.getAnimatedValue());
                    }
                });
                anim2.setStartDelay(1600);
                anim2.setDuration(1500);
                anim2.start();

                ValueAnimator anim3 = new ValueAnimator();
                anim3.setIntValues(ContextCompat.getColor(FirstPage.this,R.color.pureWhite), ContextCompat.getColor(FirstPage.this,R.color.redish));
                anim3.setEvaluator(new ArgbEvaluator());
                anim3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        //logo.setBackgroundColor((Integer)valueAnimator.getAnimatedValue());

                        GradientDrawable drawable = (GradientDrawable)ticketsGroup3.getBackground().mutate();
                        drawable.setStroke(5, (Integer)valueAnimator.getAnimatedValue()); // set stroke width and stroke color
                        // ticketsGroup.setBackgroundColor((Integer)valueAnimator.getAnimatedValue());
                    }
                });
                anim3.setStartDelay(2000);
                anim3.setDuration(1500);
                anim3.start();

                ValueAnimator anim4 = new ValueAnimator();
                anim4.setIntValues(ContextCompat.getColor(FirstPage.this,R.color.pureWhite), ContextCompat.getColor(FirstPage.this,R.color.redh));
                anim4.setEvaluator(new ArgbEvaluator());
                anim4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        //logo.setBackgroundColor((Integer)valueAnimator.getAnimatedValue());

                        GradientDrawable drawable = (GradientDrawable)ticketsGroup4.getBackground().mutate();
                        drawable.setStroke(5, (Integer)valueAnimator.getAnimatedValue()); // set stroke width and stroke color
                        // ticketsGroup.setBackgroundColor((Integer)valueAnimator.getAnimatedValue());
                    }
                });
                anim4.setStartDelay(2400);
                anim4.setDuration(1500);
                anim4.start();

               collapseLines();


            }
        },2800);
    }

    protected void collapseLines(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Transition fadeIn = new ChangeBounds();
                //quanto deve durare la transizione
                //interpolatore

                fadeIn.addTarget(lineOne).addTarget(lineTwo);
                fadeIn.setInterpolator(new AccelerateDecelerateInterpolator());

                Transition changeText  = new ChangeText().setChangeBehavior(ChangeText.CHANGE_BEHAVIOR_OUT_IN);

                changeText.addTarget(tourText).setStartDelay(200).setDuration(600);
                com.transitionseverywhere.TransitionManager
                        .beginDelayedTransition(viewGroup,
                                new TransitionSet().addTransition(fadeIn).addTransition(changeText));
                fakeView.setVisibility(View.VISIBLE);
                tourText.setText("hotel europa, 21.10.2017");

                lineOne.getLayoutParams().width = 0;
                lineTwo.getLayoutParams().width = 0;
            }
        },800);
    }

    protected void tourTextAnimator(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                com.transitionseverywhere.TransitionManager.beginDelayedTransition(viewGroup);

                tourText.setVisibility(View.VISIBLE);



            }
        },4000);
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
                tourText.setVisibility(View.VISIBLE);

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

    //libreria calligrafia
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    protected  void hideCityselector(){

    }

    @Override
    public void onBackPressed() {

    }
}
