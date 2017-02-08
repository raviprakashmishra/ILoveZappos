package com.example.rpmnitp.processing;




import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.rpmnitp.ilovezappos.BR;
import com.example.rpmnitp.ilovezappos.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;


/**
 * Created by rpmnitp on 1/26/2017.
 *
 * This is a model class to map
 * product from JSON response to a UI object
 */

public class Product extends BaseObservable implements Serializable{

    private String brandName;

    private String thumbnailImageUrl;

    private String productName;

    private String originalPrice;

    private String productUrl;



    public Product(String productId, String thumbnailImageUrl) {
        this.brandName = productId;
        this.thumbnailImageUrl = thumbnailImageUrl;
    }


    @Bindable

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }



    @Bindable
    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {

        this.originalPrice = originalPrice;
        notifyPropertyChanged(BR.originalPrice);
    }

    @Bindable
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
        notifyPropertyChanged(BR.productName);
    }

    @Bindable
    public String getThumbnailImageUrl() {
        return thumbnailImageUrl;
    }

    public void setThumbnailImageUrl(String thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl;
        notifyPropertyChanged(BR.thumbnailImageUrl);
    }

    @Bindable
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String productId) {

        this.brandName = productId;
        notifyPropertyChanged(BR.brandName);
    }

    @Override
    public String toString() {
        return(brandName);
    }

    @BindingAdapter({"bind:thumbnailImageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.fabblue)
                .into(view);
    }
}
