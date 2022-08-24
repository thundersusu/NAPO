package com.example.napo01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.SearchView;

import java.util.ArrayList;

public class CareerCertAdapter extends BaseAdapter {
    private ArrayList<CareerCertVO> certItems = new ArrayList<CareerCertVO>();


    @Override
    public int getCount() {
        return certItems.size();
    }

    @Override
    public Object getItem(int i) {
        return certItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.careercert_lv_copy, viewGroup, false);
        }


        CareerCertVO vo = certItems.get(i);
        SearchView cert_ser = view.findViewById(R.id.cert_ser);
        EditText certInst = view.findViewById(R.id.certInst);
        EditText certDate = view.findViewById(R.id.certDate);



        return null;
    }
}
