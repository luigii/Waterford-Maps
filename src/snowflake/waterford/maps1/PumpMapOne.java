package snowflake.waterford.maps1;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.maps.*;

public class PumpMapOne extends MapActivity {
	List<Overlay> mapOverlays;
	Drawable green, yellow, red;
	StatusOverlay greenOverlay, yellowOverlay, redOverlay;
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
        green = this.getResources().getDrawable(R.drawable.green_dot_small);
        
        red = this.getResources().getDrawable(R.drawable.red_dot_small);
        greenOverlay = new StatusOverlay(green, context);
        GeoPoint point = new GeoPoint(52256667, -7129167);
        OverlayItem pointmarker = new OverlayItem(point, "Pumphouse 1", "this is a sample");
        
        
        yellow = this.getResources().getDrawable(R.drawable.yellow_dot_small);
        yellowOverlay = new StatusOverlay(yellow, context);
        GeoPoint point2 = new GeoPoint(52257372, -7128673);
        OverlayItem pointmarker2 = new OverlayItem(point2, "Pumphouse 2", "More Sample text");
        
        
        red = this.getResources().getDrawable(R.drawable.red_dot_small);
        redOverlay = new StatusOverlay(red, context);
        GeoPoint point3 = new GeoPoint(52267372, -7129673);
        OverlayItem pointmarker3 = new OverlayItem(point3, "Pumphouse 3", "this might work");
        
        greenOverlay.addOverlay(pointmarker);
        yellowOverlay.addOverlay(pointmarker2);
        redOverlay.addOverlay(pointmarker3);
        
        mapOverlays.add(greenOverlay);
        mapOverlays.add(yellowOverlay);
        mapOverlays.add(redOverlay);
    }
    
    
}