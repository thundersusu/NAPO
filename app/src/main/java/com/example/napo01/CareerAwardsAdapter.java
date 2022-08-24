package com.example.napo01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.ArrayList;

public class CareerAwardsAdapter extends BaseAdapter {

    private ArrayList<CareerAwardsVO> awardsItems = new ArrayList<CareerAwardsVO>();

    @Override
    public int getCount() {
        return awardsItems.size();
    }

    @Override
    public Object getItem(int i) {
        return awardsItems.get(i);
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
            view = inflater.inflate(R.layout.careerawards_lv, viewGroup, false);
        }

        CareerAwardsVO vo = awardsItems.get(i);
        EditText awardsName = view.findViewById(R.id.awardsName);
        EditText awardsInst = view.findViewById(R.id.awardsInst);
        EditText awardsDate = view.findViewById(R.id.awardsDate);
       awardsName.setText(vo.getName());
       awardsInst.setText(vo.getInst());
       awardsDate.setText(vo.getDate());

        return view;
    }

        public void addItems(String name, String inst, String date){
            CareerAwardsVO vo = new CareerAwardsVO(name, inst, date);
            awardsItems.add(vo);
        }
        public void setItems(String name, String inst, String date){
            CareerAwardsVO vo = new CareerAwardsVO(name, inst, date);
            awardsItems.get(0);
        }
}
