package com.remijonathan.foodmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
    private TabLayout tableLayout;
    private ViewPager pager;
    private LinearLayout fragmentLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.menu_toolbar);
        tableLayout =  findViewById(R.id.tabs);
        fragmentLayout = findViewById(R.id.LinearLayoutContainer);

        setSupportActionBar(toolbar);
        tableLayout.setupWithViewPager(pager);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        tableLayout.addTab(tableLayout.newTab().setText(R.string.ui_tabname_breakfast));
        tableLayout.addTab(tableLayout.newTab().setText(R.string.ui_tabname_lunch));
        tableLayout.addTab(tableLayout.newTab().setText(R.string.ui_tabname_snack));
        tableLayout.addTab(tableLayout.newTab().setText(R.string.ui_tabname_supper));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
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
