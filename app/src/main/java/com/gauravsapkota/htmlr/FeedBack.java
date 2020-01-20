package com.gauravsapkota.htmlr;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class FeedBack extends AppCompatActivity {
    ImageView googleplus;
    ImageView twitter;
    ImageView facebook;
    ImageView youtube;
    AdView adView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        googleplus = (ImageView)this.findViewById(R.id.imageView9);
        twitter =(ImageView)this.findViewById(R.id.twitter);
        facebook =(ImageView)this.findViewById(R.id.facebook) ;
        youtube =(ImageView)findViewById(R.id.youtube);
        adView2 =(AdView)this.findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView2.loadAd(adRequest);

        googleplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri googleplus = Uri.parse("https://plus.google.com/u/0/103985644714434788521");
                Intent intent = new Intent(Intent.ACTION_VIEW,googleplus);
                startActivity(intent);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri twitter = Uri.parse("https://twitter.com/Tech_Revival");
                Intent intent = new Intent(Intent.ACTION_VIEW,twitter);
                startActivity(intent);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri facebook = Uri.parse("https://facebook.com/Tech-Revival-188485011791330");
                Intent intent = new Intent(Intent.ACTION_VIEW,facebook);
                startActivity(intent);
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri yt = Uri.parse("https://youtube.com");
                Intent intent = new Intent(Intent.ACTION_VIEW,yt);
                startActivity(intent);
            }
        });

    }
}
