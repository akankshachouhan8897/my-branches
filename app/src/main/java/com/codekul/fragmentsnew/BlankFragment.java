package com.codekul.fragmentsnew;


import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_blank,
                container,
                false);

        view.findViewById(R.id.btnLogin)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        MainActivity act = (MainActivity)
                                getActivity();
                        act.runFragmentTransaction(R.id.frameThirdFragments,
                                AnimationFragment.getInstance("{code}kul;"));

                    }
                });

        return view;
    }
}