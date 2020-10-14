package com.example.mt_lab_1_kupcova;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private Vector<Card> cards;
    private Vector<Integer> showedCards;
    boolean availableToClick = true;

    public GridAdapter(Context c, int[] game_field, int[] resources){
        context = c;
        cards = new Vector<>();
        showedCards = new Vector<>();
        for(int i = 0; i<game_field.length; i++){
            cards.add(new Card(game_field[i], resources[game_field[i]]));
        }
    }
    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public Card getItem(int i) {
        return cards.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if(inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view == null){
            view = inflater.inflate(R.layout.row_item, null);
        }
        cards.elementAt(i).setImageView(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (cards.elementAt(i).isAvailable && availableToClick) {
                    showedCards.add(i);
                    new FlipAnimation(view.getContext(), cards.elementAt(i));
                    availableToClick = false;
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if (showedCards.size() > 1) {
                                if (cards.elementAt(showedCards.elementAt(0)).getTag()
                                        == cards.elementAt(showedCards.elementAt(1)).getTag()) {
                                    cards.elementAt(showedCards.elementAt(0)).isAvailable = false;
                                    cards.elementAt(showedCards.elementAt(1)).isAvailable = false;
                                    cards.elementAt(showedCards.elementAt(0)).hide();
                                    cards.elementAt(showedCards.elementAt(1)).hide();
                                } else {
                                    cards.elementAt(showedCards.elementAt(0)).flip();
                                    cards.elementAt(showedCards.elementAt(1)).flip();
                                }
                                showedCards.clear();
                            }
                            availableToClick = true;
                        }
                    }, 800); //specify the number of milliseconds
                }
            }
        });
        return view;
    }
}
