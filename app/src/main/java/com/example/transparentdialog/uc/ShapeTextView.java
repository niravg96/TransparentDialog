package com.example.transparentdialog.uc;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.transparentdialog.R;


public class ShapeTextView extends AppCompatTextView {

    private Context context;
    private GradientDrawable gd;

    public ShapeTextView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public ShapeTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        if (attrs != null) {
            gd = new GradientDrawable();
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ShapeTextView);
            int BG_Color = a.getColor(R.styleable.ShapeTextView_BgColorTv, -101);
            int strokeColor = a.getColor(R.styleable.ShapeTextView_StrokeColorTv, -101);
            float cornerRadius = a.getDimension(R.styleable.ShapeTextView_CornerRadiusTv, 0);
            float strokeWidth = a.getDimension(R.styleable.ShapeTextView_StrokeWidthTv, 0);
            gd.setShape(GradientDrawable.RECTANGLE);
            if (BG_Color != -101) {
                gd.setColor(BG_Color);
            }
            if (strokeWidth > 0) {
                if (strokeColor != -101)
                    gd.setStroke((int) strokeWidth, strokeColor);
            }
            if (cornerRadius > 0) {
                gd.setCornerRadius(cornerRadius);
            }
            setGradientDrawable(gd);
            a.recycle();
        }
    }

    public void setGradientDrawable(GradientDrawable gd) {
        setBackground(gd);
    }

    public void setBackGroundColor(int color) {
        gd.setColor(color);
    }

    public void setCornerRadius(float radius) {
        if (radius > 0) {
            gd.setCornerRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    radius, context.getResources().getDisplayMetrics()));
        }
    }
    public void setStroke(float strokeWidth, int strokeColor) {
        gd.setStroke((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                strokeWidth, context.getResources().getDisplayMetrics()), strokeColor);
    }
}