package com.example.prog5.secondtask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by prog5 on 3/19/2018.
 */

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    private GestureDetector gestureDetector;
    private ClickListener clickListener;


    public RecyclerTouchListener(
            Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
        this.clickListener = clickListener;

        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View chiled =   recyclerView.findChildViewUnder(e.getX(), e.getY());
                if(chiled!= null && clickListener!=null){
                    clickListener.onLongClick(chiled, recyclerView.getChildLayoutPosition(chiled));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View chiled = rv.findChildViewUnder(e.getX(), e.getY());
        if(chiled != null && clickListener != null && gestureDetector.onTouchEvent(e)){
            clickListener.onClick(chiled, rv.getChildLayoutPosition(chiled));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
