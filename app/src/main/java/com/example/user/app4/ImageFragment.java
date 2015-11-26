package com.example.user.app4;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_image,container,false);
        ImageView image = (ImageView)rootView.findViewById(R.id.image);
        Glide.with(getActivity())
                .load("http://wpapers.ru/wallpapers/animals/Leons/2729/PREV_%D0%A0%D0%B8%D1%81%D0%BE%D0%B2%D0%B0%D0%BD%D0%BD%D0%B0%D1%8F-%D0%BC%D0%BE%D1%80%D0%B4%D0%B0-%D0%9B%D1%8C%D0%B2%D0%B0.jpg")
                .into(image);
        return rootView;
    }
}
