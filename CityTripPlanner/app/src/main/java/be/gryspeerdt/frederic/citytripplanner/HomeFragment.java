package be.gryspeerdt.frederic.citytripplanner;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    //region FIELDS
    private OnHomeFragmentListener mListener;

    private Button btnMijnKaarten;
    private Button btnNieuweKaart;

    //endregion

    public HomeFragment() {
        // Required empty public constructor
    }

    //region LIFECYCLE
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        //ophalen views
        btnMijnKaarten = (Button) v.findViewById(R.id.btnMijnKaarten);
        btnNieuweKaart = (Button) v.findViewById(R.id.btnNieuweKaart);

        //onClick implementeren
        btnMijnKaarten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.showMijnKaartenFragment();
            }
        });
        btnNieuweKaart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.showNieuweKaartFragment();
            }
        });

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mListener = (OnHomeFragmentListener) activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString() +
                    "must implement OnHomeFragmentListener");
        }
    }
    //region LIFECYCLE

    public interface OnHomeFragmentListener{
        void showMijnKaartenFragment();
        void showNieuweKaartFragment();
    }
}
