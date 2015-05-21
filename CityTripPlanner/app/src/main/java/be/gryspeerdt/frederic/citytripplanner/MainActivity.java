package be.gryspeerdt.frederic.citytripplanner;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;


public class MainActivity extends FragmentActivity implements HomeFragment.OnHomeFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.container_fragment) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            HomeFragment homeFragment = new HomeFragment();
            MapFragment mapFragment =
                    (MapFragment) getFragmentManager().findFragmentById(R.id.map);

            // Add the fragment to the 'fragment_container' FrameLayout
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_fragment, mapFragment)
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //region FRAGMENT CALLBACK METHODES
    @Override
    public void showMijnKaartenFragment() {
        MijnKaartenFragment mijnKaartenFragment = new MijnKaartenFragment();

        getFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, mijnKaartenFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showNieuweKaartFragment() {
        NieuweKaartFragment nieuweKaartFragment = new NieuweKaartFragment();

        getFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, nieuweKaartFragment)
                .addToBackStack(null)
                .commit();
    }


}
