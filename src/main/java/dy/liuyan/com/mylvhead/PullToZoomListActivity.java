package dy.liuyan.com.mylvhead;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import dy.liuyan.com.mylvhead.pulltozoomview.PullToZoomListViewEx;

/**
 * Created by apple on 2016/9/23.下午3:18
 */

public class PullToZoomListActivity extends AppCompatActivity {

    private PullToZoomListViewEx listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_zoom_list_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = (PullToZoomListViewEx) findViewById(R.id.listview);
        String[] adapterData = new String[]{"Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient"};
        listView.setAdapter(new ArrayAdapter<>(PullToZoomListActivity.this, android.R.layout.simple_list_item_1, adapterData));
        listView.getPullRootView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("TAG", "position = " + position);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("TAG", "position = " + position);
            }
        });
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        AbsListView.LayoutParams localObject = new AbsListView.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        listView.setHeaderLayoutParams(localObject);
    }
}
