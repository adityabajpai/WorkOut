//package com.android.workout.fragments;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.content.SharedPreferences;
//import android.content.res.Configuration;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.android.workout.R;
//
//import java.util.Locale;
//
//public class Tipsfragment extends Fragment {
//    TextView tipNo,tipDesc,textView;
//    int tipNos[] = {R.string.tip1,R.string.tip2,R.string.tip3,R.string.tip4,R.string.tip5,R.string.tip6,
//            R.string.tip7,R.string.tip8,R.string.tip9,R.string.tip10};
//    int layoutPos;
//    private static Locale myLocale;
//
//    private static final String Locale_Preference = "Locale Preference";
//    private static final String Locale_KeyValue = "Saved Locale";
//    private static SharedPreferences sharedPreferences;
//    private static SharedPreferences.Editor editor;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
//        View inflate =layoutInflater.inflate(R.layout.tipsfragment,viewGroup,false);
//        tipNo = inflate.findViewById(R.id.tipsserialno);
//        tipDesc = inflate.findViewById(R.id.tipsdescription);
//        FragmentActivity activity = getActivity();
//        activity.getClass();
//        //in paranthesis we need to add "R.array.tips"
//        Bundle arguments = getArguments();
//        if(arguments != null){
//            layoutPos = arguments.getInt("pos");
//        }
//        sharedPreferences = getActivity().getSharedPreferences(Locale_Preference, Activity.MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//        loadLocale();
//        return inflate;
//    }
//
//    public void loadLocale() {
//        String language = sharedPreferences.getString(Locale_KeyValue, "");
//        changeLocale(language);
//    }
//    public void changeLocale(String lang) {
//        if (lang.equalsIgnoreCase(""))
//            return;
//        myLocale = new Locale(lang);//Set Selected Locale
//        saveLocale(lang);//Save the selected locale
//        Locale.setDefault(myLocale);//set new locale as default
//        Configuration config = new Configuration();//get Configuration
//        config.locale = myLocale;//set config locale as selected locale
//        getActivity().getBaseContext().getResources().updateConfiguration(config, getActivity().getBaseContext().getResources().getDisplayMetrics());//Update the config
//        updateTexts();//Update texts according to locale
//    }
//
//    private void updateTexts() {
//        textView = tipNo;
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(getString(R.string.tips));
//        stringBuilder.append(this.layoutPos+1);
//        textView.setText(String.valueOf(stringBuilder.toString()));
//        this.tipDesc.setText(getString(this.tipNos[this.layoutPos]));
//    }
//
//    public void saveLocale(String lang) {
//        editor.putString(Locale_KeyValue, lang);
//        editor.commit();
//    }
//}
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