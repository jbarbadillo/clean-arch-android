package com.javirock.cleanarchevents.ui.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.javirock.cleanarchevents.R;
import com.javirock.cleanarchevents.ui.presenters.RegistrationPresenter;


public class RegistrationActivity extends AppCompatActivity implements RegistrationView {
    private RegistrationPresenter presenter;
    private EditText userNameEditText;
    private EditText passwordEditText;
    private EditText emailEditText;
    private Button registerButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        presenter = new RegistrationPresenter(this);

    }
    private void createComponents(){
        registerButton = (Button) findViewById(R.id.btn_register);
        registerButton.setOnClickListener(onClickListener());

        userNameEditText = (EditText) findViewById(R.id.input_username);
        passwordEditText = (EditText) findViewById(R.id.input_password);
        emailEditText = (EditText) findViewById(R.id.input_email);
    }
    private View.OnClickListener onClickListener() {
        return new View.OnClickListener()
        {
            public void onClick(View v) {
                String userName = userNameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String email = emailEditText.getText().toString();
                presenter.onRegisterClicked(userName,password, email);
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

    }
}
