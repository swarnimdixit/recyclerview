package com.example.swarnim_d.cardviewlist;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDescription extends AppCompatActivity {
    ImageView descriptionImg;
    TextView descriptionText;
    TextView descriptionDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        descriptionText = (TextView)findViewById(R.id.desc_text);
        descriptionDesc = (TextView)findViewById(R.id.desc_description);
        descriptionImg = (ImageView)findViewById(R.id.desc_image);

        Intent intent = getIntent();
        String incomingText = intent.getStringExtra("toDescText");
        String incomingDesc = intent.getStringExtra("toDescDesc");

        descriptionText.setText(incomingText);
        descriptionDesc.setText(incomingDesc);

    }
}
