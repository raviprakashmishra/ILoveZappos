package com.example.rpmnitp.ilovezappos;

/**
 * List activity to list all
 * the products returned on user's search
 *
 * Created by rpmnitp on 1/26/2017.
 */

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.rpmnitp.adapters.SearchResultArrayAdapter;
import com.example.rpmnitp.processing.Product;
import com.example.rpmnitp.processing.RestAPIProcessingBuilder;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends ListActivity {
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        // search product
        searchProducts(getIntent());

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
        intent.putExtra(IConstant.SEL_PRODUCT, product);

        startActivity(intent);

    }

    /**
     * searches product
     * based on user's input
     *
     * @param intent - intent
     */
    private void searchProducts(Intent intent) {
        List<String> prodList = new ArrayList<>();

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(IConstant.PROD_EXTRA);


            //This Rest API builder builds instance of Rest API
            // with "query" string set and finally call the API
            // and gets back products
            RestAPIProcessingBuilder rest = new RestAPIProcessingBuilder(this)
                                            .setPrdToSearch(query)
                                            .callRestAPI(IConstant.BASE_URL);

        }
    }

    /**
     * This method should be invoked from
     * outside of this class to update the product list
     * in Product List View
     * @param prodList - List of searched product
     */
    public void updateListView(List<Product> prodList){

        SearchResultArrayAdapter adapter = new SearchResultArrayAdapter(this,prodList);
        setListAdapter(adapter);
    }

}
