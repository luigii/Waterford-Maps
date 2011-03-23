package snowflake.waterford.maps1;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.maps.*;

public class PumpMapOne extends MapActivity {
	List<Overlay> mapOverlays;
	Drawable drawable;
	StatusOverlay itemizedOverlay;
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
        itemizedOverlay = new StatusOverlay(drawable);
    }
    GeoPoint point = new GeoPoint(19240000,-99120000);

    OverlayItem overlayitem = new OverlayItem(point, "", "");
}