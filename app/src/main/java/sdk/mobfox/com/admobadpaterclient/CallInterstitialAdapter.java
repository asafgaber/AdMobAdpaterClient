package sdk.mobfox.com.admobadpaterclient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by asafg84 on 24/08/16.
 */
public class CallInterstitialAdapter extends Activity {
    InterstitialAd mInterstitialAd;
    Activity self;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interstitial_adapter);

        self = this;

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6224828323195096/1031427961");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                Log.d("AdMob", "ad closed");
                Toast.makeText(self, "closed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d("AdMob", "ad error");
                Toast.makeText(self, "error: " + errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLeftApplication() {
                Log.d("AdMob", "ad left");
                Toast.makeText(self, "left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                Log.d("AdMob", "ad opened");
                Toast.makeText(self, "opened", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLoaded() {
                Log.d("AdMob", "ad loaded");
                Toast.makeText(self, "loaded", Toast.LENGTH_SHORT).show();
                mInterstitialAd.show();
            }
        });
        final AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice("6800D96F6206D0CF803A06F07C39C674")
                .build();
        mInterstitialAd.loadAd(adRequest);

        Button loadBtn = (Button) findViewById(R.id.loadBtn);
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInterstitialAd.loadAd(adRequest);
            }
        });
    }
}