package com.android.workout.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.workout.R;

public class DailyMeal extends Fragment {

    Context a;
    private Boolean complete;
    private FloatingActionButton completed;
    private Button mBtnStdDiet;
    private Button mBtnVegDiet;
    private LinearLayout mLayoutStdDiet;
    private LinearLayout mLayoutVegDiet;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor prefsEditor;
    private int screenHeight;
    private int screenWidth;
    private ScrollView scrollstddietfood;
    private ScrollView scrollvegdietfood;
    private Boolean stddietenabled;
    private Boolean vegdietenabled;

    public DailyMeal() {}

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        a = getActivity();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            getFragmentManager().popBackStack();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, final Bundle paramBundle){
        View inflate = paramLayoutInflater.inflate(R.layout.layout_dailymeal, paramViewGroup, false);
        inflate.setTag("DailyMeal");
        getArguments().getInt("DAY");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;
        Toolbar toolbar  = inflate.findViewById(R.id.toolbar);
        TextView titleHead = inflate.findViewById(R.id.tittletext);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Day ");
        ((StringBuilder)localObject).append(getArguments().getInt("DAY"));
        titleHead.setText(localObject.toString());
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        setHasOptionsMenu(true);
        toolbar.getNavigationIcon().mutate().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        scrollstddietfood = inflate.findViewById(R.id.scrollstddietfood);
        scrollvegdietfood = inflate.findViewById(R.id.scrollvegdietfood);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        prefsEditor = mSharedPreferences.edit();
        localObject = new StringBuilder();
        ((StringBuilder) localObject).append("DAY_");
        ((StringBuilder) localObject).append(getArguments().getInt("DAY"));
        ((StringBuilder) localObject).append("_CHECKED");
        final String str0 = localObject.toString();
        Object obj1 = new StringBuilder();
        ((StringBuilder) obj1).append("DAY_");
        ((StringBuilder) obj1).append(getArguments().getInt("DAY"));
        ((StringBuilder) obj1).append("_STDDIET");
        final String str1 = obj1.toString();
        obj1 = new StringBuilder();
        ((StringBuilder) obj1).append("DAY_");
        ((StringBuilder) obj1).append(getArguments().getInt("DAY"));
        ((StringBuilder) obj1).append("_VEGDIET");
        final String str2 = obj1.toString();
        complete = Boolean.valueOf(mSharedPreferences.getBoolean(str0, false));
        stddietenabled = Boolean.valueOf(mSharedPreferences.getBoolean(str1, false));
        vegdietenabled = Boolean.valueOf(mSharedPreferences.getBoolean(str2, false));
        completed = inflate.findViewById(R.id.fab);
        mBtnStdDiet = inflate.findViewById(R.id.Stddiet);
        mBtnVegDiet = inflate.findViewById(R.id.vegdiet);
        mLayoutStdDiet = inflate.findViewById(R.id.stddietfood);
        mLayoutVegDiet = inflate.findViewById(R.id.vegdietfood);
        TextView breakfast1 = inflate.findViewById(R.id.brkfast1);
        TextView breakfast2 = inflate.findViewById(R.id.brkfast2);
        TextView lunch1 = inflate.findViewById(R.id.lunch1);
        TextView lunch2 = inflate.findViewById(R.id.lunch2);
        TextView snack1 = inflate.findViewById(R.id.snack1);
        TextView snack2 = inflate.findViewById(R.id.snack2);
        TextView snack3 = inflate.findViewById(R.id.snack3);
        TextView dinner1 = inflate.findViewById(R.id.dinner1);
        TextView dinner2 = inflate.findViewById(R.id.dinner2);
        TextView dinner3 = inflate.findViewById(R.id.dinner3);
        TextView vegbreakfast1 = inflate.findViewById(R.id.vegbrkfast1);
        TextView vegbreakfast2 = inflate.findViewById(R.id.vegbrkfast2);
        TextView veglunch1 = inflate.findViewById(R.id.veglunch1);
        TextView veglunch2 = inflate.findViewById(R.id.veglunch2);
        TextView vegsnack1 = inflate.findViewById(R.id.vegsnack1);
        TextView vegsnack2 = inflate.findViewById(R.id.vegsnack2);
        TextView vegsnack3 = inflate.findViewById(R.id.vegsnack3);
        TextView vegdinner1 = inflate.findViewById(R.id.vegdinner1);
        TextView vegdinner2 = inflate.findViewById(R.id.vegdinner2);
        TextView vegdinner3 = inflate.findViewById(R.id.vegdinner3);
        switch(getArguments().getInt("DAY")) {
            case 30:
                breakfast1.setText(getResources().getString(R.string.threeboiledeggwhites));
                breakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Redricewithsteamcookedtuna));
                lunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                snack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                snack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                snack3.setText(getResources().getString(R.string.fivewalnuts));
                dinner1.setText(getResources().getString(R.string.Chickensoup));
                dinner2.setText(getResources().getString(R.string.Pineappleslicesorgrapes));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.threeboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.WholewheatvegetablewrapTomatoonioncucumberspinachcheese));
                veglunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                vegsnack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                vegsnack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                vegsnack3.setText(getResources().getString(R.string.fourWalnuts));
                vegdinner1.setText(getResources().getString(R.string.leafygreenssoupbroccolispinachlettuce));
                vegdinner2.setText(getResources().getString(R.string.Pineappleslices));
                vegdinner3.setVisibility(8);
                break;
            case 29:
                breakfast1.setText(getResources().getString(R.string.onescrambledegg));
                breakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Wholewheatpastawithveggies));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.onecupofgreentea));
                snack2.setText(getResources().getString(R.string.fouroatmealcookies));
                snack3.setText(getResources().getString(R.string.fivealmonds));
                dinner1.setText(getResources().getString(R.string.steamcookedchickenbreasts));
                dinner2.setText(getResources().getString(R.string.Fruitsalad));
                dinner3.setText(getResources().getString(R.string.greekyogurt));
                vegbreakfast1.setText(getResources().getString(R.string.onescrambledegg));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Wholewheatpastawithveggies));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.onecupofgreentea));
                vegsnack2.setText(getResources().getString(R.string.oatmealcookies));
                vegsnack3.setText(getResources().getString(R.string.fivealmonds));
                vegdinner1.setText(getResources().getString(R.string.Tomatosoup));
                vegdinner2.setText(getResources().getString(R.string.Fruitsalad));
                vegdinner3.setText(getResources().getString(R.string.greekyogurt));
                break;
            case 28:
                breakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                breakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Redricewithsteamcookedtuna));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.onecupofgreentea));
                snack2.setText(getResources().getString(R.string.fourslicesofpineapple));
                snack3.setText(getResources().getString(R.string.fivealmonds));
                dinner1.setText(getResources().getString(R.string.steamcookedchickenbreasts));
                dinner2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Redricewithmushroom));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                vegsnack2.setText(getResources().getString(R.string.fourslicesofpineapple));
                vegsnack3.setText(getResources().getString(R.string.fivealmonds));
                vegdinner1.setText(getResources().getString(R.string.Vegetablesoup));
                vegdinner2.setText(getResources().getString(R.string.Grapes));
                vegdinner3.setVisibility(8);
                break;
            case 27:
                breakfast1.setText(getResources().getString(R.string.onescrambledegg));
                breakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Wholewheatpastawithsteamcookedsalmon));
                lunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                snack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                snack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                snack3.setText(getResources().getString(R.string.fivewalnuts));
                dinner1.setText(getResources().getString(R.string.Chickensoup));
                dinner2.setText(getResources().getString(R.string.threePineappleslicesorgrapes));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.onescrambledegg));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.WholewheatvegetablewrapTomatoonioncucumberspinachcheese));
                veglunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                vegsnack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                vegsnack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                vegsnack3.setText(getResources().getString(R.string.fourWalnuts));
                vegdinner1.setText(getResources().getString(R.string.leafygreenssoupbroccolispinachlettuce));
                vegdinner2.setText(getResources().getString(R.string.Pineappleslices));
                vegdinner3.setVisibility(8);
                break;
            case 26:
                breakfast1.setText(getResources().getString(R.string.threeboiledeggwhites));
                breakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.WholewheatchickenwrapChickenbreastslettucetomatoyogurtsauce));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.onecupofgreentea));
                snack2.setText(getResources().getString(R.string.fouroatmealcookies));
                snack3.setText(getResources().getString(R.string.fivealmonds));
                dinner1.setText(getResources().getString(R.string.steamcookedchickenbreasts));
                dinner2.setText(getResources().getString(R.string.Fruitsalad));
                dinner3.setText(getResources().getString(R.string.greekyogurt));
                vegbreakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Wholewheatpastawithveggies));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.onecupofgreentea));
                vegsnack2.setText(getResources().getString(R.string.fouroatmealcookies));
                vegsnack3.setText(getResources().getString(R.string.fivealmonds));
                vegdinner1.setText(getResources().getString(R.string.Tomatosoup));
                vegdinner2.setText(getResources().getString(R.string.Fruitsalad));
                vegdinner3.setVisibility(8);
                break;
            case 25:
                breakfast1.setText(getResources().getString(R.string.twoscrambledeggs));
                breakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Wholewheatpastawithsteamcookedsalmon));
                lunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                snack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                snack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                snack3.setText(getResources().getString(R.string.fourWalnuts));
                dinner1.setText(getResources().getString(R.string.Vegetablesoup));
                dinner2.setText(getResources().getString(R.string.Chickenbreasts));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.twoscrambledeggs));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Redricewithmushroom));
                veglunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                vegsnack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                vegsnack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                vegsnack3.setText(getResources().getString(R.string.fourWalnuts));
                vegdinner1.setText(getResources().getString(R.string.Vegetablesoup));
                vegdinner2.setText(getResources().getString(R.string.Grapes));
                vegdinner3.setText(getResources().getString(R.string.greekyogurt));
                break;
            case 24:
                breakfast1.setText(getResources().getString(R.string.threeboiledeggwhites));
                breakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Redricewithsteamcookedtuna));
                lunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                snack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                snack2.setText(getResources().getString(R.string.fourslicesofpineapple));
                snack3.setText(getResources().getString(R.string.fivealmonds));
                dinner1.setText(getResources().getString(R.string.Steamcookedleanbeef));
                dinner2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.WholewheatvegetablewrapTomatoonioncucumberspinachcheese));
                veglunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                vegsnack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                vegsnack2.setText(getResources().getString(R.string.fourslicesofpineapple));
                vegsnack3.setText(getResources().getString(R.string.fivealmonds));
                vegdinner1.setText(getResources().getString(R.string.leafygreenssoupbroccolispinachlettuce));
                vegdinner2.setText(getResources().getString(R.string.Pineappleslices));
                vegdinner3.setVisibility(8);
                break;
            case 23:
                breakfast1.setText(getResources().getString(R.string.onescrambledegg));
                breakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Wholewheatpastawithbroccoli));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                snack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                snack3.setText(getResources().getString(R.string.fivewalnuts));
                dinner1.setText(getResources().getString(R.string.Chickensoup));
                dinner2.setText(getResources().getString(R.string.threePineappleslicesorgrapes));
                dinner3.setText(getResources().getString(R.string.greekyogurt));
                vegbreakfast1.setText(getResources().getString(R.string.onescrambledegg));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Wholewheatpastawithbroccoli));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                vegsnack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                vegsnack3.setText(getResources().getString(R.string.fourWalnuts));
                vegdinner1.setText(getResources().getString(R.string.Tomatosoup));
                vegdinner2.setText(getResources().getString(R.string.Fruitsalad));
                vegdinner3.setText(getResources().getString(R.string.greekyogurt));
                break;
            case 22:
                breakfast1.setText(getResources().getString(R.string.fourboiledeggwhites));
                breakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.WholewheatfishwrapSteamcookedtunalettucetomatoyogurtsauce));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.onecupofgreentea));
                snack2.setText(getResources().getString(R.string.fiveoatmealcookies));
                snack3.setText(getResources().getString(R.string.fivealmonds));
                dinner1.setText(getResources().getString(R.string.steamcookedchickenbreasts));
                dinner2.setText(getResources().getString(R.string.Fruitsalad));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Redricewithleafygreenspinachbroccoli));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.onecupofgreentea));
                vegsnack2.setText(getResources().getString(R.string.fiveoatmealcookies));
                vegsnack3.setText(getResources().getString(R.string.fivealmonds));
                vegdinner1.setText(getResources().getString(R.string.Vegetablesoup));
                vegdinner2.setText(getResources().getString(R.string.Grapes));
                vegdinner3.setVisibility(8);
                break;
            case 21:
                breakfast1.setText(getResources().getString(R.string.twoscrambledeggs));
                breakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Redricewithsteamcookedchickenbreasts));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                snack2.setText(getResources().getString(R.string.threeslicesofpineapple));
                snack3.setText(getResources().getString(R.string.sixalmonds));
                dinner1.setText(getResources().getString(R.string.Steamcookedleanbeef));
                dinner2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.WholewheatvegetablewrapTomatoonioncucumberspinachcheese));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                vegsnack2.setText(getResources().getString(R.string.threeslicesofpineapple));
                vegsnack3.setText(getResources().getString(R.string.fivealmonds));
                vegdinner1.setText(getResources().getString(R.string.leafygreenssoupbroccolispinachlettuce));
                vegdinner2.setText(getResources().getString(R.string.Pineappleslices));
                vegdinner3.setText(getResources().getString(R.string.greekyogurt));
                break;
            case 20:
                breakfast1.setText(getResources().getString(R.string.threeboiledeggwhites));
                breakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Wholewheatpastawithsteamcookedsalmon));
                lunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                snack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                snack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                snack3.setText(getResources().getString(R.string.fourWalnuts));
                dinner1.setText(getResources().getString(R.string.Chickensoup));
                dinner2.setText(getResources().getString(R.string.threePineappleslicesorgrapes));
                dinner3.setText(getResources().getString(R.string.greekyogurt));
                vegbreakfast1.setText(getResources().getString(R.string.threeboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Wholewheatpastawithbroccoli));
                veglunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                vegsnack1.setText(getResources().getString(R.string.onecupofgreentea));
                vegsnack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                vegsnack3.setText(getResources().getString(R.string.fourWalnuts));
                vegdinner1.setText(getResources().getString(R.string.Tomatosoup));
                vegdinner2.setText(getResources().getString(R.string.Fruitsalad));
                vegdinner3.setVisibility(8);
                break;
            case 19:
                breakfast1.setText(getResources().getString(R.string.onescrambledegg));
                breakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.WholewheatfishwrapSteamcookedtunalettucetomatoyogurtsauce));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                snack2.setText(getResources().getString(R.string.fouroatmealcookies));
                snack3.setText(getResources().getString(R.string.sixalmonds));
                dinner1.setText(getResources().getString(R.string.steamcookedchickenbreasts));
                dinner2.setText(getResources().getString(R.string.Fruitsalad));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.onescrambledegg));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Redricewithmushroom));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.onecupofgreentea));
                vegsnack2.setText(getResources().getString(R.string.fouroatmealcookies));
                vegsnack3.setText(getResources().getString(R.string.fivealmonds));
                vegdinner1.setText(getResources().getString(R.string.Vegetablesoup));
                vegdinner2.setText(getResources().getString(R.string.Grapes));
                vegdinner3.setText(getResources().getString(R.string.greekyogurt));
                break;
            case 18:
                breakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                breakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Wholewheatpastawithsteamcookedsalmon));
                lunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                snack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                snack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                snack3.setText(getResources().getString(R.string.fourWalnuts));
                dinner1.setText(getResources().getString(R.string.Vegetablesoup));
                dinner2.setText(getResources().getString(R.string.Chickenbreasts));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.threeboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.WholewheatvegetablewrapTomatoonioncucumberspinachcheese));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                vegsnack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                vegsnack3.setText(getResources().getString(R.string.fourWalnuts));
                vegdinner1.setText(getResources().getString(R.string.leafygreenssoupbroccolispinachlettuce));
                vegdinner2.setText(getResources().getString(R.string.Pineappleslices));
                vegdinner3.setText(getResources().getString(R.string.greekyogurt));
                break;
            case 17:
                breakfast1.setText(getResources().getString(R.string.twoscrambledeggs));
                breakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Redricewithsteamcookedtuna));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                snack2.setText(getResources().getString(R.string.fourslicesofpineapple));
                snack3.setText(getResources().getString(R.string.fivealmonds));
                dinner1.setText(getResources().getString(R.string.Steamcookedleanbeef));
                dinner2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                dinner3.setText(getResources().getString(R.string.greekyogurt));
                vegbreakfast1.setText(getResources().getString(R.string.twoscrambledeggs));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Redricewithleafygreenspinachbroccoli));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                vegsnack2.setText(getResources().getString(R.string.fourslicesofpineapple));
                vegsnack3.setText(getResources().getString(R.string.fivealmonds));
                vegdinner1.setText(getResources().getString(R.string.Tomatosoup));
                vegdinner2.setText(getResources().getString(R.string.Fruitsalad));
                vegdinner3.setText(getResources().getString(R.string.greekyogurt));
                break;
            case 16:
                breakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                breakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Wholewheatpastawithsteamcookedsalmon));
                lunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                snack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                snack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                snack3.setText(getResources().getString(R.string.fourWalnuts));
                dinner1.setText(getResources().getString(R.string.Chickensoup));
                dinner2.setText(getResources().getString(R.string.Pineappleslicesorgrapes));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.threeboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Wholewheatpastawithbroccoli));
                veglunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                vegsnack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                vegsnack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                vegsnack3.setText(getResources().getString(R.string.fourWalnuts));
                vegdinner1.setText(getResources().getString(R.string.Vegetablesoup));
                vegdinner2.setText(getResources().getString(R.string.Grapes));
                vegdinner3.setVisibility(8);
                break;
            case 15:
                breakfast1.setText(getResources().getString(R.string.onescrambledegg));
                breakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.WholewheatchickenwrapChickenbreastslettucetomatoyogurtsauce));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.onecupofgreentea));
                snack2.setText(getResources().getString(R.string.fouroatmealcookies));
                snack3.setText(getResources().getString(R.string.sixalmonds));
                dinner1.setText(getResources().getString(R.string.steamcookedchickenbreasts));
                dinner2.setText(getResources().getString(R.string.Fruitsalad));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.onescrambledegg));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.WholewheatvegetablewrapTomatoonioncucumberspinachcheese));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                vegsnack2.setText(getResources().getString(R.string.fouroatmealcookies));
                vegsnack3.setText(getResources().getString(R.string.fivealmonds));
                vegdinner1.setText(getResources().getString(R.string.leafygreenssoupbroccolispinachlettuce));
                vegdinner2.setText(getResources().getString(R.string.Pineappleslices));
                vegdinner3.setText(getResources().getString(R.string.greekyogurt));
                break;
            case 14:
                breakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                breakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Redricewithsteamcookedchickenbreasts));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                snack2.setText(getResources().getString(R.string.fourslicesofpineapple));
                snack3.setText(getResources().getString(R.string.fivealmonds));
                dinner1.setText(getResources().getString(R.string.Steamcookedleanbeef));
                dinner2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                dinner3.setText(getResources().getString(R.string.greekyogurt));
                vegbreakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Redricewithmushroom));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                vegsnack2.setText(getResources().getString(R.string.fourslicesofpineapple));
                vegsnack3.setText(getResources().getString(R.string.fivealmonds));
                vegdinner1.setText(getResources().getString(R.string.Tomatosoup));
                vegdinner2.setText(getResources().getString(R.string.Fruitsalad));
                vegdinner3.setVisibility(8);
                break;
            case 13:
                breakfast1.setText(getResources().getString(R.string.threeboiledeggwhites));
                breakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.WholewheatfishwrapSteamcookedtunalettucetomatoyogurtsauce));
                lunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                snack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                snack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                snack3.setText(getResources().getString(R.string.sixalmonds));
                dinner1.setText(getResources().getString(R.string.Chickensoup));
                dinner2.setText(getResources().getString(R.string.threePineappleslicesorgrapes));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.threeboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Wholewheatpastawithveggies));
                veglunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                vegsnack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                vegsnack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                vegsnack3.setText(getResources().getString(R.string.fourWalnuts));
                vegdinner1.setText(getResources().getString(R.string.Vegetablesoup));
                vegdinner2.setText(getResources().getString(R.string.Grapes));
                vegdinner3.setText(getResources().getString(R.string.greekyogurt));
                break;
            case 12:
                breakfast1.setText(getResources().getString(R.string.twoscrambledeggs));
                breakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Redricewithsteamcookedtuna));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.onecupofgreentea));
                snack2.setText(getResources().getString(R.string.fouroatmealcookies));
                snack3.setText(getResources().getString(R.string.fivealmonds));
                dinner1.setText(getResources().getString(R.string.steamcookedchickenbreasts));
                dinner2.setText(getResources().getString(R.string.Fruitsalad));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.twoscrambledeggs));
                vegbreakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Redricewithleafygreenspinachbroccoli));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.onecupofgreentea));
                vegsnack2.setText(getResources().getString(R.string.fouroatmealcookies));
                vegsnack3.setText(getResources().getString(R.string.fivealmonds));
                vegdinner1.setText(getResources().getString(R.string.leafygreenssoupbroccolispinachlettuce));
                vegdinner2.setText(getResources().getString(R.string.Pineappleslices));
                vegdinner3.setVisibility(8);
                break;
            case 11:
                breakfast1.setText(getResources().getString(R.string.threeboiledeggwhites));
                breakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Wholewheatpastawithveggies));
                lunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                snack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                snack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                snack3.setText(getResources().getString(R.string.sixwalnuts));
                dinner1.setText(getResources().getString(R.string.Vegetablesoup));
                dinner2.setText(getResources().getString(R.string.Chickenbreasts));
                dinner3.setText(getResources().getString(R.string.greekyogurt));
                vegbreakfast1.setText(getResources().getString(R.string.threeboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.WholewheatvegetablewrapTomatoonioncucumberspinachcheese));
                veglunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                vegsnack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                vegsnack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                vegsnack3.setText(getResources().getString(R.string.fourWalnuts));
                vegdinner1.setText(getResources().getString(R.string.Tomatosoup));
                vegdinner2.setText(getResources().getString(R.string.Fruitsalad));
                vegdinner3.setText(getResources().getString(R.string.greekyogurt));
                break;
            case 10:
                breakfast1.setText(getResources().getString(R.string.onescrambledegg));
                breakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.WholewheatchickenwrapChickenbreastslettucetomatoyogurtsauce));
                lunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                snack1.setText(getResources().getString(R.string.onecupofgreentea));
                snack2.setText(getResources().getString(R.string.fourslicesofpineapple));
                snack3.setText(getResources().getString(R.string.fivealmonds));
                dinner1.setText(getResources().getString(R.string.Steamcookedleanbeef));
                dinner2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.onescrambledegg));
                vegbreakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Wholewheatpastawithveggies));
                veglunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                vegsnack1.setText(getResources().getString(R.string.onecupofgreentea));
                vegsnack2.setText(getResources().getString(R.string.fourslicesofpineapple));
                vegsnack3.setText(getResources().getString(R.string.sixalmonds));
                vegdinner1.setText(getResources().getString(R.string.Vegetablesoup));
                vegdinner2.setText(getResources().getString(R.string.Grapes));
                vegdinner3.setVisibility(8);
                break;
            case 9:
                breakfast1.setText(getResources().getString(R.string.threeboiledeggwhites));
                breakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Wholewheatpastawithsteamcookedsalmon));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                snack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                snack3.setText(getResources().getString(R.string.fourWalnuts));
                dinner1.setText(getResources().getString(R.string.Chickensoup));
                dinner2.setText(getResources().getString(R.string.threePineappleslicesorgrapes));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.threeboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Wholewheatpastawithbroccoli));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                vegsnack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                vegsnack3.setText(getResources().getString(R.string.fivewalnuts));
                vegdinner1.setText(getResources().getString(R.string.leafygreenssoupbroccolispinachlettuce));
                vegdinner2.setText(getResources().getString(R.string.Pineappleslices));
                vegdinner3.setText(getResources().getString(R.string.greekyogurt));
                break;
            case 8:
                breakfast1.setText(getResources().getString(R.string.twoscrambledeggs));
                breakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.RedricewithsteamcookedLeanbeef));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.onecupofgreentea));
                snack2.setText(getResources().getString(R.string.fiveoatmealcookies));
                snack3.setText(getResources().getString(R.string.sixalmonds));
                dinner1.setText(getResources().getString(R.string.steamcookedchickenbreasts));
                dinner2.setText(getResources().getString(R.string.Fruitsalad));
                dinner3.setText(getResources().getString(R.string.greekyogurt));
                vegbreakfast1.setText(getResources().getString(R.string.twoscrambledeggs));
                vegbreakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.WholewheatvegetablewrapTomatoonioncucumberspinachcheese));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.onecupofgreentea));
                vegsnack2.setText(getResources().getString(R.string.fiveoatmealcookies));
                vegsnack3.setText(getResources().getString(R.string.sixalmonds));
                vegdinner1.setText(getResources().getString(R.string.Tomatosoup));
                vegdinner2.setText(getResources().getString(R.string.Fruitsalad));
                vegdinner3.setVisibility(8);
                break;
            case 7:
                breakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                breakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.WholewheatfishwrapSteamcookedtunalettucetomatoyogurtsauce));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                snack2.setText(getResources().getString(R.string.threeslicesofpineapple));
                snack3.setText(getResources().getString(R.string.fivealmonds));
                dinner1.setText(getResources().getString(R.string.Steamcookedleanbeef));
                dinner2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Redricewithmushroom));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                vegsnack2.setText(getResources().getString(R.string.threeslicesofpineapple));
                vegsnack3.setText(getResources().getString(R.string.fivealmonds));
                vegdinner1.setText(getResources().getString(R.string.Vegetablesoup));
                vegdinner2.setText(getResources().getString(R.string.Grapes));
                vegdinner3.setText(getResources().getString(R.string.greekyogurt));
                break;
            case 6:
                breakfast1.setText(getResources().getString(R.string.onescrambledegg));
                breakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Wholewheatpastawithbroccoli));
                lunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                snack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                snack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                snack3.setText(getResources().getString(R.string.fourWalnuts));
                dinner1.setText(getResources().getString(R.string.Chickensoup));
                dinner2.setText(getResources().getString(R.string.threePineappleslicesorgrapes));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Wholewheatpastawithbroccoli));
                veglunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                vegsnack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                vegsnack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                vegsnack3.setText(getResources().getString(R.string.fourWalnuts));
                vegdinner1.setText(getResources().getString(R.string.leafygreenssoupbroccolispinachlettuce));
                vegdinner2.setText(getResources().getString(R.string.Pineappleslices));
                vegdinner3.setVisibility(0);
                break;
            case 5:
                breakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                breakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Redricewithsteamcookedtuna));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.onecupofgreentea));
                snack2.setText(getResources().getString(R.string.fouroatmealcookies));
                snack3.setText(getResources().getString(R.string.fivealmonds));
                dinner1.setText(getResources().getString(R.string.steamcookedchickenbreasts));
                dinner2.setText(getResources().getString(R.string.Fruitsalad));
                dinner3.setText(getResources().getString(R.string.greekyogurt));
                vegbreakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Redricewithleafygreenspinachbroccoli));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.onecupofgreentea));
                vegsnack2.setText(getResources().getString(R.string.fouroatmealcookies));
                vegsnack3.setText(getResources().getString(R.string.fivealmonds));
                vegdinner1.setText(getResources().getString(R.string.Tomatosoup));
                vegdinner2.setText(getResources().getString(R.string.Fruitsalad));
                vegdinner3.setVisibility(8);
                break;
            case 4:
                breakfast1.setText(getResources().getString(R.string.twoscrambledeggs));
                breakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Wholewheatpastawithsteamcookedsalmon));
                lunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                snack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                snack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                snack3.setText(getResources().getString(R.string.fourWalnuts));
                dinner1.setText(getResources().getString(R.string.Vegetablesoup));
                dinner2.setText(getResources().getString(R.string.Chickenbreasts));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.twoscrambledeggs));
                vegbreakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Wholewheatpastawithbroccoli));
                veglunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                vegsnack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                vegsnack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                vegsnack3.setText(getResources().getString(R.string.fourWalnuts));
                vegdinner1.setText(getResources().getString(R.string.Vegetablesoup));
                vegdinner2.setText(getResources().getString(R.string.Grapes));
                vegdinner3.setVisibility(8);
                break;
            case 3:
                breakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                breakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.WholewheatchickenwrapChickenbreastslettucetomatoyogurtsauce));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                snack2.setText(getResources().getString(R.string.fourslicesofpineapple));
                snack3.setText(getResources().getString(R.string.fivealmonds));
                dinner1.setText(getResources().getString(R.string.Steamcookedleanbeef));
                dinner2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                dinner3.setText(getResources().getString(R.string.greekyogurt));
                vegbreakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.WholewheatvegetablewrapTomatoonioncucumberspinachcheese));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.oneglassofamlajuice));
                vegsnack2.setText(getResources().getString(R.string.fourslicesofpineapple));
                vegsnack3.setText(getResources().getString(R.string.fivealmonds));
                vegdinner1.setText(getResources().getString(R.string.leafygreenssoupbroccolispinachlettuce));
                vegdinner2.setText(getResources().getString(R.string.Pineappleslices));
                vegdinner3.setText(getResources().getString(R.string.greekyogurt));
                break;
            case 2:
                breakfast1.setText(getResources().getString(R.string.onescrambledegg));
                breakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.Wholewheatpastawithveggies));
                lunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                snack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                snack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                snack3.setText(getResources().getString(R.string.fourWalnuts));
                dinner1.setText(getResources().getString(R.string.Chickensoup));
                dinner2.setText(getResources().getString(R.string.Pineappleslicesorgrapes));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.onescrambledegg));
                vegbreakfast2.setText(getResources().getString(R.string.Oatswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.Wholewheatpastawithveggies));
                veglunch2.setText(getResources().getString(R.string.BoiledvegetablesSpinachbeanscabbagetomato));
                vegsnack1.setText(getResources().getString(R.string.oneglassoflemonjuicewithhoney));
                vegsnack2.setText(getResources().getString(R.string.Brownbreadvegsandwich));
                vegsnack3.setText(getResources().getString(R.string.fourWalnuts));
                vegdinner1.setText(getResources().getString(R.string.Tomatosoup));
                vegdinner2.setText(getResources().getString(R.string.Fruitsalad));
                vegdinner3.setVisibility(8);
                break;
            case 1:
                breakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                breakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                lunch1.setText(getResources().getString(R.string.redrice));
                lunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                snack1.setText(getResources().getString(R.string.onecupofgreentea));
                snack2.setText(getResources().getString(R.string.oatmealcookies));
                snack3.setText(getResources().getString(R.string.fivealmonds));
                dinner1.setText(getResources().getString(R.string.steamcookedchickenbreasts));
                dinner2.setText(getResources().getString(R.string.Fruitsalad));
                dinner3.setVisibility(8);
                vegbreakfast1.setText(getResources().getString(R.string.twoboiledeggwhites));
                vegbreakfast2.setText(getResources().getString(R.string.Cornflakeswithskimmedmilk));
                veglunch1.setText(getResources().getString(R.string.redrice));
                veglunch2.setText(getResources().getString(R.string.VegetablesaladCarrotcucumbercabbagelettuce));
                vegsnack1.setText(getResources().getString(R.string.onecupofgreentea));
                vegsnack2.setText(getResources().getString(R.string.oatmealcookies));
                vegsnack3.setText(getResources().getString(R.string.fivealmonds));
                vegdinner1.setText(getResources().getString(R.string.Vegetablesoup));
                vegdinner2.setText(getResources().getString(R.string.Grapes));
                vegdinner3.setText(getResources().getString(R.string.greekyogurt));
                break;
            default:break;
        }
        mBtnStdDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stddietenabled = mSharedPreferences.getBoolean(str1,false);
                if(!stddietenabled.booleanValue()){
                    mBtnStdDiet.setTextColor(getResources().getColor(R.color.colorAccent));
                    mBtnVegDiet.setTextColor(getResources().getColor(R.color.colorPrimary));
                    scrollstddietfood.setVisibility(View.VISIBLE);
                    scrollvegdietfood.setVisibility(View.INVISIBLE);
                    prefsEditor.putBoolean(str1,true);
                    prefsEditor.putBoolean(str2,false);
                }
                prefsEditor.commit();
            }
        });
        mBtnVegDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vegdietenabled = mSharedPreferences.getBoolean(str2,false);
                if(!vegdietenabled.booleanValue()){
                    mBtnVegDiet.setTextColor(getResources().getColor(R.color.colorAccent));
                    mBtnStdDiet.setTextColor(getResources().getColor(R.color.colorPrimary));
                    scrollvegdietfood.setVisibility(View.VISIBLE);
                    scrollstddietfood.setVisibility(View.INVISIBLE);
                    prefsEditor.putBoolean(str1,false);
                    prefsEditor.putBoolean(str2,true);
                }
                prefsEditor.commit();
            }
        });
        completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                complete = mSharedPreferences.getBoolean(str0,false);

                if (!complete.booleanValue())
                {
                    completed.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.lightpink)));
                    prefsEditor.putBoolean(str0,true);
                }else{
                    completed.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    prefsEditor.putBoolean(str0,false);
                }
                prefsEditor.commit();

            }
        });
        if ((stddietenabled.booleanValue() == true) && (!vegdietenabled.booleanValue()))
        {
            mBtnStdDiet.setTextColor(getResources().getColor(R.color.colorAccent));
            mBtnVegDiet.setTextColor(getResources().getColor(R.color.colorPrimary));
            scrollstddietfood.setVisibility(0);
            scrollvegdietfood.setVisibility(8);
        }else{
            mBtnStdDiet.setTextColor(getResources().getColor(R.color.colorPrimary));
            mBtnVegDiet.setTextColor(getResources().getColor(R.color.colorAccent));
            scrollstddietfood.setVisibility(8);
            scrollvegdietfood.setVisibility(0);
        }
//        for (;;)
//        {
//            if ((!stddietenabled.booleanValue()) && (vegdietenabled.booleanValue() == true))
//            {
//                mBtnStdDiet.setTextColor(getResources().getColor(R.color.colorPrimary));
//                mBtnVegDiet.setTextColor(getResources().getColor(R.color.colorAccent));
//                scrollstddietfood.setVisibility(8);
//                scrollvegdietfood.setVisibility(0);
//            }
//            else
//            {
//                if ((stddietenabled.booleanValue()) || (vegdietenabled.booleanValue())) {
//                    break;
//                }
//                mBtnStdDiet.setTextColor(getResources().getColor(R.color.colorAccent));
//                mBtnVegDiet.setTextColor(getResources().getColor(R.color.colorPrimary));
//                scrollstddietfood.setVisibility(0);
//                scrollvegdietfood.setVisibility(8);
//                prefsEditor.putBoolean(str1, true);
//                prefsEditor.putBoolean(str2, false);
//                prefsEditor.commit();
//            }
//            return inflate;
//        }
        if (complete.booleanValue())
        {
            completed.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.lightpink)));
        }else{
            completed.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
        }
        return inflate;
    }
}
