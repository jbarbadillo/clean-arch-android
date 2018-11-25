package com.javirock.cleanarchevents.presentationlayer.ui.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.javirock.cleanarchevents.R;
import com.javirock.cleanarchevents.businesslayer.models.UserModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class UserAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    Context context;
    private List<UserModel> userModelList = new ArrayList<>();

    @BindView(R.id.title)
    TextView titleView;
    @BindView(R.id.id)
    TextView idView;

    public UserAdapter(Context context){
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }
    public void addItems(List<UserModel> list){
        userModelList.clear();
        userModelList.addAll(list);
        notifyDataSetChanged();

    }
    @Override
    public int getCount() {
        return userModelList.size();
    }
    @Override
    public Object getItem(int position) {
        return userModelList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.user_view, viewGroup, false);
        }
        ButterKnife.bind(this, convertView);
        titleView.setText(userModelList.get(i).getLogin());
        idView.setText(String.valueOf(userModelList.get(i).getId()));

        return convertView;
    }


}
