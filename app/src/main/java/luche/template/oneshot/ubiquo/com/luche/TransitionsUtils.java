package luche.template.oneshot.ubiquo.com.luche;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/**
 * Created by akain on 13/09/2017.
 */

public class TransitionsUtils {

    protected static void fadeOutInMillisecondsWithDelay(View target, Long time, Long startDelay){
        Animation fadeOut = new AlphaAnimation(1,0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setStartOffset(startDelay);
        fadeOut.setDuration(time);
        fadeOut.setFillAfter(true);

        target.startAnimation(fadeOut);
    }

}
