package com.example.mt_lab_1_kupcova;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Card {
    private int tag;
    private int resource;
    private ImageView imageView;
    private TextView textView;
    boolean isShown;
    boolean isAvailable;
    private View view;
    boolean animating;

    public Card(int tag, int resource){
        this.tag = tag;
        this.resource = resource;
        isShown = false;
        isAvailable = true;
        animating = false;
    }
    public void setImageView(View v) {
        this.imageView = v.findViewById(R.id.image_view);
        this.textView = v.findViewById(R.id.text_view);
        this.view = v;

        this.imageView.setImageResource(R.drawable.ic_hidden);
    }
    public ImageView getImageView(){
        return imageView;
    }
    public int getResource(){
        return resource;
    }
    public void Clicked(){
        isShown = !isShown;
    }
    public int getTag(){
        return tag;
    }
    public void hide(){
        new HideAnimation(view.getContext(), this);
    }
    public void flip(){
       new FlipAnimation(view.getContext(), this);
    }
}
