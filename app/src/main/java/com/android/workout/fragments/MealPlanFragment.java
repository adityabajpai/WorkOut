package com.android.workout.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.android.workout.R;
import com.android.workout.adapters.MealsAdapter;
import com.android.workout.model.MealsItemObject;

import java.util.ArrayList;
import java.util.List;

public class MealPlanFragment extends Fragment {
    private static final String TAG = "RecyclerViewFragment";
    private Button mShoppingBtn;
    private List<MealsItemObject> getAllItemList() {
        List<MealsItemObject> arrayList = new ArrayList();
        int i = 0;
        while (i < 30) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getResources().getString(R.string.day));
            i++;
            stringBuilder.append(i);
            arrayList.add(new MealsItemObject(stringBuilder.toString()));
        }
        return arrayList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.meals_app_bar_main, viewGroup, false);
        inflate.setTag(TAG);
        ((AppCompatActivity) getActivity()).setSupportActionBar((Toolbar) inflate.findViewById(R.id.toolbar));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        setHasOptionsMenu(true);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler);
        Adapter mealsAdapter = new MealsAdapter(getActivity(), getAllItemList());
        LayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setAdapter(mealsAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
        this.mShoppingBtn = (Button) inflate.findViewById(R.id.shoppinglistbtn);
        this.mShoppingBtn.setOnClickListener(new C10511(this));
        return inflate;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            getActivity().finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
    class C10511 implements OnClickListener {
        final MealPlanFragment f3377a;

        C10511(MealPlanFragment mealPlanFragment) {
            this.f3377a = mealPlanFragment;
        }

        public void onClick(View view) {
            Fragment shoppingListFragment = new ShoppingListFragment();
            FragmentTransaction beginTransaction = this.f3377a.getFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.meals_content_fragment, shoppingListFragment);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
        }
    }
}
