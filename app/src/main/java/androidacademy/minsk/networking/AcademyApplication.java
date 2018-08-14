package androidacademy.minsk.networking;

import android.app.Application;
import androidacademy.minsk.networking.network.FoursquareService;
import androidacademy.minsk.networking.network.NetworkModule;

public class AcademyApplication extends Application {

    public FoursquareService api = new NetworkModule().foursquareService;

    private static AcademyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
    }

    public static AcademyApplication getApp() {
        return sInstance;
    }
}
