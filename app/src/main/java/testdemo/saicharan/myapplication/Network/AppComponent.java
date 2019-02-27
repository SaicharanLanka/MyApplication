package testdemo.saicharan.myapplication.Network;



import javax.inject.Singleton;
import dagger.Component;
import testdemo.saicharan.myapplication.Activitys.MainActivity;
import testdemo.saicharan.myapplication.Fragments.MostViewecArticlesFragment;


/**
 * Created by sai on 27-02-2019.
 */
@Singleton
@Component(modules = {NetWorkModule.class, AppModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);
    void inject(MostViewecArticlesFragment mostViewecArticlesFragment);
}
