package com.example.hackathon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

public class canvas extends View {


    static Integer width;
    static Integer height;
    static Integer distancewidth;
    static Integer distanceheight;


    //static Integer touchx, touchy;
    //static boolean selected = false;

    static float thickness;
    static Paint line, red, silver;
    //static Integer turn = 1;
    static Bitmap redpyramid, redpharaoh, redanubis, redscarab, redspinx, silverpyramid, silverpharaoh, silveranubis, silverscarab, silverspinx;
    static viewmodel res;

    static Boolean resize = false;


    public canvas(Context context) {
        super(context);

        res = new ViewModelProvider((ViewModelStoreOwner) context).get(viewmodel.class);
        res.init();

        line = new Paint();
        line.setStrokeWidth(getpx(3));

        thickness = getpx(3);

        red = new Paint();
        red.setColor(Color.RED);

        silver = new Paint();
        silver.setColor(Color.GRAY);

        redpyramid = BitmapFactory.decodeResource(getResources(), R.drawable.redpyramid);
        redpharaoh = BitmapFactory.decodeResource(getResources(), R.drawable.redpharaoh);
        redanubis = BitmapFactory.decodeResource(getResources(), R.drawable.redanibus);
        redscarab = BitmapFactory.decodeResource(getResources(), R.drawable.redscarab);
        redspinx = BitmapFactory.decodeResource(getResources(), R.drawable.redspinx);


        silverpyramid = BitmapFactory.decodeResource(getResources(), R.drawable.silverpyramid);
        silverpharaoh = BitmapFactory.decodeResource(getResources(), R.drawable.silverpharaoh);
        silveranubis = BitmapFactory.decodeResource(getResources(), R.drawable.silveranubis);
        silverscarab = BitmapFactory.decodeResource(getResources(), R.drawable.silverscarab);
        silverspinx = BitmapFactory.decodeResource(getResources(), R.drawable.silverspinx);
//        Log.i("kjsbdfsd", getWidth() + "");


    }

    public canvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public canvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public canvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth();
        height = getHeight();

        distancewidth = width / 10;
        for (int i = 0; i <= 10; i++) {
            canvas.drawLine(i * distancewidth, 0, i * distancewidth, width, line);
        }

        distanceheight = width / 8;
        for (int i = 0; i <= 8; i++) {
            canvas.drawLine(0, i * distanceheight, width, i * distanceheight, line);
        }


        for (int i = 0; i < 8; i++) {
            canvas.drawRect(thickness, i * distanceheight + thickness, distancewidth - thickness, (i + 1) * distanceheight - thickness, red);
            canvas.drawRect(distancewidth * 9 + thickness, i * distanceheight + thickness, distancewidth * 10 - thickness, (i + 1) * distanceheight - thickness, silver);
        }

        canvas.drawRect(distancewidth + thickness, thickness, distancewidth * 2 - thickness, distanceheight - thickness, silver);
        canvas.drawRect(distancewidth + thickness, distanceheight * 7 + thickness, distancewidth * 2 - thickness, distanceheight * 8 - thickness, silver);

        canvas.drawRect(distancewidth * 8 + thickness, thickness, distancewidth * 9 - thickness, distanceheight - thickness, red);
        canvas.drawRect(distancewidth * 8 + thickness, distanceheight * 7 + thickness, distancewidth * 9 - thickness, distanceheight * 8 - thickness, red);


        //
        //

        //
        //
        //
        //
        //
        //

        //
        //
        //
        //
        //
        //


        if (!resize) {
            bitmapresize();
            resize = true;
        }


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                switch (res.getGrid()[i][j]) {
                    case 1:
                        canvas.drawBitmap(redspinx, distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 2:
                        canvas.drawBitmap(RotateBitmap(redspinx, 270), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 3:
                        canvas.drawBitmap(RotateBitmap(redpyramid, 270), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 4:
                        canvas.drawBitmap(redpyramid, distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 5:
                        canvas.drawBitmap(RotateBitmap(redpyramid, 90), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 6:
                        canvas.drawBitmap(RotateBitmap(redpyramid, 180), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 7:
                        canvas.drawBitmap(RotateBitmap(redanubis, 180), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 8:
                        canvas.drawBitmap(RotateBitmap(redanubis, 270), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 9:
                        canvas.drawBitmap(redanubis, distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 10:
                        canvas.drawBitmap(RotateBitmap(redanubis, 90), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 13:
                        canvas.drawBitmap(RotateBitmap(redscarab, 90), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 14:
                        canvas.drawBitmap(redscarab, distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 15:
                        canvas.drawBitmap(RotateBitmap(redpharaoh, 90), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 16:
                        canvas.drawBitmap(RotateBitmap(redpharaoh, 270), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 17:
                        canvas.drawBitmap(redpharaoh, distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 18:
                        canvas.drawBitmap(RotateBitmap(redpharaoh, 180), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 21:
                        canvas.drawBitmap(silverspinx, distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 22:
                        canvas.drawBitmap(RotateBitmap(silverspinx, 270), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 23:
                        canvas.drawBitmap(RotateBitmap(silverpyramid, 90), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 24:
                        canvas.drawBitmap(RotateBitmap(silverpyramid, 180), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 25:
                        canvas.drawBitmap(RotateBitmap(silverpyramid, 270), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 26:
                        canvas.drawBitmap(silverpyramid, distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 27:
                        canvas.drawBitmap(silveranubis, distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 28:
                        canvas.drawBitmap(RotateBitmap(silveranubis, 90), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 29:
                        canvas.drawBitmap(RotateBitmap(silveranubis, 180), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 30:
                        canvas.drawBitmap(RotateBitmap(silveranubis, 270), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 33:
                        canvas.drawBitmap(RotateBitmap(silverscarab, 90), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 34:
                        canvas.drawBitmap(silverscarab, distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 35:
                        canvas.drawBitmap(RotateBitmap(silverpharaoh, 270), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 36:
                        canvas.drawBitmap(RotateBitmap(silverpharaoh, 90), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 37:
                        canvas.drawBitmap(RotateBitmap(silverpharaoh, 180), distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;
                    case 38:
                        canvas.drawBitmap(silverpharaoh, distancewidth * j + thickness, distanceheight * i + thickness, red);
                        break;

                }


            }
        }


    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN: {
                if (!res.getSelected().getValue()) {
                    res.setTouchx((int) event.getX() / distancewidth);
                    res.setTouchy((int) event.getY() / distanceheight);
                    res.getSelected().setValue(true);
                }
            }

        }

        return super.onTouchEvent(event);
    }


    void undo() {

    }


    private void bitmapresize() {
        redspinx = Bitmap.createScaledBitmap(redspinx, (int) (distancewidth - thickness * 2), (int) (distanceheight - thickness * 2), false);
        redanubis = Bitmap.createScaledBitmap(redanubis, (int) (distancewidth - thickness * 2), (int) (distanceheight - thickness * 2), false);
        redpharaoh = Bitmap.createScaledBitmap(redpharaoh, (int) (distancewidth - thickness * 2), (int) (distanceheight - thickness * 2), false);
        redscarab = Bitmap.createScaledBitmap(redscarab, (int) (distancewidth - thickness * 2), (int) (distanceheight - thickness * 2), false);
        redpyramid = Bitmap.createScaledBitmap(redpyramid, (int) (distancewidth - thickness * 2), (int) (distanceheight - thickness * 2), false);

        silverspinx = Bitmap.createScaledBitmap(silverspinx, (int) (distancewidth - thickness * 2), (int) (distanceheight - thickness * 2), false);
        silveranubis = Bitmap.createScaledBitmap(silveranubis, (int) (distancewidth - thickness * 2), (int) (distanceheight - thickness * 2), false);
        silverpharaoh = Bitmap.createScaledBitmap(silverpharaoh, (int) (distancewidth - thickness * 2), (int) (distanceheight - thickness * 2), false);
        silverscarab = Bitmap.createScaledBitmap(silverscarab, (int) (distancewidth - thickness * 2), (int) (distanceheight - thickness * 2), false);
        silverpyramid = Bitmap.createScaledBitmap(silverpyramid, (int) (distancewidth - thickness * 2), (int) (distanceheight - thickness * 2), false);

    }


    private float getpx(int dp) {
        return ((float) getResources().getDisplayMetrics().densityDpi / 160) * dp;
    }


    public static Bitmap RotateBitmap(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        if (angle == 180)
            return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
        else {
            Bitmap temp = Bitmap.createScaledBitmap(source, (int) (distanceheight - thickness * 2), (int) (distancewidth - thickness * 2), false);
            return Bitmap.createBitmap(temp, 0, 0, source.getHeight(), source.getWidth(), matrix, true);
        }
    }

}
