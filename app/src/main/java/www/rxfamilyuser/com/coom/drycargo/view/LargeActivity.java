package www.rxfamilyuser.com.coom.drycargo.view;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import uk.co.senab.photoview.PhotoView;
import www.rxfamilyuser.com.R;

/**
 * 大图
 */
public class LargeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = getIntent().getStringExtra("url");
        setContentView(R.layout.activity_large);

        PhotoView iv = (PhotoView) findViewById(R.id.iv);
        Glide.with(getApplicationContext()).load(url).asBitmap().fitCenter().into(iv);
        ViewCompat.setTransitionName(iv, "image");
    }
}
