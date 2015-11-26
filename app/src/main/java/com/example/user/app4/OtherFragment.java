package com.example.user.app4;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class OtherFragment extends Fragment {

    private OtherFragment instance;

    public static OtherFragment getInstance(String param1, String param2){
        OtherFragment other = new OtherFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param1",param1);
        bundle.putString("param2", param2);
        other.setArguments(bundle);
        return other;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_other, container, false);
        Bundle bundle = getArguments();
        if(bundle != null){
            String param1 = bundle.getString("param1");
            String param2 = bundle.getString("param2");
            TextView tvParam1 = (TextView)rootView.findViewById(R.id.tvParam1);
            TextView tvParam2 = (TextView)rootView.findViewById(R.id.tvParam2);
            tvParam1.setText(param1);
            tvParam2.setText(param2);
        }else {
            Toast.makeText(getActivity(), "Параметров нет, что странно!", Toast.LENGTH_SHORT).show();
        }
        return rootView;
    }
}
