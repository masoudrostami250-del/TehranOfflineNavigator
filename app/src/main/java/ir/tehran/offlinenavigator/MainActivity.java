package ir.tehran.offlinenavigator;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.osmdroid.config.Configuration;
import org.osmdroid.views.MapView;
import org.osmdroid.util.GeoPoint;
import java.io.File;

public class MainActivity extends Activity {
    private MapView map;
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().setUserAgentValue(getPackageName());
        Configuration.getInstance().setOsmdroidBasePath(new File(getFilesDir(), "osmdroid"));
        Configuration.getInstance().setOsmdroidTileCache(new File(getFilesDir(), "osmdroid/tiles"));
        LinearLayout root = new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL); root.setBackgroundColor(Color.WHITE);
        TextView title = new TextView(this); title.setText("مسیریاب تهران و حومه"); title.setTextSize(20); title.setTextColor(Color.BLACK); title.setGravity(Gravity.CENTER); title.setPadding(8,18,8,18); root.addView(title);
        TextView note = new TextView(this); note.setText("قالب اولیه برنامه آماده است؛ نقشه آفلاین و محاسبه مسیر هنوز اضافه نشده‌اند."); note.setTextColor(Color.DKGRAY); note.setTextSize(16); note.setPadding(16,12,16,12); root.addView(note);
        map = new MapView(this); map.setMultiTouchControls(true); map.getController().setZoom(10.0); map.getController().setCenter(new GeoPoint(35.6892, 51.3890)); root.addView(map, new LinearLayout.LayoutParams(-1, 0, 1));
        setContentView(root);
    }
    @Override protected void onResume() { super.onResume(); if (map != null) map.onResume(); }
    @Override protected void onPause() { if (map != null) map.onPause(); super.onPause(); }
}
