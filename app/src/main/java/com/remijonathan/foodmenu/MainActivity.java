package com.remijonathan.foodmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager pager;
    private LinearLayout fragmentLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.menu_toolbar);
        tabLayout = findViewById(R.id.tabs);
        fragmentLayout = findViewById(R.id.LinearLayoutContainer);

        setSupportActionBar(toolbar);
        tabLayout.setupWithViewPager(pager);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.ui_tabname_breakfast));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.ui_tabname_lunch));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.ui_tabname_snack));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.ui_tabname_supper));

        Bundle bundle = new Bundle();
        bundle.putString("message","Hello world");
        bundle.putInt("count", 1);


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.LinearLayoutContainer, new Breakfast());
        fragmentTransaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {



            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                switch (tab.getPosition()) {
                    case 0:
                        fragmentTransaction.replace(R.id.LinearLayoutContainer, new Breakfast());
                        break;
                    case 1:
                        fragmentTransaction.replace(R.id.LinearLayoutContainer, new LunchFragment());
                        break;
                    case 2:
                        fragmentTransaction.replace(R.id.LinearLayoutContainer, new SnackFragment());
                        break;
                    case 3:
                        fragmentTransaction.replace(R.id.LinearLayoutContainer, new SupperFragment());
                        break;
                }
                fragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuitem_about:
                //Do something

                return true;
            case R.id.menuitem_help:
                //Do something else
                return true;
            case R.id.menuitem_settings:
                //Do something else
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

}
