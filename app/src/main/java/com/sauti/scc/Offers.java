package com.sauti.scc;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.sauti.model.Model;

public class Offers extends AppCompatActivity implements View.OnClickListener {

    Model Industry;
    TextView IndustryDesc,IndustryCost;
    MaterialButton begin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        IndustryCost = findViewById(R.id.IndustryCost);
        IndustryDesc = findViewById(R.id.IndustryDesc);
        begin = findViewById(R.id.begin);

        begin.setOnClickListener(this);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            Industry = data.getParcelable("hashtags");
        }
        if (Industry != null) {
            IndustryDesc.setText(Industry.getDesc());
            IndustryCost.setText("Cost - "+Industry.getCost());
        }
    }
    @Override
    public void onClick(View v) {
        if(v == begin){
            // perform operations
        }
    }
}
