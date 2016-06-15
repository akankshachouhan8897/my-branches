package com.codekul.fragmentsnew;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimationFragment extends Fragment {


    public static final String KEY_TEXT_NAME = "textName";

    public AnimationFragment() {
        // Required empty public constructor
    }

    public static AnimationFragment getInstance(String text){

        AnimationFragment fragment =
                new AnimationFragment();

        Bundle args = new Bundle();
        args.putString(KEY_TEXT_NAME,text);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_animation, container, false);

        /*final TextView textName = (TextView)view.findViewById(R.id.textCodeKul);
        textName.setText("");*/

        Bundle args = getArguments();
        if(args != null){
            ((TextView)view
                    .findViewById(R.id.textCodeKul))
                    .setText(args.getString(KEY_TEXT_NAME));
        }

        view
                .findViewById(R.id.textCodeKul)
                .startAnimation(AnimationUtils
                        .loadAnimation(getActivity(),
                R.anim.rotate));

        return view;
    }

}
