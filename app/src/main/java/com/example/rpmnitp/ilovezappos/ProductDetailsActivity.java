package com.example.rpmnitp.ilovezappos;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import android.widget.Toast;

import com.example.rpmnitp.helper.IConstant;
import com.example.rpmnitp.ilovezappos.databinding.ProductDetailBinding;
import com.example.rpmnitp.processing.Product;

/**
 * This activity is responsible for
 * creating product details page and all the interaction
 * on details page
 * Created by rpmnitp on 2/2/2017.
 */

public class ProductDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);
        handleIntent(getIntent());

    }


    private void handleIntent(Intent intent){

        Product product = (Product) intent.getSerializableExtra("selectedProduct");

        // data binding
        ProductDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.product_detail);
        binding.setProduct(product);

        // set FAB click listener
        handleFABClick();
    }

    /**
     * handles what to
     * on Floating action button click
     */

    private void handleFABClick(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final ProductDetailsActivity activity = this;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, IConstant.PROD_ADDED_MSG, Toast.LENGTH_LONG).show();
                //Intent intent = new Intent(activity, CardFlipActivity.class);
               // startActivity(intent);
               callFlipCard();
            }
        });
    }

    /**
     * does flip card animation
     */
    private void callFlipCard(){

        // very basic animation
        // do fragment based card flip view animation
        // if time allows

        View prodImgView = findViewById(R.id.prod_image);
        ObjectAnimator animation = ObjectAnimator.ofFloat(prodImgView, "rotationY", 0.0f, 360f);
        animation.setDuration(1000);
        animation.setRepeatCount(1);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.start();

    }


}
