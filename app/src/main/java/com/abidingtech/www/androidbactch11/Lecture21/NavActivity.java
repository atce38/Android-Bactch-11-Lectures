package com.abidingtech.www.androidbactch11.Lecture21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.abidingtech.www.androidbactch11.Lecture21.fragments.HomeFragment;
import com.abidingtech.www.androidbactch11.Lecture21.fragments.ProfileFragment;
import com.abidingtech.www.androidbactch11.R;
import com.google.android.material.navigation.NavigationView;

public class NavActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer_layout;
    static NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        drawer_layout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigationView);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toggle=new ActionBarDrawerToggle(this,
                drawer_layout,
                toolbar,
                R.string.open,
                R.string.close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();

        View headerView=navigationView.inflateHeaderView(R.layout.nav_header);
        TextView txtHeader=headerView.findViewById(R.id.txtHeader);
        txtHeader.setText("Hassan Afzal");

        navigationView.setNavigationItemSelectedListener(this);
        openFragment(new HomeFragment());

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
        Fragment fragment=null;
        if(id==R.id.item1)
        {
            fragment=new HomeFragment();

        }
        if(id==R.id.item2)
        {
            fragment=new ProfileFragment();

        }
        openFragment(fragment);
//        setNavItemChecked(id);
        drawer_layout.closeDrawers();
        return true;
    }

    public static void setNavItemChecked(int id) {

        navigationView.setCheckedItem(id);
    }

    private void openFragment(Fragment fragment) {
        String fragmentName=fragment.getClass().getName();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,fragment);
        if (!fragment.isAdded())
            ft.addToBackStack(fragmentName);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment=getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment instanceof HomeFragment)
            finish();
        else
        super.onBackPressed();
    }
}