package com.example.android.miwok;

import android.view.View;
import android.widget.Toast;

/**
 * Created by 77 on 12/28/17.
 */

public class NumberClickListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Open numbers list", Toast.LENGTH_SHORT).show();
    }
}

