package com.android.workout.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.workout.R;

public class Tipsfragment extends Fragment {
    TextView tipNo,tipDesc;
    int tipNos[] = {R.string.tip1,R.string.tip2,R.string.tip3,R.string.tip4,R.string.tip5,R.string.tip6,
            R.string.tip7,R.string.tip8,R.string.tip9,R.string.tip10};
    int layoutPos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate =layoutInflater.inflate(R.layout.tipsfragment,viewGroup,false);
        tipNo = inflate.findViewById(R.id.tipsserialno);
        tipDesc = inflate.findViewById(R.id.tipsdescription);
        FragmentActivity activity = getActivity();
        activity.getClass();
        //in paranthesis we need to add "R.array.tips"
        Bundle arguments = getArguments();
        if(arguments != null){
            layoutPos = arguments.getInt("pos");
        }
        TextView textView = tipNo;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getString(R.string.tips));
        stringBuilder.append(this.layoutPos+1);
        textView.setText(String.valueOf(stringBuilder.toString()));
        this.tipDesc.setText(getString(this.tipNos[this.layoutPos]));
        return inflate;
    }
}
