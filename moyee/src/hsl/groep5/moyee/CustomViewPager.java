package hsl.groep5.moyee;

/**
* @title CustomViewPager Adapter Moyee Applicatie
* @author Projectgroep 5
* @param S1063848
* @since 04-04-2013
* @version 1.0
*/

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.MapView;

public class CustomViewPager extends ViewPager {

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v.getClass().getName().equals("maps.i.b")) {
            return true;
        }
        return super.canScroll(v, checkV, dx, x, y);
    }
}