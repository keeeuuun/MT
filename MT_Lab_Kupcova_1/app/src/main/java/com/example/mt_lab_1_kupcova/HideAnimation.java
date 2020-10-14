package com.example.mt_lab_1_kupcova;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class HideAnimation implements Animation.AnimationListener {
    private Animation animation1;
    private ImageView img;

    HideAnimation(Context ctx, Card card) {
        this.img = card.getImageView();
        animation1 = AnimationUtils.loadAnimation(ctx, R.anim.hide_animation);
        animation1.setAnimationListener(this);

        img.clearAnimation();
        img.setAnimation(animation1);
        img.startAnimation(animation1);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        img.setImageResource(R.drawable.ic_alpha_100);
        img.clearAnimation();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}