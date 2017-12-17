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

public class AdvButtons extends Fragment implements View.OnClickListener {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public AdvButtons() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.adv_buttons,container,false);
        final Button bsin = rootView.findViewById(R.id.bsin);
        bsin.setOnClickListener(this);
        final Button bcos = rootView.findViewById(R.id.bcos);
        bcos.setOnClickListener(this);
        final Button btan = rootView.findViewById(R.id.btan);
        btan.setOnClickListener(this);
        final Button bpow = rootView.findViewById(R.id.bpow);
        bpow.setOnClickListener(this);
        final Button bln = rootView.findViewById(R.id.bln);
        bln.setOnClickListener(this);
        final Button blog = rootView.findViewById(R.id.blog);
        blog.setOnClickListener(this);
        final Button bsinh = rootView.findViewById(R.id.bsinh);
        bsinh.setOnClickListener(this);
        final Button bcosh = rootView.findViewById(R.id.bcosh);
        bcosh.setOnClickListener(this);
        final Button btanh = rootView.findViewById(R.id.btanh);
        btanh.setOnClickListener(this);
        final Button bpi = rootView.findViewById(R.id.bpi);
        bpi.setOnClickListener(this);
        final Button bexp = rootView.findViewById(R.id.bexp);
        bexp.setOnClickListener(this);
        final Button bperc = rootView.findViewById(R.id.bperc);
        bperc.setOnClickListener(this);
        final Button bbb = rootView.findViewById(R.id.bbb);
        bbb.setOnClickListener(this);
        final Button bbe = rootView.findViewById(R.id.bbe);
        bbe.setOnClickListener(this);
        final Button bdel = rootView.findViewById(R.id.bdel);
        bdel.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        ((MainActivity)getActivity()).expAdd(v.getId());
    }
}
