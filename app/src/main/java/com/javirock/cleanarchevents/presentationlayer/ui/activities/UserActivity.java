package com.javirock.cleanarchevents.presentationlayer.ui.activities;


import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.javirock.cleanarchevents.R;
import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.presentationlayer.ui.adapters.UserAdapter;
import com.javirock.cleanarchevents.storage.UserListingRepository;
import com.javirock.cleanarchevents.di.component.DaggerListComponent;
import com.javirock.cleanarchevents.di.module.UserModule;
import com.javirock.cleanarchevents.presentationlayer.base.BaseActivity;
import com.javirock.cleanarchevents.presentationlayer.presenters.UserPresenter;
import com.javirock.cleanarchevents.presentationlayer.presenters.impl.UserPresenterImpl;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class UserActivity extends BaseActivity implements UserPresenter.View {
    @Inject
    UserListingRepository userListingRepository; // we dont know which implementation has


    @BindView(R.id.user_list)
    ListView userListView;
    UserAdapter userAdapter;

    private UserPresenter userPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userAdapter = new UserAdapter(this);
        userListView.setAdapter(userAdapter);

        userPresenter = new UserPresenterImpl(
                this,
                userListingRepository);

    }

    @Override
    protected void resolveDaggerDependency() {
        super.resolveDaggerDependency();
        DaggerListComponent.builder()
                .applicationComponent(getApplicationComponent())
                .userModule(new UserModule())
                .build().inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_user;
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.i("clean", "onResume");
        userPresenter.onResume();

    }
    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void nextScreen() {

    }

    @Override
    public void renderUsers(List<UserModel> userList) {
        Log.i("clean", "render users");
        userAdapter.addItems(userList);
    }
}
