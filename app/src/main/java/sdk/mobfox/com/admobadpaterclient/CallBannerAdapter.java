package sdk.mobfox.com.admobadpaterclient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.mobfox.sdk.constants.Constants;

/**
 * Created by asafg84 on 24/08/16.
 */
public class CallBannerAdapter extends Activity {
    AdView mAdView;
    AdRequest adRequest;
    String tag = "MobFoxAdMobApp";
    Activity self;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.banner_adapter);
        self = this;
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6224828323195096~4390350360");
        mAdView = (AdView) findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                Toast.makeText(self, "on ad closed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d(Constants.MOBFOX_BANNER, "err: " + errorCode);
                Toast.makeText(self, "err: " + errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLeftApplication() {
                Toast.makeText(self, "on left app", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                Toast.makeText(self, "on ad opened", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLoaded() {
                Log.d(Constants.MOBFOX_BANNER, "loaded");
                Toast.makeText(self, "on ad loaded", Toast.LENGTH_SHORT).show();
            }
        });
        mAdView.loadAd(adRequest);

        Button loadBtn = (Button) findViewById(R.id.loadBtn);
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdView.loadAd(adRequest);
            }
        });
    }
}