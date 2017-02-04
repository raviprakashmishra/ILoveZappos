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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rpmnitp.adapters.SearchResultArrayAdapter;
import com.example.rpmnitp.processing.Product;
import com.example.rpmnitp.processing.RestAPIProcessingBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductListActivity extends ListActivity {
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);


        handleIntent(getIntent());

    }



    @Override

    protected void onListItemClick(ListView l, View v, int position, long id) {
        SearchResultArrayAdapter searchAdapter = null;
        ListAdapter adapter = getListAdapter();
        if(adapter != null && adapter instanceof  SearchResultArrayAdapter){
            searchAdapter = (SearchResultArrayAdapter)adapter;
        }

        Product product = (Product) searchAdapter.getItem(position);

        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra("selectedProduct", product);

        startActivity(intent);

       /* String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();*/
    }

    private void handleIntent(Intent intent) {
        List<String> prodList = new ArrayList<>();

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(IConstant.PROD_EXTRA);


            //call rest api here and get result
            RestAPIProcessingBuilder rest = new RestAPIProcessingBuilder(this)
                                            .setPrdToSearch(query)
                                            .callRestAPI();

            String[] products = rest.getProducts();

        }
    }


    public void updateListView(List<Product> prodList){

        SearchResultArrayAdapter adapter = new SearchResultArrayAdapter(this,prodList);
        setListAdapter(adapter);
    }




}
