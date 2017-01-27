package com.example.rpmnitp.ilovezappos;

/**
 * Created by rpmnitp on 1/26/2017.
 */

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rpmnitp.processing.RestAPIProcessing;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends ListActivity {
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);


        handleIntent(getIntent());

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
    }

    private void handleIntent(Intent intent) {
        List<String> prodList = new ArrayList<>();

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(IConstant.PROD_EXTRA);

            ArrayAdapter<String> adapter = initializeAdapter();
            //call rest api here and get result
            RestAPIProcessing rest = new RestAPIProcessing(this,adapter);
            rest.setPrdToSearch(query);
            rest.callRestAPI();
            //rest.getProducts();
            //updateListView(prodList);
        }
    }


    private void updateListView(List<String> prodList){
        // using list so that in future multiple search results can also be searched
       /* String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);*/
    }

    private ArrayAdapter<String> initializeAdapter(){
        String[] values = new String[] {};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);

        return adapter;
    }

}
