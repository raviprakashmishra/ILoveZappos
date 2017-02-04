package com.example.rpmnitp.ilovezappos;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rpmnitp.ilovezappos.databinding.ProductDetailBinding;
import com.example.rpmnitp.processing.Product;
import com.squareup.picasso.Picasso;

/**
 * Created by dell on 2/2/2017.
 */

public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);
        handleIntent(getIntent());

    }

    private void handleIntent(Intent intent){

        Product product = (Product) intent.getSerializableExtra("selectedProduct");

        ImageView prodImg = (ImageView)findViewById(R.id.prod_image);
        /*TextView prodName = (TextView) findViewById(R.id.prod_name);
        TextView prodDesc = (TextView) findViewById(R.id.prod_description);
        TextView prodPrice = (TextView) findViewById(R.id.prod_price);*/

        Picasso.with(getApplicationContext()).load(product.getThumbnailImageUrl()).into(prodImg);
       /* prodName.setText(product.getProductName());
        prodDesc.setText(product.getBrandName());
        prodPrice.setText(product.getOriginalPrice());*/


        ProductDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.product_detail);
        binding.setProduct(product);

        // set FAB click listener
        handleFABClick();



    }



    private void handleFABClick(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final ProductDetailsActivity activity = this;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(MainActivity.this, NewMessageActivity.class);
                startActivity(intent);*/
                Toast.makeText(activity," FAB selected", Toast.LENGTH_LONG).show();
            }
        });
    }


}
