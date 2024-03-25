package com.example.finel6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Главная"); // Установить заголовок
            BottomNavigationView bottomNavigationView =
                    findViewById(R.id.bottom_navigation);
            bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
                if (item.getItemId() == R.id.home) {
                    actionBar.setTitle("Домой");
                    setNewFragment(new HomeFragment());
                    return true;

                } else if (item.getItemId() == R.id.notifications) {
                    actionBar.setTitle("Уведомления");
                    setNewFragment(new NotificationsFragment());
                    return true;

                } else if (item.getItemId() == R.id.settings) {
                    actionBar.setTitle("Настройки");
                    setNewFragment(new SettingsFragment());
                    return true;
                }
                return false;
            });
        }


}
    public void setNewFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container1, fragment);
        fragmentTransaction.commit();
    }
}