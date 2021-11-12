package com.example.myapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class VazirTextView extends androidx.appcompat.widget.AppCompatTextView {

    public VazirTextView(@NonNull Context context) {
        super(context);
    }

    public VazirTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "vazir.ttf");
        this.setTypeface(typeface);
    }
}
