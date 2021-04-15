package com.example.auctionleb.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.auctionleb.Adapters.VerticalRecyclerViewAdapter;
import com.example.auctionleb.Models.HorizontalModel;
import com.example.auctionleb.Models.VerticalModel;
import com.example.auctionleb.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_fragment extends Fragment {
    private RecyclerView rvVertical;

    private ArrayList<VerticalModel> mArrayList = new ArrayList<>();
    private VerticalRecyclerViewAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View rootview = inflater.inflate(R.layout.fragment_home,container,false);
//
//        rvVertical = rootview.findViewById(R.id.rvVertical);
//
//        rvVertical.setLayoutManager(new LinearLayoutManager(getContext()));
//        rvVertical.setAdapter(new VerticalRecyclerViewAdapter(getContext(),mArrayList));
//        return rootview;
//        return inflater.inflate(R.layout.fragment_home,container,false);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rvVertical);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        VerticalRecyclerViewAdapter recyclerViewAdapter = new VerticalRecyclerViewAdapter(getActivity(),mArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
        setDataOnVerticalRecyclerView();
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        setDataOnVerticalRecyclerView();

//        rvVertical.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
//        mAdapter = new VerticalRecyclerViewAdapter(getContext(),mArrayList);
//        rvVertical.setAdapter(mAdapter);
//        setDataOnVerticalRecyclerView();

//        LinearLayoutManager manager = new LinearLayoutManager(getContext());
//        rvVertical.setLayoutManager(manager);
//        rvVertical.setHasFixedSize(true);
//        mAdapter= new VerticalRecyclerViewAdapter(getContext(),mArrayList);
//        rvVertical.setAdapter(mAdapter);


    }




    private void setDataOnVerticalRecyclerView() {
        for (int i = 1; i <= 20; i++) {

            VerticalModel mVerticalModel = new VerticalModel();

            mVerticalModel.setTitle("Title " + i);

            ArrayList<HorizontalModel> arrayList = new ArrayList<>();

            for (int j = 0; j <= 30; j++) {
                HorizontalModel mHorizontalModel = new HorizontalModel();
                mHorizontalModel.setDescription("Description : " + j);
                mHorizontalModel.setName("Name : " + j);
                arrayList.add(mHorizontalModel);
            }

            mVerticalModel.setArrayList(arrayList);

            mArrayList.add(mVerticalModel);
        }
//        mAdapter.notifyDataSetChanged();
    }


}