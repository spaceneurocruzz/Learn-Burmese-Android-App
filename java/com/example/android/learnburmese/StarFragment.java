package com.example.android.learnburmese;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SherlockHolmes on 2016/10/6.
 */
public class StarFragment extends Fragment {    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.star_fragment,container,false);
    return v;
}
}
