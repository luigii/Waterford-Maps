package snowflake.waterford.maps1;
//Map App written by Conall Ó Maitiú
//including code from MapView example
//at http://developer.android.com/resources/tutorials/views/hello-mapview.html
import java.util.List;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.maps.*;

public class PumpMapOne extends MapActivity {
	List<Overlay> mapOverlays;
	Drawable green, yellow, red;
	StatusOverlay greenOverlay, yellowOverlay, redOverlay;
	//OverlayItem[] greenItems, yellowItems, redItems;	
	List<OverlayItem> greenItems, yellowItems, redItems;
	
	@Override
		protected boolean isRouteDisplayed() {
		return false;
		//No need to display routes on the map, so this is set to false
	}
    
	@Override
		public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		MapView mapView = (MapView) findViewById(R.id.StationMaps);
		mapView.setBuiltInZoomControls(true);
		mapOverlays = mapView.getOverlays();
		green = this.getResources().getDrawable(R.drawable.green_dot_small);
        
		//Need to have three instances of StatusOverlay, one for each status colour

		red = this.getResources().getDrawable(R.drawable.red_dot_small);
		greenOverlay = new StatusOverlay(green, this);
		//GeoPoint point = new GeoPoint(52256667, -7129167);
		//OverlayItem pointmarker = new OverlayItem(point, "Pumphouse 1", "this is a sample");
        
        
		yellow = this.getResources().getDrawable(R.drawable.yellow_dot_small);
		yellowOverlay = new StatusOverlay(yellow, this);
		//GeoPoint point2 = new GeoPoint(52257372, -7128673);
		//OverlayItem pointmarker2 = new OverlayItem(point2, "Pumphouse 2", "More Sample text");
        
        
		red = this.getResources().getDrawable(R.drawable.red_dot_small);
		redOverlay = new StatusOverlay(red, this);
		//GeoPoint point3 = new GeoPoint(52267372, -7129673);
		//OverlayItem pointmarker3 = new OverlayItem(point3, "Pumphouse 3", "A third sample");

		
		this.getAssetStatuses();
        
		//All the locations are added to the Overlays...
        
		for(int i = 0; i < greenItems.size(); i++){
			greenOverlay.addOverlay(greenItems.get(i));
		}
        
		for(int i = 0; i < yellowItems.size(); i++){
			greenOverlay.addOverlay(yellowItems.get(i));
		}
        
		for(int i = 0; i < redItems.size(); i++){
			greenOverlay.addOverlay(redItems.get(i));
		}
        
		//... and then the Overlays are put over the map
        
		mapOverlays.add(greenOverlay);
		mapOverlays.add(yellowOverlay);
		mapOverlays.add(redOverlay);
	}
    
	public void getAssetStatuses(){
		//some code to get statuses from a database hosted somewhere
		//should go here
    	
		//Locations are sorted due by their status
		//siteStatus == colour is just a placeholder, something real should go there
		switch(siteStatus){
		red:
			redItems.add(new OverlayItem(new GeoPoint(GPSLatitude, GPSLongitude), site_name, ""));
			break;
		yellow:
			yellowItems.add(new OverlayItem(new GeoPoint(GPSLatitude, GPSLongitude), site_name, ""));
			break;
		green:
			greenItems.add(new OverlayItem(new GeoPoint(GPSLatitude, GPSLongitude), site_name, ""));
			break;
		}
	}
    
    
}
