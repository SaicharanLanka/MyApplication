package testdemo.saicharan.myapplication;

import android.app.Application;
import testdemo.saicharan.myapplication.Network.AppComponent;
import testdemo.saicharan.myapplication.Network.AppModule;
import testdemo.saicharan.myapplication.Network.DaggerAppComponent;
import testdemo.saicharan.myapplication.Network.NetWorkModule;



/**
 * Created by sai on 27-02-2019.
 */

public class MyApplication extends Application {


    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netWorkModule(new NetWorkModule())
                .build();

    }
    public AppComponent getAppComponent() {
        return appComponent;
    }
}