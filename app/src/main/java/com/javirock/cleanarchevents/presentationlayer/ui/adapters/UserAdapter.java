package com.javirock.cleanarchevents.presentationlayer.ui.adapters;

import android.content.Context;
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

    public UserAdapter(Context context){
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }
    public void addItems(List<UserModel> userModelList){
        userModelList.addAll(userModelList);
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
        View view = LayoutInflater.from(context).inflate(R.layout.user_view, null);
        ButterKnife.bind(this, view);
        titleView.setText(userModelList.get(i).getLogin());
        return view;
    }

    @BindView(R.id.title)
    TextView titleView;
}
