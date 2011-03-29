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
    }
    
    GeoPoint point = new GeoPoint(53344400, -62577000);
    OverlayItem pointmarker = new OverlayItem(point, "", "");
    //itemizedOverlay.addOverlay(pointmarker);
    //mapOverlays.add(itemizedOverlay);
}