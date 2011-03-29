package snowflake.waterford.maps1;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.maps.*;

public class PumpMapOne extends MapActivity {
	List<Overlay> mapOverlays;
	Drawable drawable;
	StatusOverlay itemizedOverlay;
	Context context;
	
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        mapOverlays = mapView.getOverlays();
        drawable = this.getResources().getDrawable(R.drawable.green_dot_small);
        itemizedOverlay = new StatusOverlay(drawable, context);
        GeoPoint point = new GeoPoint(52256667, -7129167);
        GeoPoint point2 = new GeoPoint(52256672, -7129173);
        OverlayItem pointmarker = new OverlayItem(point, "Pumphouse 1", "this is a sample");
        OverlayItem pointmarker2 = new OverlayItem(point2, "Pumphouse 2", "More Samples");
        itemizedOverlay.addOverlay(pointmarker);
        itemizedOverlay.addOverlay(pointmarker2);
        mapOverlays.add(itemizedOverlay);
    }
    
    //GeoPoint point = new GeoPoint(52256667, -7129167);
    //GeoPoint point2 = new GeoPoint(52256672, -7129173);
    //OverlayItem pointmarker = new OverlayItem(point, "", "");
    //OverlayItem pointmarker2 = new OverlayItem(point2, "", "");
    //itemizedOverlay.addOverlay(OverlayItem pointmarker = new OverlayItem(point, "", ""));
    //mapOverlays.add(itemizedOverlay);
}