package idat.com.appfarmacia;

import android.app.Application;
import android.content.Context;

public class AppWale extends Application {

    static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
