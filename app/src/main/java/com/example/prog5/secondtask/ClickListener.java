package com.example.prog5.secondtask;

import android.view.View;

/**
 * Created by prog5 on 3/19/2018.
 */

public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
