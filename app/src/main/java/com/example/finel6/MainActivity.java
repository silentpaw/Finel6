package com.example.finel6;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true); // Показать кнопку назад
            actionBar.setTitle("Котики"); // Установить заголовок
        }

        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.new_activity_btn) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        } else if (id == R.id.beaty_btn) {
            Toast.makeText(this, "Красивые коты", Toast.LENGTH_SHORT).show();
            setNewFragment(new BeatyFragment());
            return true;
        } else if (id == R.id.cutye_btn) {
            Toast.makeText(this, "Милые коты", Toast.LENGTH_SHORT).show();
            setNewFragment(new CuetyFragment());
            return true;
        } else if (id == R.id.street_bnt) {
            Toast.makeText(this, "Уличные коты", Toast.LENGTH_SHORT).show();
            setNewFragment(new StreetFragment());
            return true;
        } else if (id == R.id.my_cat_btn) {
            Toast.makeText(this, "Мой кот", Toast.LENGTH_SHORT).show();
            setNewFragment(new MyCatFragment());
            return true;
        } else if (id == R.id.lovely_btn) {
            Toast.makeText(this, "Любимые коты", Toast.LENGTH_SHORT).show();
            setNewFragment(new LovelyFragment());
            return true;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void setNewFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
