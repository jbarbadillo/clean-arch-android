package com.javirock.cleanarchevents.presentationlayer.ui.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.javirock.cleanarchevents.R;
import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.data.UserRepositoryDatabase;
import com.javirock.cleanarchevents.di.module.UserModule;
import com.javirock.cleanarchevents.presentationlayer.base.BaseActivity;
import com.javirock.cleanarchevents.presentationlayer.presenters.UserPresenter;
import com.javirock.cleanarchevents.presentationlayer.presenters.impl.UserPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserActivity extends BaseActivity implements UserPresenter.View {
    private UserPresenter userPresenter;
    UserRepositoryDatabase userRepositoryDatabase;

    @BindView(R.id.usernameTextView)
    TextView userName;

    @BindView(R.id.emailTextView)
    TextView email;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userPresenter = new UserPresenterImpl(
                this,
                new UserRepositoryDatabase(this));

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

    }

    @Override
    public void nextScreen() {

    }

    @Override
    public void renderUser(UserModel user) {
        userName.setText(user.getUserName());
        email.setText(user.getEmail());
    }
}
