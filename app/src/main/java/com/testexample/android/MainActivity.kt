package com.testexample.android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.facebook.ads.AdView
import com.facebook.ads.AdSize
import com.facebook.ads.Ad
import android.widget.Toast
import com.facebook.ads.AdError
import com.facebook.ads.AdListener

class MainActivity : AppCompatActivity() {

    var mLayout: LinearLayout? = null
    private var adView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mLayout = findViewById(R.id.banner_container)
//683460265377899_914442452279679
        adView = AdView(this, "683460265377899_914442452279679", AdSize.BANNER_HEIGHT_50)

        // Add the ad view to your activity layout
        mLayout!!.addView(adView)

        adView!!.setAdListener(object : AdListener {
            override fun onError(ad: Ad, adError: AdError) {
                // Ad error callback
                Toast.makeText(this@MainActivity, "Error: " + adError.errorMessage,
                        Toast.LENGTH_LONG).show()
            }

            override fun onAdLoaded(ad: Ad) {
                // Ad loaded callback
            }

            override fun onAdClicked(ad: Ad) {
                // Ad clicked callback
            }

            override fun onLoggingImpression(ad: Ad) {
                // Ad impression logged callback
            }
        })
        // Request an ad
        adView!!.loadAd();

    }
    override fun onDestroy() {
        if (adView != null) {
            adView!!.destroy();
        }
        super.onDestroy()
    }

/*
     fun openPdf(view: View) {

        val mFile = File(Environment.getRootDirectory().absolutePath + "/" + "pdf-sample")

        System.out.println("Testpdf $mFile ")
        val mIntent = Intent(Intent.ACTION_VIEW)
        mIntent.setDataAndType(Uri.fromFile(mFile), "application/pdf")
        mIntent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
        startActivity(mIntent)

    }
*/
}
