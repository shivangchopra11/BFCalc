package com.example.shivang.calculator;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by shivang on 13/12/17.
 */

public class BasicButtons extends Fragment implements View.OnClickListener {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public BasicButtons() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.basic_buttons,container,false);
        final Button b0 = rootView.findViewById(R.id.b0);
        b0.setOnClickListener(this);
        final Button b1 = rootView.findViewById(R.id.b1);
        b1.setOnClickListener(this);
        final Button b2 = rootView.findViewById(R.id.b2);
        b2.setOnClickListener(this);
        final Button b3 = rootView.findViewById(R.id.b3);
        b3.setOnClickListener(this);
        final Button b4 = rootView.findViewById(R.id.b4);
        b4.setOnClickListener(this);
        final Button b5 = rootView.findViewById(R.id.b5);
        b5.setOnClickListener(this);
        final Button b6 = rootView.findViewById(R.id.b6);
        b6.setOnClickListener(this);
        final Button b7 = rootView.findViewById(R.id.b7);
        b7.setOnClickListener(this);
        final Button b8 = rootView.findViewById(R.id.b8);
        b8.setOnClickListener(this);
        final Button b9 = rootView.findViewById(R.id.b9);
        b9.setOnClickListener(this);
        final Button bd1 = rootView.findViewById(R.id.bd1);
        bd1.setOnClickListener(this);
        final Button be = rootView.findViewById(R.id.be);
        be.setOnClickListener(this);
        final Button bc = rootView.findViewById(R.id.bc);
        bc.setOnClickListener(this);
        final Button bp = rootView.findViewById(R.id.bp);
        bp.setOnClickListener(this);
        final Button bm = rootView.findViewById(R.id.bm);
        bm.setOnClickListener(this);
        final Button bs = rootView.findViewById(R.id.bs);
        bs.setOnClickListener(this);
        final Button bd = rootView.findViewById(R.id.bd);
        bd.setOnClickListener(this);
        return rootView;
    }


    @Override
    public void onClick(View v) {
        ((MainActivity)getActivity()).expAdd(v.getId());
    }
}
