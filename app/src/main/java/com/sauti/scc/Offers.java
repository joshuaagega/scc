package com.sauti.scc;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.sauti.model.Model;

public class Offers extends AppCompatActivity implements View.OnClickListener {

    Model tags;
    TextView hashtags;
    ImageView copy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        copy = findViewById(R.id.copy);
        hashtags = findViewById(R.id.hashtags);

        copy.setOnClickListener(this);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            tags = data.getParcelable("hashtags");
        }
        if (tags != null) {
            hashtags.setText(tags.getTags());
        }
    }
    @Override
    public void onClick(View v) {
        if(v == copy){
            ClipboardManager clipBoard = (ClipboardManager) getSystemService(this.CLIPBOARD_SERVICE);
            ClipData hashtags = ClipData.newPlainText("Hashtags4Gain",tags.getTags());
            clipBoard.setPrimaryClip(hashtags);

            Snackbar.make(v,"HashTags Copied to ClipBoard \nTime for Gains", BaseTransientBottomBar.LENGTH_LONG).show();

        }
    }
}
