package com.javirock.cleanarchevents.presentationlayer.base;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.javirock.cleanarchevents.application.MainApplication;
import com.javirock.cleanarchevents.di.component.ApplicationComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity{
    Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        unbinder = ButterKnife.bind(this);
        onViewReady(savedInstanceState, getIntent());
    }

    @CallSuper
    protected void onViewReady(Bundle savedInstanceState, Intent intent){
        resolveDaggerDependency();
    }

    protected ApplicationComponent getApplicationComponent(){
        // The main aplication is MainApplication in this project
        return ((MainApplication) getApplication()).getApplicationComponent();
    }
    protected void resolveDaggerDependency(){

    }
    protected abstract int getContentView();

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();

    }
}
