package com.sauti.scc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Admin extends AppCompatActivity implements View.OnClickListener {
TextInputEditText title,desc,cost;
Button add;
    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

        title = findViewById(R.id.title);
        desc= findViewById(R.id.desc);
        cost =findViewById(R.id.cost);

        add = findViewById(R.id.add);
        add.setOnClickListener(this);

        database = FirebaseDatabase.getInstance();
    }

    @Override
    public void onClick(View v) {
        if(v == add){
            String title_input,desc_input,cost_input;

            title_input = String.valueOf(title.getText());
            desc_input = String.valueOf(desc.getText());
            cost_input = String.valueOf(cost.getText());

            if(title_input.trim().length()>0 && desc_input.trim().length() >0 && cost_input.trim().length()>0){
                myRef = database.getReference().child("Industries").push();
                myRef.child("Title").setValue(title_input);
                myRef.child("desc").setValue(desc_input);
                myRef.child("cost").setValue(cost_input);

                Toast.makeText(this,"Industry added Successfully",Toast.LENGTH_LONG).show();
                // reset
                title.setText("");
                desc.setText("");
                cost.setText("");

            }
            else{
                Toast.makeText(this,"Check Inputs",Toast.LENGTH_LONG).show();
            }
        }
    }
}