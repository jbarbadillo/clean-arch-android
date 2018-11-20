package com.javirock.cleanarchevents.presentationlayer.ui.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.javirock.cleanarchevents.R;
import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.data.UserRepositoryDatabase;
import com.javirock.cleanarchevents.presentationlayer.presenters.UserPresenter;
import com.javirock.cleanarchevents.presentationlayer.presenters.impl.UserPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserActivity extends AppCompatActivity implements UserPresenter.View {
    private UserPresenter userPresenter;

    @BindView(R.id.usernameTextView)
    EditText userName;

    @BindView(R.id.emailTextView)
    EditText email;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        ButterKnife.bind(this);
        userPresenter = new UserPresenterImpl(
                this,
                new UserRepositoryDatabase(this));

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
