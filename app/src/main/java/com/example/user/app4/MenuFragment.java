package com.example.user.app4;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment implements View.OnClickListener {

    private Button btnOpen4pda;
    private Button btnImage;
    private Button btnPage1;
    private Button btnPage2;
    private Button btnPage3;
    private Button btnJson;

    public static final int BTN_4PDA = 1;
    public static final int BTN_IMAGE = 2;
    public static final int BTN_PAGE_1 = 3;
    public static final int BTN_PAGE_2 = 4;
    public static final int BTN_PAGE_3 = 5;
    public static final int BTN_JSON = 6;

    public interface OnBtnPress {
        public void btnPressed(int btn);
    }

    private OnBtnPress listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);
        btnOpen4pda = (Button) rootView.findViewById(R.id.btnOpen4pda);
        btnImage = (Button) rootView.findViewById(R.id.btnOpenImage);
        btnPage1 = (Button) rootView.findViewById(R.id.btnPage1);
        btnPage2 = (Button) rootView.findViewById(R.id.btnPage2);
        btnPage3 = (Button) rootView.findViewById(R.id.btnPage3);
        btnJson = (Button) rootView.findViewById(R.id.btnPage4);
        setOnClickListener();
        return rootView;
    }

    private void setOnClickListener() {
        btnOpen4pda.setOnClickListener(this);
        btnImage.setOnClickListener(this);
        btnPage1.setOnClickListener(this);
        btnPage2.setOnClickListener(this);
        btnPage3.setOnClickListener(this);
        btnJson.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            switch (v.getId()) {
                case R.id.btnOpen4pda:
                    listener.btnPressed(BTN_4PDA);
                    break;
                case R.id.btnOpenImage:
                    listener.btnPressed(BTN_IMAGE);
                    break;
                case R.id.btnPage1:
                    listener.btnPressed(BTN_PAGE_1);
                    break;
                case R.id.btnPage2:
                    listener.btnPressed(BTN_PAGE_2);
                    break;
                case R.id.btnPage3:
                    listener.btnPressed(BTN_PAGE_3);
                    break;
                case R.id.btnPage4:
                    listener.btnPressed(BTN_JSON);
                    break;
            }
        }
    }

    public void setBtnPressListener(OnBtnPress listener) {
        this.listener = listener;
    }

    public void removeBtnPressListener() {
        this.listener = null;
    }
}
