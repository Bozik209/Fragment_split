package com.example.fragment_split.Activity.Activitys;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.fragment_split.Activity.Fragments.EmFragment;
import com.example.fragment_split.Activity.Fragments.MaFragment;
import com.example.fragment_split.R;

public class MainActivity extends AppCompatActivity implements MaFragment.MaOnFragmentInteractionListener, EmFragment.EmOnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    @Override
    public void EmOnFragmentInteractionListener(Uri uri) {

    }

    @Override
    public void MaOnFragmentInteractionListener(Uri uri) {

    }

    public void FragmentView(View view) {
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.Fragment_container);

        CheckBox Manager_checkBox = (CheckBox) findViewById(R.id.checkBox_Ma);
        CheckBox Employess_checkBox = (CheckBox) findViewById(R.id.checkBox_Em);



        if (fragment == null)
        {

            if(Manager_checkBox.isChecked())
            {

                fragment = new MaFragment();
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.add(R.id.Fragment_container,fragment).commit();
            }
            if(Employess_checkBox.isChecked())
            {
                fragment = new EmFragment();
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.add(R.id.Fragment_container,fragment).commit();
            }
        }

        if (!(fragment == null))
        {

            if(Manager_checkBox.isChecked())
            {
                fragment = new MaFragment();
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.replace(R.id.Fragment_container,fragment).commit();
            }
            if(Employess_checkBox.isChecked())
            {
                fragment = new EmFragment();
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.replace(R.id.Fragment_container,fragment).commit();
            }
        }
    }
}
