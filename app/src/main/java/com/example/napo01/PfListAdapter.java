package com.example.napo01;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PfListAdapter extends BaseAdapter {
    private ArrayList<PfListVO> pfItems = new ArrayList<PfListVO>();

    @Override
    public int getCount() {
        return pfItems.size();
    }

    @Override
    public Object getItem(int i) {
        return pfItems.get(i);
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
            view = inflater.inflate(R.layout.pofollist_in_lv, viewGroup, false);
        }

        PfListVO vo = pfItems.get(i);
        ImageView pf_img = view.findViewById(R.id.pf_img);
        TextView coDate = view.findViewById(R.id.tv_coDate);
        EditText pfTitle = view.findViewById(R.id.edt_pfTitle);

        pf_img.setImageDrawable(vo.getPf_img());
        coDate.setText(vo.getDate());
        pfTitle.setText(vo.getTitle());

        return view;
    }

    public void addItems(Drawable img, String date, String title){
        PfListVO vo = new PfListVO(img, date, title);
        pfItems.add(vo);
    }
}
