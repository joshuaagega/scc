package com.sauti.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sauti.adapter.IndustryAdapter;
import com.sauti.model.Model;
import com.sauti.scc.R;

import java.util.ArrayList;

public class IndustryFragment extends Fragment {
    RecyclerView RecyclerView;
    public ArrayList<Model> IndustryList = new ArrayList<>();
    IndustryAdapter Adapter;
    FirebaseDatabase database;
    DatabaseReference myRef;

    public IndustryFragment(){}
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView = view.findViewById(R.id.RecyclerView);
        database = FirebaseDatabase.getInstance();
        getIndustries();

    }

    private void getIndustries() {

        myRef = database.getReference().child("Industries");
        myRef.keepSynced(true);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                RecyclerView.setVisibility(View.GONE);
                IndustryList.clear();
                for (DataSnapshot snapshot_item : snapshot.getChildren()){
                    Model industry = snapshot_item.getValue(Model.class);
                    IndustryList.add(industry);
                }
                RecyclerView.setVisibility(View.VISIBLE);
                setAdapter();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println(error);
            }
        });
    }
    private void setAdapter() {
        Adapter = new IndustryAdapter(getContext(), IndustryList,getActivity());
        Adapter.notifyDataSetChanged();
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        RecyclerView.setLayoutManager(layoutManager);
        RecyclerView.setHasFixedSize(true);
        RecyclerView.setAdapter(Adapter);

    }

}
