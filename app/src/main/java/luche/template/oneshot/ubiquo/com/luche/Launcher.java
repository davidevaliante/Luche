package luche.template.oneshot.ubiquo.com.luche;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.transition.*;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.transitionseverywhere.AutoTransition;
import com.transitionseverywhere.Transition;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import com.transitionseverywhere.*;

import static android.R.attr.visible;
import static android.R.attr.width;

public class Launcher extends AppCompatActivity {


    TextView nightVision;
    ViewGroup group;
    View bottom, top;
    ImageView logo, night_logo;
    TypeWriter desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //rende la statusbar completamente invisibile
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.requestFeature( Window.FEATURE_ACTIVITY_TRANSITIONS);
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        setContentView(R.layout.activity_launcher);

        //Elementi UI temporanei
        desc = (TypeWriter) findViewById(R.id.desc);
        nightVision = (TextView) findViewById(R.id.night_vision);
        group = (ViewGroup) findViewById(R.id.launcher_group);
        top = findViewById(R.id.firstLine);
        bottom = findViewById(R.id.secondLine);
        logo = (ImageView) findViewById(R.id.luche);
        night_logo = (ImageView) findViewById(R.id.night_vision_logo);

        //dichiarazione animazione che cambia l'alpha (la trasparenza) di una View
        Animation fadeInV = new AlphaAnimation(0,1);
        //Interpolatore decelerante, l'animazione parte veloce e finisce lentamente
        fadeInV.setInterpolator(new DecelerateInterpolator());
        //quanto deve durare l'animazione
        fadeInV.setDuration(2000);


        //stesso principio dell'animazione di prima ma cambia l'interpolatore che parte lento e
        //finisce veloce
        Animation fadeOut = new AlphaAnimation(0,1);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setStartOffset(1000);
        fadeOut.setDuration(1500);

        //raggruppa le animation per poi applicarle tutte insieme
        AnimationSet set = new AnimationSet(false);
        //aggiunge la prima transizione
        set.addAnimation(fadeInV);
        //aggiunge la seconda transizione
        set.addAnimation(fadeOut);

        //passa il set di transizioni alla View (in questo caso il logo)
        night_logo.startAnimation(set);

    }

    //di solito le animazioni hanno bisogno di un "trigger" per partire (tipo premere un pulsante)
    //questo metodo genera un trigger quando il layout dell'activity è pronto (fare tutta questa roba in
    //OnCreate non funzionerebbe
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        //se hasFocus = true il layout è pronto
        if(hasFocus){

            //postDelayed fa partire un blocco di codice dopo X millisecondi (in questo caso 600)
            new Handler().postDelayed(new Runnable() {
                public void run() {

                    //boolean opzionale ma che può servire dopo
                    boolean visible = false;

                    //dichiara transizione di tipo AutoTransition (il sistema "indovina" in che modo deve
                    //animare le view)
                    Transition fadeIn = new AutoTransition();
                    //quanto deve durare la transizione
                    fadeIn.setDuration(700);
                    //interpolatore
                    fadeIn.setInterpolator(new FastOutSlowInInterpolator());

                    //questo pacchetto "com.transitionseverywhere.TransitionManager" è una backport
                    //per le animazioni (è identica all'API di base
                    //ma abbassa il livello minimo di SDK a 14, solitamente per le animazioni dovrebbe
                    //essere 19)
                    //Gli si deve passare un ViewGroup sul quale effettuare le transizioni (in questo caso
                    //l'intero layout) ma si possono passare anche ViewGroup più piccoli) ed un animazione
                    //IMPORTANTE : qualunque cambiamento fatto dopo questo metodo viene animato automaticamente
                    com.transitionseverywhere.TransitionManager.beginDelayedTransition(group,fadeIn);
                    //opzionale
                    visible = !visible;

                    //Il logo (dichiarato nel file xml come invisibile) viene reso visibile ed animato dal metodo di sopra
                    nightVision.setVisibility(visible ? View.VISIBLE : View.GONE);
                    //Cambia la lunghezza delle due linee colorate. Senza animazione il cambiamento sarebbe immediato
                    //con animazione, tutto avviene in modo fluido
                    top.getLayoutParams().width =  ViewGroup.LayoutParams.MATCH_PARENT;
                    bottom.getLayoutParams().width =  ViewGroup.LayoutParams.MATCH_PARENT;

                    //rende visibile il textView della data
                    desc.setVisibility(visible ? View.VISIBLE : View.GONE);
                    //metodi del TypeWriter
                    desc.setCharacterDelay(100);
                    desc.animateText("Isernia\n21.10.2017");


                    //vedi prossimo metodo
                    final Runnable endAction = new Runnable() {
                        @Override
                        public void run() {

                        }
                    };

                    //animazione aggiuntiva per il logo triangolare
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            //chiama animazione sul logo, di tipo rotazione, di 360 gradi che deve durare 1,2 secondi
                            //e che parte dopo 2,6 secondi rispetto alle altre animazioni dichiarate prima
                            //WithEnd Action serve a dirgli quando deve far finire l'animazione (senza il logo continua a girare
                            //di 360 gradi ogni 1,2 secondi, passandogli il Runnable vuoto che abbiamo dichiarato sopra invece
                            //fa un giro e poi si ferma
                            night_logo.animate().rotationBy(360).setDuration(1200).setStartDelay(2600).withEndAction(endAction).setInterpolator(new OvershootInterpolator()).setListener(new Animator.AnimatorListener() {

                                @Override
                                public void onAnimationStart(Animator animator) {
                                    //non serve ma va dichiarato
                                }

                                //ho attaccato un listner all'animazione in modo che quando ha finito (cioè quando ha fatto un giro)
                                //passa direttamente alla prossima activity
                                @Override
                                public void onAnimationEnd(Animator animator) {
                                    Intent toPage = new Intent(Launcher.this,FirstPage.class);
                                    startActivity(toPage);
                                }

                                @Override
                                public void onAnimationCancel(Animator animator) {
                                    //non serve ma va dichiarato

                                }

                                @Override
                                public void onAnimationRepeat(Animator animator) {
                                    //non serve ma va dichiarato
                                }

                            }).start(); //inizia l'animazione
                        }
                    };
                    runnable.run();

                }
            }, 600); //parte dopo 600 millisecondi
        }
    }
    //libreria calligrafia
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


}