package com.javirock.cleanarchevents.presentationlayer.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.javirock.cleanarchevents.R;
import com.javirock.cleanarchevents.data.RegistrationRepositoryDatabase;
import com.javirock.cleanarchevents.presentationlayer.presenters.RegistrationPresenter;
import com.javirock.cleanarchevents.presentationlayer.presenters.impl.RegistrationPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RegistrationActivity extends AppCompatActivity implements RegistrationPresenter.View {
    private RegistrationPresenter registrationPresenter;

    @BindView(R.id.input_username)
    EditText userNameEditText;

    @BindView(R.id.input_password)
    EditText passwordEditText;

    @BindView(R.id.input_email)
    EditText emailEditText;

    @BindView(R.id.btn_register)
    Button registerButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        ButterKnife.bind(this);
        createComponents();
        registrationPresenter = new RegistrationPresenterImpl(
                this,
                new RegistrationRepositoryDatabase(this));

    }
    private void createComponents(){
        registerButton.setOnClickListener(onClickListener());
    }
    private View.OnClickListener onClickListener() {
        return new View.OnClickListener()
        {
            public void onClick(View v) {
                String userName = userNameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String email = emailEditText.getText().toString();
                registrationPresenter.onRegisterClicked(userName,password, email);
            }
        };
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
        Intent activity = new Intent(this, UserActivity.class);
        startActivity(activity);

    }
}
