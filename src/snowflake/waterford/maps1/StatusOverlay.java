package snowflake.waterford.maps1;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class StatusOverlay extends ItemizedOverlay<OverlayItem>{
	//mOverlays is an arraylist of all the OverlayItems controlled by this StatusOverlay
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	Context mContext;

	

	public StatusOverlay(Drawable defaultMarker, Context context) {
		super(boundCenter(defaultMarker));
		mOverlays = new ArrayList<OverlayItem>();
		populate();
		mContext = context;
	}

	public void addOverlay(OverlayItem overlay) {
		mOverlays.add(overlay);
		populate();
	}

	@Override
	protected OverlayItem createItem(int i) {
		return mOverlays.get(i);
	}

	@Override
	public int size() {
		return mOverlays.size();
	}

	@Override
	protected boolean onTap(int index) {
		//This method controls the drawing of AlertDialog boxes when
		//a location is tapped on the map
		OverlayItem item = mOverlays.get(index);
		AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(mContext);
		dialogbuilder.setTitle(item.getTitle())
		.setCancelable(true)
		.setMessage(item.getSnippet())
		.setNegativeButton("Back", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		})
		.create()
		.show();
		return true;
	}

}
