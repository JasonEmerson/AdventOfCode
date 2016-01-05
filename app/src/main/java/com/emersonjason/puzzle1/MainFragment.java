package com.emersonjason.puzzle1;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends android.support.v4.app.Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Puzzle puzzle = new Puzzle(getActivity().getApplicationContext());
        puzzle.solve();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        TextView txtString = (TextView)v.findViewById(R.id.txtString);
        txtString.setText("CHECK LOGCAT");
        return v;
    }
}
