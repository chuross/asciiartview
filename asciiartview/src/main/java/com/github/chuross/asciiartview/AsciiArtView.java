package com.github.chuross.asciiartview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class AsciiArtView extends View {

    private static final int DEFAULT_TEXT_SIZE = 40;
    private Paint defaultAsciiArtPaint = new Paint();
    private Paint asciiArtPaint = new Paint();
    private Rect tempRect = new Rect();
    private String asciiArt;
    private float scale;

    public AsciiArtView(Context context) {
        super(context);
        init();
    }

    public AsciiArtView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AsciiArtView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        defaultAsciiArtPaint.setTextSize(DEFAULT_TEXT_SIZE);
        defaultAsciiArtPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        asciiArtPaint.reset();

        if (asciiArt == null) return;

        asciiArtPaint.set(defaultAsciiArtPaint);

        Rect asciiArtRect = getAsciiArtRect();

        scale = (float) getMeasuredWidth() / (float) asciiArtRect.width();

        float width = getMeasuredWidth();
        float height = scale < 1.0F ? asciiArtRect.height() * scale : asciiArtRect.height();

        setMeasuredDimension(Math.round(width), Math.round(height));
    }

    private String[] getLines() {
        return asciiArt != null ? asciiArt.split("\n") : new String[] {};
    }

    @NonNull
    private Rect getAsciiArtRect() {
        Rect asciiArtRect = new Rect();

        if (asciiArt == null) return asciiArtRect;

        String[] lines = asciiArt.split("\n");
        if (lines.length == 0) return asciiArtRect;

        int width = 0;
        int height = 0;
        for (String line : lines) {
            tempRect.setEmpty();
            asciiArtPaint.getTextBounds(line, 0, line.length(), tempRect);
            width = Math.max(width, (int) asciiArtPaint.measureText(line));
            height += tempRect.height();
        }

        asciiArtRect.set(0, 0, width, height);

        return asciiArtRect;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (asciiArt == null) return;

        canvas.scale(scale, scale);

        int y = 0;
        String[] lines = getLines();
        for (String line : lines) {
            tempRect.setEmpty();
            asciiArtPaint.getTextBounds(line, 0, line.length(), tempRect);

            if (line.isEmpty()) tempRect.set(0, 0, tempRect.width(), DEFAULT_TEXT_SIZE);

            canvas.drawText(line, 0, y, asciiArtPaint);
            y += tempRect.height();
        }
    }

    public void draw(String asciiArt) {
        this.asciiArt = asciiArt;
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        defaultAsciiArtPaint.setTypeface(typeface);
        invalidate();
    }
}
