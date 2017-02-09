package com.example.rpmnitp.ilovezappos;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;

import com.example.rpmnitp.helper.IConstant;

/**
 * This class creates search View for the App
 * This can be extended by any activity to provide same
 * search interface across the app
 *
 * Currently support for search enter is provided
 *
 * Support to do search on text change can be done
 * by implementing 'onQueryTextChange' method
 *
 * Created by rpmnitp on 2/6/2017.
 */

public class BaseActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);


        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);



        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        String prodName = query;

        // start product list activity with extra message in intent

        Intent intent = new Intent(this, ProductListActivity.class);
        intent.putExtra(IConstant.PROD_EXTRA, prodName);
        intent.setAction(Intent.ACTION_SEARCH);
        startActivity(intent);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
