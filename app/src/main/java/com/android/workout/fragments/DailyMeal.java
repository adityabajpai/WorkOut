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
    private static final String TAG = "DailyMeal";
    Context context;
    private Boolean vegdietenabled;
    private Boolean stddietenabled;
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
    private Boolean complete;
    private FloatingActionButton completed;

    public DailyMeal(){}

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getActivity();
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
        Toolbar toolbar  = (Toolbar)inflate.findViewById(R.id.toolbar);
        TextView titleHead = (TextView)inflate.findViewById(R.id.tittletext);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Day ");
        ((StringBuilder)localObject).append(getArguments().getInt("DAY"));
        titleHead.setText(((StringBuilder)localObject).toString());
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        setHasOptionsMenu(true);
        toolbar.getNavigationIcon().mutate().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        scrollstddietfood = ((ScrollView)inflate.findViewById(R.id.scrollstddietfood));
        scrollvegdietfood = ((ScrollView)inflate.findViewById(R.id.scrollvegdietfood));
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        prefsEditor = mSharedPreferences.edit();
//        paramLayoutInflater = new StringBuilder();
//        paramLayoutInflater.append("DAY_");
//        paramLayoutInflater.append(getArguments().getInt("DAY"));
//        paramLayoutInflater.append("_CHECKED");
//        localObject = paramLayoutInflater.toString();
//        paramLayoutInflater = new StringBuilder();
//        paramLayoutInflater.append("DAY_");
//        paramLayoutInflater.append(getArguments().getInt("DAY"));
//        paramLayoutInflater.append("_STDDIET");
//        final String str1 = paramLayoutInflater.toString();
//        paramLayoutInflater = new StringBuilder();
//        paramLayoutInflater.append("DAY_");
//        paramLayoutInflater.append(getArguments().getInt("DAY"));
//        paramLayoutInflater.append("_VEGDIET");
//        final String str2 = paramLayoutInflater.toString();
//        complete = Boolean.valueOf(mSharedPreferences.getBoolean((String)localObject, false));
//        stddietenabled = Boolean.valueOf(mSharedPreferences.getBoolean(str1, false));
//        vegdietenabled = Boolean.valueOf(mSharedPreferences.getBoolean(str2, false));
        completed = ((FloatingActionButton)inflate.findViewById(R.id.fab));
        mBtnStdDiet = ((Button)inflate.findViewById(R.id.Stddiet));
        mBtnVegDiet = ((Button)inflate.findViewById(R.id.vegdiet));
        mLayoutStdDiet = ((LinearLayout)inflate.findViewById(R.id.stddietfood));
        mLayoutVegDiet = ((LinearLayout)inflate.findViewById(R.id.vegdietfood));
//        paramLayoutInflater = (TextView)inflate.findViewById(2131361860);
        TextView localTextView1 = (TextView)inflate.findViewById(R.id.brkfast1);
        TextView localTextView2 = (TextView)inflate.findViewById(R.id.brkfast2);
//        TextView localTextView3 = (TextView)inflate.findViewById(2131362012);
//        TextView localTextView4 = (TextView)inflate.findViewById(2131362169);
//        TextView localTextView5 = (TextView)inflate.findViewById(2131362170);
//        TextView localTextView6 = (TextView)inflate.findViewById(2131362171);
//        TextView localTextView7 = (TextView)inflate.findViewById(2131361916);
//        TextView localTextView8 = (TextView)inflate.findViewById(2131361917);
//        TextView localTextView9 = (TextView)inflate.findViewById(2131361918);
//        TextView localTextView10 = (TextView)inflate.findViewById(2131362304);
//        TextView localTextView11 = (TextView)inflate.findViewById(2131362305);
//        TextView localTextView12 = (TextView)inflate.findViewById(2131362332);
//        TextView localTextView13 = (TextView)inflate.findViewById(2131362333);
//        TextView localTextView14 = (TextView)inflate.findViewById(2131362334);
//        TextView localTextView15 = (TextView)inflate.findViewById(2131362335);
//        TextView localTextView16 = (TextView)inflate.findViewById(2131362336);
//        TextView localTextView17 = (TextView)inflate.findViewById(2131362329);
//        TextView localTextView18 = (TextView)inflate.findViewById(2131362330);
//        paramViewGroup = (TextView)paramBundle.findViewById(2131362331);
        switch (getArguments().getInt("DAY"))
        {
            default:
                break;
            case 30:
//                paramLayoutInflater.setText(getResources().getString(2131755387));
                localTextView1.setText(getResources().getString(R.string.fivealmonds));
                localTextView2.setText(getResources().getString(R.string.Brownbread));
//                localTextView3.setText(getResources().getString(2131755011));
//                localTextView4.setText(getResources().getString(2131755327));
//                localTextView5.setText(getResources().getString(2131755013));
//                localTextView6.setText(getResources().getString(2131755220));
//                localTextView7.setText(getResources().getString(2131755016));
//                localTextView8.setText(getResources().getString(2131755038));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755387));
//                localTextView11.setText(getResources().getString(2131755034));
//                localTextView12.setText(getResources().getString(2131755060));
//                localTextView13.setText(getResources().getString(2131755011));
//                localTextView14.setText(getResources().getString(2131755327));
//                localTextView15.setText(getResources().getString(2131755013));
//                localTextView16.setText(getResources().getString(2131755245));
//                localTextView17.setText(getResources().getString(2131755278));
//                localTextView18.setText(getResources().getString(2131755037));
                break;
            case 29:
//                paramLayoutInflater.setText(getResources().getString(2131755328));
                localTextView1.setText(getResources().getString(R.string.fivealmonds));
                localTextView2.setText(getResources().getString(R.string.Brownbread));
//                localTextView3.setText(getResources().getString(2131755051));
//                localTextView4.setText(getResources().getString(2131755325));
//                localTextView5.setText(getResources().getString(2131755247));
//                localTextView6.setText(getResources().getString(2131755217));
//                localTextView7.setText(getResources().getString(2131755382));
//                localTextView8.setText(getResources().getString(2131755023));
//                localTextView9.setText(getResources().getString(2131755259));
//                localTextView10.setText(getResources().getString(2131755328));
//                localTextView11.setText(getResources().getString(2131755017));
//                localTextView12.setText(getResources().getString(2131755059));
//                localTextView13.setText(getResources().getString(2131755051));
//                localTextView14.setText(getResources().getString(2131755325));
//                localTextView15.setText(getResources().getString(2131755247));
//                localTextView16.setText(getResources().getString(2131755217));
//                localTextView17.setText(getResources().getString(2131755049));
//                localTextView18.setText(getResources().getString(2131755023));
//                paramLayoutInflater = getResources().getString(2131755259);
//                break;
            case 28:
//                paramLayoutInflater.setText(getResources().getString(2131755408));
                localTextView1.setText(getResources().getString(R.string.fivealmonds));
                localTextView2.setText(getResources().getString(R.string.Brownbread));
//                localTextView3.setText(getResources().getString(2131755051));
//                localTextView4.setText(getResources().getString(2131755325));
//                localTextView5.setText(getResources().getString(2131755248));
//                localTextView6.setText(getResources().getString(2131755217));
//                localTextView7.setText(getResources().getString(2131755382));
//                localTextView8.setText(getResources().getString(2131755011));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755408));
//                localTextView11.setText(getResources().getString(2131755034));
//                localTextView12.setText(getResources().getString(2131755041));
//                localTextView13.setText(getResources().getString(2131755051));
//                localTextView14.setText(getResources().getString(2131755327));
//                localTextView15.setText(getResources().getString(2131755248));
//                localTextView16.setText(getResources().getString(2131755217));
//                localTextView17.setText(getResources().getString(2131755052));
//                localTextView18.setText(getResources().getString(2131755024));
//                break;
//            case 27:
//                paramLayoutInflater.setText(getResources().getString(2131755328));
//                localTextView1.setText(getResources().getString(2131755017));
//                localTextView2.setText(getResources().getString(2131755058));
//                localTextView3.setText(getResources().getString(2131755011));
//                localTextView4.setText(getResources().getString(2131755326));
//                localTextView5.setText(getResources().getString(2131755013));
//                localTextView6.setText(getResources().getString(2131755220));
//                localTextView7.setText(getResources().getString(2131755016));
//                localTextView8.setText(getResources().getString(2131755386));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755328));
//                localTextView11.setText(getResources().getString(2131755017));
//                localTextView12.setText(getResources().getString(2131755060));
//                localTextView13.setText(getResources().getString(2131755011));
//                localTextView14.setText(getResources().getString(2131755326));
//                localTextView15.setText(getResources().getString(2131755013));
//                localTextView16.setText(getResources().getString(2131755245));
//                localTextView17.setText(getResources().getString(2131755278));
//                localTextView18.setText(getResources().getString(2131755037));
//                break;
//            case 26:
//                paramLayoutInflater.setText(getResources().getString(2131755387));
//                localTextView1.setText(getResources().getString(2131755034));
//                localTextView2.setText(getResources().getString(2131755055));
//                localTextView3.setText(getResources().getString(2131755051));
//                localTextView4.setText(getResources().getString(2131755325));
//                localTextView5.setText(getResources().getString(2131755247));
//                localTextView6.setText(getResources().getString(2131755217));
//                localTextView7.setText(getResources().getString(2131755382));
//                localTextView8.setText(getResources().getString(2131755023));
//                localTextView9.setText(getResources().getString(2131755259));
//                localTextView10.setText(getResources().getString(2131755408));
//                localTextView11.setText(getResources().getString(2131755034));
//                localTextView12.setText(getResources().getString(2131755059));
//                localTextView13.setText(getResources().getString(2131755051));
//                localTextView14.setText(getResources().getString(2131755325));
//                localTextView15.setText(getResources().getString(2131755247));
//                localTextView16.setText(getResources().getString(2131755217));
//                localTextView17.setText(getResources().getString(2131755049));
//                localTextView18.setText(getResources().getString(2131755023));
//                break;
//            case 25:
//                paramLayoutInflater.setText(getResources().getString(2131755409));
//                localTextView1.setText(getResources().getString(2131755017));
//                localTextView2.setText(getResources().getString(2131755058));
//                localTextView3.setText(getResources().getString(2131755011));
//                localTextView4.setText(getResources().getString(2131755327));
//                localTextView5.setText(getResources().getString(2131755013));
//                localTextView6.setText(getResources().getString(2131755245));
//                localTextView7.setText(getResources().getString(2131755052));
//                localTextView8.setText(getResources().getString(2131755015));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755409));
//                localTextView11.setText(getResources().getString(2131755017));
//                localTextView12.setText(getResources().getString(2131755041));
//                localTextView13.setText(getResources().getString(2131755011));
//                localTextView14.setText(getResources().getString(2131755327));
//                localTextView15.setText(getResources().getString(2131755013));
//                localTextView16.setText(getResources().getString(2131755245));
//                localTextView17.setText(getResources().getString(2131755052));
//                localTextView18.setText(getResources().getString(2131755024));
//                paramLayoutInflater = getResources().getString(2131755259);
//                break;
//            case 24:
//                paramLayoutInflater.setText(getResources().getString(2131755387));
//                localTextView1.setText(getResources().getString(2131755034));
//                localTextView2.setText(getResources().getString(2131755044));
//                localTextView3.setText(getResources().getString(2131755011));
//                localTextView4.setText(getResources().getString(2131755326));
//                localTextView5.setText(getResources().getString(2131755248));
//                localTextView6.setText(getResources().getString(2131755217));
//                localTextView7.setText(getResources().getString(2131755048));
//                localTextView8.setText(getResources().getString(2131755011));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755408));
//                localTextView11.setText(getResources().getString(2131755034));
//                localTextView12.setText(getResources().getString(2131755060));
//                localTextView13.setText(getResources().getString(2131755011));
//                localTextView14.setText(getResources().getString(2131755326));
//                localTextView15.setText(getResources().getString(2131755248));
//                localTextView16.setText(getResources().getString(2131755217));
//                localTextView17.setText(getResources().getString(2131755278));
//                localTextView18.setText(getResources().getString(2131755037));
//                break;
//            case 23:
//                paramLayoutInflater.setText(getResources().getString(2131755328));
//                localTextView1.setText(getResources().getString(2131755017));
//                localTextView2.setText(getResources().getString(2131755057));
//                localTextView3.setText(getResources().getString(2131755051));
//                localTextView4.setText(getResources().getString(2131755327));
//                localTextView5.setText(getResources().getString(2131755013));
//                localTextView6.setText(getResources().getString(2131755220));
//                localTextView7.setText(getResources().getString(2131755016));
//                localTextView8.setText(getResources().getString(2131755386));
//                localTextView9.setText(getResources().getString(2131755259));
//                localTextView10.setText(getResources().getString(2131755328));
//                localTextView11.setText(getResources().getString(2131755017));
//                localTextView12.setText(getResources().getString(2131755057));
//                localTextView13.setText(getResources().getString(2131755051));
//                localTextView14.setText(getResources().getString(2131755327));
//                localTextView15.setText(getResources().getString(2131755013));
//                localTextView16.setText(getResources().getString(2131755245));
//                localTextView17.setText(getResources().getString(2131755049));
//                localTextView18.setText(getResources().getString(2131755023));
//                paramLayoutInflater = getResources().getString(2131755259);
//                break;
//            case 22:
//                paramLayoutInflater.setText(getResources().getString(2131755246));
//                localTextView1.setText(getResources().getString(2131755034));
//                localTextView2.setText(getResources().getString(2131755056));
//                localTextView3.setText(getResources().getString(2131755051));
//                localTextView4.setText(getResources().getString(2131755325));
//                localTextView5.setText(getResources().getString(2131755218));
//                localTextView6.setText(getResources().getString(2131755217));
//                localTextView7.setText(getResources().getString(2131755382));
//                localTextView8.setText(getResources().getString(2131755023));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755408));
//                localTextView11.setText(getResources().getString(2131755034));
//                localTextView12.setText(getResources().getString(2131755040));
//                localTextView13.setText(getResources().getString(2131755051));
//                localTextView14.setText(getResources().getString(2131755325));
//                localTextView15.setText(getResources().getString(2131755218));
//                localTextView16.setText(getResources().getString(2131755217));
//                localTextView17.setText(getResources().getString(2131755052));
//                localTextView18.setText(getResources().getString(2131755024));
//                break;
//            case 21:
//                paramLayoutInflater.setText(getResources().getString(2131755409));
//                localTextView1.setText(getResources().getString(2131755017));
//                localTextView2.setText(getResources().getString(2131755043));
//                localTextView3.setText(getResources().getString(2131755051));
//                localTextView4.setText(getResources().getString(2131755326));
//                localTextView5.setText(getResources().getString(2131755388));
//                localTextView6.setText(getResources().getString(2131755371));
//                localTextView7.setText(getResources().getString(2131755048));
//                localTextView8.setText(getResources().getString(2131755011));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755409));
//                localTextView11.setText(getResources().getString(2131755017));
//                localTextView12.setText(getResources().getString(2131755060));
//                localTextView13.setText(getResources().getString(2131755051));
//                localTextView14.setText(getResources().getString(2131755326));
//                localTextView15.setText(getResources().getString(2131755388));
//                localTextView16.setText(getResources().getString(2131755217));
//                localTextView17.setText(getResources().getString(2131755278));
//                localTextView18.setText(getResources().getString(2131755037));
//                paramLayoutInflater = getResources().getString(2131755259);
//                break;
//            case 20:
//                paramLayoutInflater.setText(getResources().getString(2131755387));
//                localTextView1.setText(getResources().getString(2131755034));
//                localTextView2.setText(getResources().getString(2131755058));
//                localTextView3.setText(getResources().getString(2131755011));
//                localTextView4.setText(getResources().getString(2131755327));
//                localTextView5.setText(getResources().getString(2131755013));
//                localTextView6.setText(getResources().getString(2131755245));
//                localTextView7.setText(getResources().getString(2131755016));
//                localTextView8.setText(getResources().getString(2131755386));
//                localTextView9.setText(getResources().getString(2131755259));
//                localTextView10.setText(getResources().getString(2131755387));
//                localTextView11.setText(getResources().getString(2131755034));
//                localTextView12.setText(getResources().getString(2131755057));
//                localTextView13.setText(getResources().getString(2131755011));
//                localTextView14.setText(getResources().getString(2131755325));
//                localTextView15.setText(getResources().getString(2131755013));
//                localTextView16.setText(getResources().getString(2131755245));
//                localTextView17.setText(getResources().getString(2131755049));
//                localTextView18.setText(getResources().getString(2131755023));
//                break;
//            case 19:
//                paramLayoutInflater.setText(getResources().getString(2131755328));
//                localTextView1.setText(getResources().getString(2131755017));
//                localTextView2.setText(getResources().getString(2131755056));
//                localTextView3.setText(getResources().getString(2131755051));
//                localTextView4.setText(getResources().getString(2131755326));
//                localTextView5.setText(getResources().getString(2131755247));
//                localTextView6.setText(getResources().getString(2131755371));
//                localTextView7.setText(getResources().getString(2131755382));
//                localTextView8.setText(getResources().getString(2131755023));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755328));
//                localTextView11.setText(getResources().getString(2131755017));
//                localTextView12.setText(getResources().getString(2131755041));
//                localTextView13.setText(getResources().getString(2131755051));
//                localTextView14.setText(getResources().getString(2131755325));
//                localTextView15.setText(getResources().getString(2131755247));
//                localTextView16.setText(getResources().getString(2131755217));
//                localTextView17.setText(getResources().getString(2131755052));
//                localTextView18.setText(getResources().getString(2131755024));
//                paramLayoutInflater = getResources().getString(2131755259);
//                break;
//            case 18:
//                paramLayoutInflater.setText(getResources().getString(2131755408));
//                localTextView1.setText(getResources().getString(2131755034));
//                localTextView2.setText(getResources().getString(2131755058));
//                localTextView3.setText(getResources().getString(2131755011));
//                localTextView4.setText(getResources().getString(2131755327));
//                localTextView5.setText(getResources().getString(2131755013));
//                localTextView6.setText(getResources().getString(2131755245));
//                localTextView7.setText(getResources().getString(2131755052));
//                localTextView8.setText(getResources().getString(2131755015));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755387));
//                localTextView11.setText(getResources().getString(2131755034));
//                localTextView12.setText(getResources().getString(2131755060));
//                localTextView13.setText(getResources().getString(2131755011));
//                localTextView14.setText(getResources().getString(2131755327));
//                localTextView15.setText(getResources().getString(2131755013));
//                localTextView16.setText(getResources().getString(2131755245));
//                localTextView17.setText(getResources().getString(2131755278));
//                localTextView18.setText(getResources().getString(2131755037));
//                paramLayoutInflater = getResources().getString(2131755259);
//                break;
//            case 17:
//                paramLayoutInflater.setText(getResources().getString(2131755409));
//                localTextView1.setText(getResources().getString(2131755017));
//                localTextView2.setText(getResources().getString(2131755044));
//                localTextView3.setText(getResources().getString(2131755051));
//                localTextView4.setText(getResources().getString(2131755326));
//                localTextView5.setText(getResources().getString(2131755248));
//                localTextView6.setText(getResources().getString(2131755217));
//                localTextView7.setText(getResources().getString(2131755048));
//                localTextView8.setText(getResources().getString(2131755011));
//                localTextView9.setText(getResources().getString(2131755259));
//                localTextView10.setText(getResources().getString(2131755409));
//                localTextView11.setText(getResources().getString(2131755017));
//                localTextView12.setText(getResources().getString(2131755040));
//                localTextView13.setText(getResources().getString(2131755051));
//                localTextView14.setText(getResources().getString(2131755326));
//                localTextView15.setText(getResources().getString(2131755248));
//                localTextView16.setText(getResources().getString(2131755217));
//                localTextView17.setText(getResources().getString(2131755049));
//                localTextView18.setText(getResources().getString(2131755023));
//                paramLayoutInflater = getResources().getString(2131755259);
//                break;
//            case 16:
//                paramLayoutInflater.setText(getResources().getString(2131755408));
//                localTextView1.setText(getResources().getString(2131755034));
//                localTextView2.setText(getResources().getString(2131755058));
//                localTextView3.setText(getResources().getString(2131755011));
//                localTextView4.setText(getResources().getString(2131755327));
//                localTextView5.setText(getResources().getString(2131755013));
//                localTextView6.setText(getResources().getString(2131755245));
//                localTextView7.setText(getResources().getString(2131755016));
//                localTextView8.setText(getResources().getString(2131755038));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755387));
//                localTextView11.setText(getResources().getString(2131755034));
//                localTextView12.setText(getResources().getString(2131755057));
//                localTextView13.setText(getResources().getString(2131755011));
//                localTextView14.setText(getResources().getString(2131755327));
//                localTextView15.setText(getResources().getString(2131755013));
//                localTextView16.setText(getResources().getString(2131755245));
//                localTextView17.setText(getResources().getString(2131755052));
//                localTextView18.setText(getResources().getString(2131755024));
//                break;
//            case 15:
//                paramLayoutInflater.setText(getResources().getString(2131755328));
//                localTextView1.setText(getResources().getString(2131755017));
//                localTextView2.setText(getResources().getString(2131755055));
//                localTextView3.setText(getResources().getString(2131755051));
//                localTextView4.setText(getResources().getString(2131755325));
//                localTextView5.setText(getResources().getString(2131755247));
//                localTextView6.setText(getResources().getString(2131755371));
//                localTextView7.setText(getResources().getString(2131755382));
//                localTextView8.setText(getResources().getString(2131755023));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755328));
//                localTextView11.setText(getResources().getString(2131755017));
//                localTextView12.setText(getResources().getString(2131755060));
//                localTextView13.setText(getResources().getString(2131755051));
//                localTextView14.setText(getResources().getString(2131755326));
//                localTextView15.setText(getResources().getString(2131755247));
//                localTextView16.setText(getResources().getString(2131755217));
//                localTextView17.setText(getResources().getString(2131755278));
//                localTextView18.setText(getResources().getString(2131755037));
//                paramLayoutInflater = getResources().getString(2131755259);
//                break;
//            case 14:
//                paramLayoutInflater.setText(getResources().getString(2131755408));
//                localTextView1.setText(getResources().getString(2131755034));
//                localTextView2.setText(getResources().getString(2131755043));
//                localTextView3.setText(getResources().getString(2131755051));
//                localTextView4.setText(getResources().getString(2131755327));
//                localTextView5.setText(getResources().getString(2131755248));
//                localTextView6.setText(getResources().getString(2131755217));
//                localTextView7.setText(getResources().getString(2131755048));
//                localTextView8.setText(getResources().getString(2131755011));
//                localTextView9.setText(getResources().getString(2131755259));
//                localTextView10.setText(getResources().getString(2131755408));
//                localTextView11.setText(getResources().getString(2131755034));
//                localTextView12.setText(getResources().getString(2131755041));
//                localTextView13.setText(getResources().getString(2131755051));
//                localTextView14.setText(getResources().getString(2131755327));
//                localTextView15.setText(getResources().getString(2131755248));
//                localTextView16.setText(getResources().getString(2131755217));
//                localTextView17.setText(getResources().getString(2131755049));
//                localTextView18.setText(getResources().getString(2131755023));
//                break;
//            case 13:
//                paramLayoutInflater.setText(getResources().getString(2131755387));
//                localTextView1.setText(getResources().getString(2131755017));
//                localTextView2.setText(getResources().getString(2131755056));
//                localTextView3.setText(getResources().getString(2131755011));
//                localTextView4.setText(getResources().getString(2131755326));
//                localTextView5.setText(getResources().getString(2131755013));
//                localTextView6.setText(getResources().getString(2131755374));
//                localTextView7.setText(getResources().getString(2131755016));
//                localTextView8.setText(getResources().getString(2131755386));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755387));
//                localTextView11.setText(getResources().getString(2131755017));
//                localTextView12.setText(getResources().getString(2131755059));
//                localTextView13.setText(getResources().getString(2131755011));
//                localTextView14.setText(getResources().getString(2131755326));
//                localTextView15.setText(getResources().getString(2131755013));
//                localTextView16.setText(getResources().getString(2131755245));
//                localTextView17.setText(getResources().getString(2131755052));
//                localTextView18.setText(getResources().getString(2131755024));
//                paramLayoutInflater = getResources().getString(2131755259);
//                break;
//            case 12:
//                paramLayoutInflater.setText(getResources().getString(2131755409));
//                localTextView1.setText(getResources().getString(2131755034));
//                localTextView2.setText(getResources().getString(2131755044));
//                localTextView3.setText(getResources().getString(2131755051));
//                localTextView4.setText(getResources().getString(2131755325));
//                localTextView5.setText(getResources().getString(2131755247));
//                localTextView6.setText(getResources().getString(2131755217));
//                localTextView7.setText(getResources().getString(2131755382));
//                localTextView8.setText(getResources().getString(2131755023));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755409));
//                localTextView11.setText(getResources().getString(2131755034));
//                localTextView12.setText(getResources().getString(2131755040));
//                localTextView13.setText(getResources().getString(2131755051));
//                localTextView14.setText(getResources().getString(2131755325));
//                localTextView15.setText(getResources().getString(2131755247));
//                localTextView16.setText(getResources().getString(2131755217));
//                localTextView17.setText(getResources().getString(2131755278));
//                localTextView18.setText(getResources().getString(2131755037));
//                break;
//            case 11:
//                paramLayoutInflater.setText(getResources().getString(2131755387));
//                localTextView1.setText(getResources().getString(2131755017));
//                localTextView2.setText(getResources().getString(2131755059));
//                localTextView3.setText(getResources().getString(2131755011));
//                localTextView4.setText(getResources().getString(2131755327));
//                localTextView5.setText(getResources().getString(2131755013));
//                localTextView6.setText(getResources().getString(2131755374));
//                localTextView7.setText(getResources().getString(2131755052));
//                localTextView8.setText(getResources().getString(2131755015));
//                localTextView9.setText(getResources().getString(2131755259));
//                localTextView10.setText(getResources().getString(2131755387));
//                localTextView11.setText(getResources().getString(2131755017));
//                localTextView12.setText(getResources().getString(2131755060));
//                localTextView13.setText(getResources().getString(2131755011));
//                localTextView14.setText(getResources().getString(2131755327));
//                localTextView15.setText(getResources().getString(2131755013));
//                localTextView16.setText(getResources().getString(2131755245));
//                localTextView17.setText(getResources().getString(2131755049));
//                localTextView18.setText(getResources().getString(2131755023));
//                paramLayoutInflater = getResources().getString(2131755259);
//                break;
//            case 10:
//                paramLayoutInflater.setText(getResources().getString(2131755328));
//                localTextView1.setText(getResources().getString(2131755034));
//                localTextView2.setText(getResources().getString(2131755055));
//                localTextView3.setText(getResources().getString(2131755011));
//                localTextView4.setText(getResources().getString(2131755325));
//                localTextView5.setText(getResources().getString(2131755248));
//                localTextView6.setText(getResources().getString(2131755217));
//                localTextView7.setText(getResources().getString(2131755048));
//                localTextView8.setText(getResources().getString(2131755011));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755328));
//                localTextView11.setText(getResources().getString(2131755034));
//                localTextView12.setText(getResources().getString(2131755059));
//                localTextView13.setText(getResources().getString(2131755011));
//                localTextView14.setText(getResources().getString(2131755325));
//                localTextView15.setText(getResources().getString(2131755248));
//                localTextView16.setText(getResources().getString(2131755371));
//                localTextView17.setText(getResources().getString(2131755052));
//                localTextView18.setText(getResources().getString(2131755024));
//                break;
//            case 9:
//                paramLayoutInflater.setText(getResources().getString(2131755387));
//                localTextView1.setText(getResources().getString(2131755017));
//                localTextView2.setText(getResources().getString(2131755058));
//                localTextView3.setText(getResources().getString(2131755051));
//                localTextView4.setText(getResources().getString(2131755327));
//                localTextView5.setText(getResources().getString(2131755013));
//                localTextView6.setText(getResources().getString(2131755245));
//                localTextView7.setText(getResources().getString(2131755016));
//                localTextView8.setText(getResources().getString(2131755386));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755387));
//                localTextView11.setText(getResources().getString(2131755017));
//                localTextView12.setText(getResources().getString(2131755057));
//                localTextView13.setText(getResources().getString(2131755051));
//                localTextView14.setText(getResources().getString(2131755326));
//                localTextView15.setText(getResources().getString(2131755013));
//                localTextView16.setText(getResources().getString(2131755220));
//                localTextView17.setText(getResources().getString(2131755278));
//                localTextView18.setText(getResources().getString(2131755037));
//                paramLayoutInflater = getResources().getString(2131755259);
//                break;
//            case 8:
//                paramLayoutInflater.setText(getResources().getString(2131755409));
//                localTextView1.setText(getResources().getString(2131755034));
//                localTextView2.setText(getResources().getString(2131755042));
//                localTextView3.setText(getResources().getString(2131755051));
//                localTextView4.setText(getResources().getString(2131755325));
//                localTextView5.setText(getResources().getString(2131755218));
//                localTextView6.setText(getResources().getString(2131755371));
//                localTextView7.setText(getResources().getString(2131755382));
//                localTextView8.setText(getResources().getString(2131755023));
//                localTextView9.setText(getResources().getString(2131755259));
//                localTextView10.setText(getResources().getString(2131755409));
//                localTextView11.setText(getResources().getString(2131755034));
//                localTextView12.setText(getResources().getString(2131755060));
//                localTextView13.setText(getResources().getString(2131755051));
//                localTextView14.setText(getResources().getString(2131755325));
//                localTextView15.setText(getResources().getString(2131755218));
//                localTextView16.setText(getResources().getString(2131755371));
//                localTextView17.setText(getResources().getString(2131755049));
//                localTextView18.setText(getResources().getString(2131755023));
//                break;
//            case 7:
//                paramLayoutInflater.setText(getResources().getString(2131755408));
//                localTextView1.setText(getResources().getString(2131755017));
//                localTextView2.setText(getResources().getString(2131755056));
//                localTextView3.setText(getResources().getString(2131755051));
//                localTextView4.setText(getResources().getString(2131755326));
//                localTextView5.setText(getResources().getString(2131755388));
//                localTextView6.setText(getResources().getString(2131755217));
//                localTextView7.setText(getResources().getString(2131755048));
//                localTextView8.setText(getResources().getString(2131755011));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755408));
//                localTextView11.setText(getResources().getString(2131755017));
//                localTextView12.setText(getResources().getString(2131755041));
//                localTextView13.setText(getResources().getString(2131755051));
//                localTextView14.setText(getResources().getString(2131755326));
//                localTextView15.setText(getResources().getString(2131755388));
//                localTextView16.setText(getResources().getString(2131755217));
//                localTextView17.setText(getResources().getString(2131755052));
//                localTextView18.setText(getResources().getString(2131755024));
//                paramLayoutInflater = getResources().getString(2131755259);
//                break;
//            case 6:
//                paramLayoutInflater.setText(getResources().getString(2131755328));
//                localTextView1.setText(getResources().getString(2131755034));
//                localTextView2.setText(getResources().getString(2131755057));
//                localTextView3.setText(getResources().getString(2131755011));
//                localTextView4.setText(getResources().getString(2131755327));
//                localTextView5.setText(getResources().getString(2131755013));
//                localTextView6.setText(getResources().getString(2131755245));
//                localTextView7.setText(getResources().getString(2131755016));
//                localTextView8.setText(getResources().getString(2131755386));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755328));
//                localTextView11.setText(getResources().getString(2131755034));
//                localTextView12.setText(getResources().getString(2131755057));
//                localTextView13.setText(getResources().getString(2131755011));
//                localTextView14.setText(getResources().getString(2131755327));
//                localTextView15.setText(getResources().getString(2131755013));
//                localTextView16.setText(getResources().getString(2131755245));
//                localTextView17.setText(getResources().getString(2131755278));
//                localTextView18.setText(getResources().getString(2131755037));
//                break;
//            case 5:
//                paramLayoutInflater.setText(getResources().getString(2131755408));
//                localTextView1.setText(getResources().getString(2131755017));
//                localTextView2.setText(getResources().getString(2131755044));
//                localTextView3.setText(getResources().getString(2131755051));
//                localTextView4.setText(getResources().getString(2131755325));
//                localTextView5.setText(getResources().getString(2131755247));
//                localTextView6.setText(getResources().getString(2131755217));
//                localTextView7.setText(getResources().getString(2131755382));
//                localTextView8.setText(getResources().getString(2131755023));
//                localTextView9.setText(getResources().getString(2131755259));
//                localTextView10.setText(getResources().getString(2131755408));
//                localTextView11.setText(getResources().getString(2131755017));
//                localTextView12.setText(getResources().getString(2131755040));
//                localTextView13.setText(getResources().getString(2131755051));
//                localTextView14.setText(getResources().getString(2131755325));
//                localTextView15.setText(getResources().getString(2131755247));
//                localTextView16.setText(getResources().getString(2131755217));
//                localTextView17.setText(getResources().getString(2131755049));
//                localTextView18.setText(getResources().getString(2131755023));
//                break;
//            case 4:
//                paramLayoutInflater.setText(getResources().getString(2131755409));
//                localTextView1.setText(getResources().getString(2131755034));
//                localTextView2.setText(getResources().getString(2131755058));
//                localTextView3.setText(getResources().getString(2131755011));
//                localTextView4.setText(getResources().getString(2131755327));
//                localTextView5.setText(getResources().getString(2131755013));
//                localTextView6.setText(getResources().getString(2131755245));
//                localTextView7.setText(getResources().getString(2131755052));
//                localTextView8.setText(getResources().getString(2131755015));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755409));
//                localTextView11.setText(getResources().getString(2131755034));
//                localTextView12.setText(getResources().getString(2131755057));
//                localTextView13.setText(getResources().getString(2131755011));
//                localTextView14.setText(getResources().getString(2131755327));
//                localTextView15.setText(getResources().getString(2131755013));
//                localTextView16.setText(getResources().getString(2131755245));
//                localTextView17.setText(getResources().getString(2131755052));
//                localTextView18.setText(getResources().getString(2131755024));
//                break;
//            case 3:
//                paramLayoutInflater.setText(getResources().getString(2131755408));
//                localTextView1.setText(getResources().getString(2131755017));
//                localTextView2.setText(getResources().getString(2131755055));
//                localTextView3.setText(getResources().getString(2131755051));
//                localTextView4.setText(getResources().getString(2131755326));
//                localTextView5.setText(getResources().getString(2131755248));
//                localTextView6.setText(getResources().getString(2131755217));
//                localTextView7.setText(getResources().getString(2131755048));
//                localTextView8.setText(getResources().getString(2131755011));
//                localTextView9.setText(getResources().getString(2131755259));
//                localTextView10.setText(getResources().getString(2131755408));
//                localTextView11.setText(getResources().getString(2131755017));
//                localTextView12.setText(getResources().getString(2131755060));
//                localTextView13.setText(getResources().getString(2131755051));
//                localTextView14.setText(getResources().getString(2131755326));
//                localTextView15.setText(getResources().getString(2131755248));
//                localTextView16.setText(getResources().getString(2131755217));
//                localTextView17.setText(getResources().getString(2131755278));
//                localTextView18.setText(getResources().getString(2131755037));
//                paramLayoutInflater = getResources().getString(2131755259);
//                paramViewGroup.setText(paramLayoutInflater);
//                break;
//            case 2:
//                paramLayoutInflater.setText(getResources().getString(2131755328));
//                localTextView1.setText(getResources().getString(2131755034));
//                localTextView2.setText(getResources().getString(2131755059));
//                localTextView3.setText(getResources().getString(2131755011));
//                localTextView4.setText(getResources().getString(2131755327));
//                localTextView5.setText(getResources().getString(2131755013));
//                localTextView6.setText(getResources().getString(2131755245));
//                localTextView7.setText(getResources().getString(2131755016));
//                localTextView8.setText(getResources().getString(2131755038));
//                localTextView9.setVisibility(8);
//                localTextView10.setText(getResources().getString(2131755328));
//                localTextView11.setText(getResources().getString(2131755034));
//                localTextView12.setText(getResources().getString(2131755059));
//                localTextView13.setText(getResources().getString(2131755011));
//                localTextView14.setText(getResources().getString(2131755327));
//                localTextView15.setText(getResources().getString(2131755013));
//                localTextView16.setText(getResources().getString(2131755245));
//                localTextView17.setText(getResources().getString(2131755049));
//                localTextView18.setText(getResources().getString(2131755023));
//                paramViewGroup.setVisibility(8);
//                break;
        }
//        paramLayoutInflater.setText(getResources().getString(2131755408));
        localTextView1.setText(getResources().getString(R.string.fivealmonds));
        localTextView2.setText(getResources().getString(R.string.Brownbread));
//        localTextView3.setText(getResources().getString(2131755051));
//        localTextView4.setText(getResources().getString(2131755325));
//        localTextView5.setText(getResources().getString(2131755247));
//        localTextView6.setText(getResources().getString(2131755217));
//        localTextView7.setText(getResources().getString(2131755382));
//        localTextView8.setText(getResources().getString(2131755023));
//        localTextView9.setVisibility(8);
//        localTextView10.setText(getResources().getString(2131755408));
//        localTextView11.setText(getResources().getString(2131755017));
//        localTextView12.setText(getResources().getString(2131755041));
//        localTextView13.setText(getResources().getString(2131755051));
//        localTextView14.setText(getResources().getString(2131755325));
//        localTextView15.setText(getResources().getString(2131755247));
//        localTextView16.setText(getResources().getString(2131755217));
//        localTextView17.setText(getResources().getString(2131755052));
//        localTextView18.setText(getResources().getString(2131755024));
//        paramViewGroup.setText(getResources().getString(2131755259));
//        mBtnStdDiet.setOnClickListener(new View.OnClickListener()
//        {
//            public void onClick(View paramAnonymousView)
//            {
//                DailyMeal.access$getDisplayError(DailyMeal.this, Boolean.valueOf(DailyMeal.access$getMSharedPreferences(DailyMeal.this).getBoolean(str1, false)));
//                if (!DailyMeal.createLink(DailyMeal.this).booleanValue())
//                {
//                    DailyMeal.access$getDeleteButton(DailyMeal.this).setTextColor(getResources().getColor(2131099698));
//                    DailyMeal.access$getStopButton(DailyMeal.this).setVisibility(0);
//                    DailyMeal.access$getColorButton(DailyMeal.this).setTextColor(getResources().getColor(2131099679));
//                    DailyMeal.access$getMRootView(DailyMeal.this).setVisibility(8);
//                    DailyMeal.access$getEditor(DailyMeal.this).putBoolean(str1, true);
//                    DailyMeal.access$getEditor(DailyMeal.this).putBoolean(str2, false);
//                }
//                DailyMeal.access$getEditor(DailyMeal.this).commit();
//                if (DailyMeal.access$getTabsContainer(DailyMeal.this) == null)
//                {
//                    DailyMeal.display(DailyMeal.this, (LinearLayout)paramBundle.findViewById(2131362190));
//                    DailyMeal.access$getTabsContainer(DailyMeal.this).setBackgroundResource(0);
//                }
//            }
//        });
//        mBtnVegDiet.setOnClickListener(new View.OnClickListener()
//        {
//            public void onClick(View paramAnonymousView)
//            {
//                DailyMeal.access$setAlive(DailyMeal.this, Boolean.valueOf(DailyMeal.access$getMSharedPreferences(DailyMeal.this).getBoolean(str2, false)));
//                if (!DailyMeal.access$getMLocked(DailyMeal.this).booleanValue())
//                {
//                    DailyMeal.access$getColorButton(DailyMeal.this).setTextColor(getResources().getColor(2131099698));
//                    DailyMeal.access$getMRootView(DailyMeal.this).setVisibility(0);
//                    DailyMeal.access$getDeleteButton(DailyMeal.this).setTextColor(getResources().getColor(2131099679));
//                    DailyMeal.access$getStopButton(DailyMeal.this).setVisibility(8);
//                    DailyMeal.access$getEditor(DailyMeal.this).putBoolean(str2, true);
//                    DailyMeal.access$getEditor(DailyMeal.this).putBoolean(str1, false);
//                }
//                DailyMeal.access$getEditor(DailyMeal.this).commit();
//                if (DailyMeal.addNote(DailyMeal.this) == null)
//                {
//                    DailyMeal.addTag(DailyMeal.this, (LinearLayout)paramBundle.findViewById(2131362307));
//                    DailyMeal.addNote(DailyMeal.this).setBackgroundResource(0);
//                }
//            }
//        });
//        if (complete.booleanValue())
//        {
//            if (Build.VERSION.SDK_INT >= 21) {
//                paramViewGroup = completed;
//            }
//            for (paramLayoutInflater = getResources().getDrawable(2131230985, getActivity().getTheme());; paramLayoutInflater = getResources().getDrawable(2131230985))
//            {
//                paramViewGroup.setImageDrawable(paramLayoutInflater);
//                break;
//                paramViewGroup = completed;
//            }
//            paramViewGroup = completed;
//            paramLayoutInflater = getResources();
//        }
//        for (int i = 2131099698;; i = 2131099736)
//        {
//            paramViewGroup.setBackgroundTintList(ColorStateList.valueOf(paramLayoutInflater.getColor(i)));
//            break;
//            if (Build.VERSION.SDK_INT >= 21) {
//                paramViewGroup = completed;
//            }
//            for (paramLayoutInflater = getResources().getDrawable(2131230985, getActivity().getTheme());;
//                 paramLayoutInflater = getResources().getDrawable(2131230985))
//            {
//                paramViewGroup.setImageDrawable(paramLayoutInflater);
//                break;
//                paramViewGroup = completed;
//            }
//            paramViewGroup = completed;
//            paramLayoutInflater = getResources();
//        }
//        completed.setOnClickListener(new View.OnClickListener()
//        {
//            public void onClick(View paramAnonymousView)
//            {
//                DailyMeal.access$setB(DailyMeal.this, Boolean.valueOf(DailyMeal.access$getMSharedPreferences(DailyMeal.this).getBoolean(val$tag, false)));
//                Object localObject1;
//                Object localObject2;
//                if (DailyMeal.access$getTip(DailyMeal.this).booleanValue())
//                {
//                    DailyMeal.access$getEditor(DailyMeal.this).putBoolean(val$tag, false);
//                    if (Build.VERSION.SDK_INT >= 21) {
//                        localObject1 = DailyMeal.access$getFab(DailyMeal.this);
//                    }
//                    for (localObject2 = getResources().getDrawable(2131230985, getActivity().getTheme());; localObject2 = getResources().getDrawable(2131230985))
//                    {
//                        paramAnonymousView = this;
//                        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
//                        break;
//                        localObject1 = DailyMeal.access$getFab(DailyMeal.this);
//                    }
//                    localObject1 = DailyMeal.access$getFab(this$0);
//                    localObject2 = this$0;
//                    ((FloatingActionButton)localObject1).setBackgroundTintList(ColorStateList.valueOf(((Fragment)localObject2).getResources().getColor(2131099736)));
//                }
//                else
//                {
//                    DailyMeal.access$getEditor(DailyMeal.this).putBoolean(val$tag, true);
//                    if (Build.VERSION.SDK_INT >= 21) {
//                        paramAnonymousView = DailyMeal.access$getFab(DailyMeal.this);
//                    }
//                    for (localObject1 = getResources().getDrawable(2131230985, getActivity().getTheme());; localObject1 = getResources().getDrawable(2131230985))
//                    {
//                        localObject2 = this;
//                        paramAnonymousView.setImageDrawable((Drawable)localObject1);
//                        break;
//                        paramAnonymousView = DailyMeal.access$getFab(DailyMeal.this);
//                    }
//                    DailyMeal.access$getFab(this$0).setBackgroundTintList(ColorStateList.valueOf(this$0.getResources().getColor(2131099698)));
//                    paramAnonymousView = this$0;
//                    Toast.makeText(paramAnonymousView.getActivity(), "Finished", 0).show();
//                    paramAnonymousView = (View)localObject2;
//                }
//                DailyMeal.access$getEditor(this$0).commit();
//            }
//        });
//        if ((stddietenabled.booleanValue() == true) && (!vegdietenabled.booleanValue()))
//        {
//            mBtnStdDiet.setTextColor(getResources().getColor(R.color.green));
//            mBtnVegDiet.setTextColor(getResources().getColor(R.color.blue));
//            scrollstddietfood.setVisibility(View.INVISIBLE);
//            scrollvegdietfood.setVisibility(View.VISIBLE);
//        }
//        for (;;)
//        {
//            if ((!stddietenabled.booleanValue()) && (vegdietenabled.booleanValue() == true))
//            {
//                mBtnStdDiet.setTextColor(getResources().getColor(R.color.green));
//                mBtnVegDiet.setTextColor(getResources().getColor(R.color.blue));
//                scrollstddietfood.setVisibility(View.VISIBLE);
//                scrollvegdietfood.setVisibility(View.INVISIBLE);
//            }
//            else
//            {
//                if ((stddietenabled.booleanValue()) || (vegdietenabled.booleanValue())) {
//                    break;
//                }
//                mBtnStdDiet.setTextColor(getResources().getColor(R.color.green));
//                mBtnVegDiet.setTextColor(getResources().getColor(R.color.blue));
//                scrollstddietfood.setVisibility(View.INVISIBLE);
//                scrollvegdietfood.setVisibility(View.VISIBLE);
////                prefsEditor.putBoolean(str1, true);
////                prefsEditor.putBoolean(str2, false);
//                prefsEditor.commit();
//            }
//        }
        return inflate;
    }
}
