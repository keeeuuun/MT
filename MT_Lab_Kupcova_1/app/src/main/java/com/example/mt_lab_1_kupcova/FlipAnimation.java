package com.example.mt_lab_1_kupcova;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class FlipAnimation implements Animation.AnimationListener {
    private Animation animation1;
    private Animation animation2;
    private boolean isBackOfCardShowing = true;
    private ImageView img;
    private Context ctx;
    private FlipEnd flipped;
    Card card;

    public interface FlipEnd {
        void flipEnd(ImageView img, Card card);
    }

    FlipAnimation(Context ctx, Card card) {
        this.img = card.getImageView();
        this.ctx = ctx;
        this.card = card;
        isBackOfCardShowing = card.isShown;
        //flipped = (FlipEnd) ctx;
        animation1 = AnimationUtils.loadAnimation(ctx, R.anim.flip_to_middle);
        animation1.setAnimationListener(this);
        animation2 = AnimationUtils.loadAnimation(ctx, R.anim.flip_from_middle);
        animation2.setAnimationListener(this);

        img.clearAnimation();
        img.setAnimation(animation1);
        img.startAnimation(animation1);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == animation1) {
            if (isBackOfCardShowing) {
                img.setImageResource(R.drawable.ic_hidden);
            } else {
                img.setImageResource(card.getResource());
            }
            card.Clicked();
            img.clearAnimation();
            img.setAnimation(animation2);
            img.startAnimation(animation2);
        } else {
            isBackOfCardShowing = !isBackOfCardShowing;
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}