package luche.template.oneshot.ubiquo.com.luche;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by akain on 13/09/2017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Raleway_Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

    }
}
