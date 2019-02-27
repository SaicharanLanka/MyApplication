package testdemo.saicharan.myapplication.Activitys;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import testdemo.saicharan.myapplication.Fragments.MostViewedArticleDetailFragment;
import testdemo.saicharan.myapplication.R;

/**
 * Created by sai on 27-02-2019.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize views and required objects.
        init();
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
       /* DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            FragmentManager fragmentManager = getFragmentManager();
            Fragment fragment = getFragmentManager().findFragmentByTag(MostViewedArticleDetailFragment.class.getSimpleName());
            if(fragment!= null && fragment.equals(MostViewedArticleDetailFragment.class.getSimpleName()))
            {
                fragmentManager.popBackStackImmediate();
            }
            else {
                super.onBackPressed();
            }
        }*/
    }
}
