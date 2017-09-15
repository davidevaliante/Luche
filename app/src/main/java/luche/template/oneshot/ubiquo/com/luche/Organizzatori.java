package luche.template.oneshot.ubiquo.com.luche;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.transitionseverywhere.Fade;
import com.transitionseverywhere.Slide;
import com.transitionseverywhere.TransitionManager;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Organizzatori extends AppCompatActivity {

    ImageView first,second,third, fbOne,fbTwo,fbThree,phoneOne,phoneTwo,phoneThree,nv_1,nv_2,nv_3;
    View shaderOne,shaderTwo,shaderThree;
    ViewGroup viewGroup;

    private PackageManager mPackageManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizzatori);

        mPackageManager = getPackageManager();

        viewGroup = findViewById(R.id.org_group);

        first = viewGroup.findViewById(R.id.firstPic);
        second = viewGroup.findViewById(R.id.secondPic);
        third = viewGroup.findViewById(R.id.thirdPic);

        shaderOne = viewGroup.findViewById(R.id.shader_one);
        shaderTwo = viewGroup.findViewById(R.id.shader_two);
        shaderThree = viewGroup.findViewById(R.id.shader_three);

        fbOne = viewGroup.findViewById(R.id.fb_1);
        fbTwo = viewGroup.findViewById(R.id.fb_2);
        fbThree = viewGroup.findViewById(R.id.fb_3);

        phoneOne = viewGroup.findViewById(R.id.phone_1);
        phoneTwo = viewGroup.findViewById(R.id.phone_2);
        phoneThree = viewGroup.findViewById(R.id.phone_3);

        nv_1 = viewGroup.findViewById(R.id.nv_1);
        nv_2 = viewGroup.findViewById(R.id.nv_2);
        nv_3 = viewGroup.findViewById(R.id.nv_3);

        first.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.potty_horizontal));
        second.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.monty_horizontal));
        third.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.angelo_horizontal));

        nv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fb = TransitionsUtils.newFacebookIntent(mPackageManager, "https://www.facebook.com/nightvisionproevents/");
                if(TransitionsUtils.isPackageExisted(Organizzatori.this,"com.facebook.katana")){
                    startActivity(fb);
                }else{
                    Toast.makeText(Organizzatori.this, "Facebook non è disponibile sul tuo smartphone", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fb = TransitionsUtils.newFacebookIntent(mPackageManager, "https://www.facebook.com/nightvisionproevents/");
                if(TransitionsUtils.isPackageExisted(Organizzatori.this,"com.facebook.katana")){
                    startActivity(fb);
                }else{
                    Toast.makeText(Organizzatori.this, "Facebook non è disponibile sul tuo smartphone", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fb = TransitionsUtils.newFacebookIntent(mPackageManager, "https://www.facebook.com/nightvisionproevents/");
                if(TransitionsUtils.isPackageExisted(Organizzatori.this,"com.facebook.katana")){
                    startActivity(fb);
                }else{
                    Toast.makeText(Organizzatori.this, "Facebook non è disponibile sul tuo smartphone", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fbOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fb = TransitionsUtils.newFacebookIntent(mPackageManager, "https://www.facebook.com/Uovino");
                if(TransitionsUtils.isPackageExisted(Organizzatori.this,"com.facebook.katana")){
                    startActivity(fb);
                }else{
                    Toast.makeText(Organizzatori.this, "Facebook non è disponibile sul tuo smartphone", Toast.LENGTH_SHORT).show();
                }
            }
        });

        phoneOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+393473544017"));
                startActivity(call);
            }
        });

        fbTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fb = TransitionsUtils.newFacebookIntent(mPackageManager, "https://www.facebook.com/michele.e.montanaro");
                if(TransitionsUtils.isPackageExisted(Organizzatori.this,"com.facebook.katana")){
                    startActivity(fb);
                }else{
                    Toast.makeText(Organizzatori.this, "Facebook non è disponibile sul tuo smartphone", Toast.LENGTH_SHORT).show();
                }
            }
        });

        phoneTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+393349859287"));
                startActivity(call);
            }
        });

        fbThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fb = TransitionsUtils.newFacebookIntent(mPackageManager, "https://www.facebook.com/angelo.laurelli");
                if(TransitionsUtils.isPackageExisted(Organizzatori.this,"com.facebook.katana")){
                    startActivity(fb);
                }else{
                    Toast.makeText(Organizzatori.this, "Facebook non è disponibile sul tuo smartphone", Toast.LENGTH_SHORT).show();
                }
            }
        });

        phoneThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+393494243758"));
                startActivity(call);
            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if(hasFocus){

            shadersFadeIn();
            facebookIconFadeIn();
            phoneIconFadeIn();
        }
    }

    //libreria calligrafia
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    protected void phoneIconFadeIn(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Fade fadeIn = new Fade();
                fadeIn.setDuration(600);
                fadeIn.setStartDelay(300);



                TransitionManager.beginDelayedTransition(viewGroup,fadeIn);
                phoneOne.setVisibility(View.VISIBLE);
                nv_1.setVisibility(View.VISIBLE);

            }
        },400);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Fade fadeIn = new Fade();
                fadeIn.setDuration(600);
                fadeIn.setStartDelay(300);


                TransitionManager.beginDelayedTransition(viewGroup,fadeIn);
                phoneTwo.setVisibility(View.VISIBLE);
                nv_2.setVisibility(View.VISIBLE);

            }
        },700);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Fade fadeIn = new Fade();
                fadeIn.setDuration(600);
                fadeIn.setStartDelay(300);


                TransitionManager.beginDelayedTransition(viewGroup,fadeIn);
                phoneThree.setVisibility(View.VISIBLE);
                nv_3.setVisibility(View.VISIBLE);

            }
        },1000);
    }

    protected void facebookIconFadeIn(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Fade fadeIn = new Fade();
                fadeIn.setDuration(600);
                fadeIn.setStartDelay(300);



                TransitionManager.beginDelayedTransition(viewGroup,fadeIn);
                fbOne.setVisibility(View.VISIBLE);

            }
        },300);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Fade fadeIn = new Fade();
                fadeIn.setDuration(600);
                fadeIn.setStartDelay(300);


                TransitionManager.beginDelayedTransition(viewGroup,fadeIn);
                fbTwo.setVisibility(View.VISIBLE);

            }
        },600);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Fade fadeIn = new Fade();
                fadeIn.setDuration(600);
                fadeIn.setStartDelay(300);


                TransitionManager.beginDelayedTransition(viewGroup,fadeIn);
                fbThree.setVisibility(View.VISIBLE);

            }
        },900);
    }

    protected void shadersFadeIn(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Fade fadeIn = new Fade();
                fadeIn.setDuration(600);
                fadeIn.setStartDelay(300);



                TransitionManager.beginDelayedTransition(viewGroup,fadeIn);
                shaderOne.setVisibility(View.VISIBLE);

            }
        },200);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Fade fadeIn = new Fade();
                fadeIn.setDuration(600);
                fadeIn.setStartDelay(300);


                TransitionManager.beginDelayedTransition(viewGroup,fadeIn);
                shaderTwo.setVisibility(View.VISIBLE);

            }
        },500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Fade fadeIn = new Fade();
                fadeIn.setDuration(600);
                fadeIn.setStartDelay(300);


                TransitionManager.beginDelayedTransition(viewGroup,fadeIn);
                shaderThree.setVisibility(View.VISIBLE);

            }
        },800);
    }
}
