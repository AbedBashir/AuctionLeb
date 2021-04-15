package com.example.auctionleb.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.auctionleb.ContactsUs;
import com.example.auctionleb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Settings_fragment extends Fragment {
    Button contactUs,Website;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings,container,false);

        contactUs=v.findViewById(R.id.ContactUs);
        Website=v.findViewById(R.id.WebsiteBtn);

        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ContactsUs.class);
                startActivity(intent);            }
        });

        Website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.google.com"));
                startActivity(intent);
            }
        });




     return v;
    }
}
