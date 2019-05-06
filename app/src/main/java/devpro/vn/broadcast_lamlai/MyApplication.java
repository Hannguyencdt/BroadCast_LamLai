package devpro.vn.broadcast_lamlai;

import android.app.Application;

/**
 * Created by nguye on 5/18/2018.
 */

public class MyApplication extends Application {
    public static MyApplication sInstance;
    public void onCreate(){
        super.onCreate();
        sInstance = this;
    }

    public static MyApplication getInstance() {
        return sInstance;
    }

}
