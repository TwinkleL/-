package com.example.l.day28cusvi;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by L on 2016/8/31.
 */
public class Mytext extends View {
    Paint paint=null;
    String text;
    int textsize,textcolor;
    public Mytext(Context context) {
        this(context, null);
    }

    public Mytext(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Mytext(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPaint();
        TypedArray array= context.obtainStyledAttributes(attrs,R.styleable.Mytext);
        text=array.getString(R.styleable.Mytext_mytexy);
        textcolor=array.getColor(R.styleable.Mytext_mytextcolor, Color.GREEN);
        textsize=array.getInt(R.styleable.Mytext_mytextsize,30);


    }

    private void initPaint() {
        paint=new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(3);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMod=MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMod=MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width,height;
        if (widthMod==MeasureSpec.EXACTLY){
            width=widthSize;
        }else {
            width= (int) paint.measureText(text,0,text.length())+getPaddingLeft()+getPaddingRight();
        }
        if (heightMod==MeasureSpec.EXACTLY){
            height=heightMod;
        }else {
            height= (int) paint.measureText(text,0,text.length())+getPaddingTop()+getPaddingBottom();

        }
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);

        paint.setColor(textcolor);
        paint.setTextSize(textsize);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawText(text,getWidth()/2-getMeasuredWidth()/2+getPaddingLeft(),getHeight()/2-Math.abs(paint.ascent()+paint.descent()/2)+getPaddingBottom(),paint);
    }
}
