package com.example.rpmnitp.ilovezappos;


import android.os.Bundle;
import android.widget.SearchView;

/**
 * Main activity of the app
 * extends BaseActivity class
 * See BaseActivity's documentation to
 * understand MainActivity behavior
 */
public class MainActivity extends BaseActivity {
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



}
