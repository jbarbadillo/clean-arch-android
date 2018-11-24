package com.javirock.cleanarchevents.di.component;

import com.javirock.cleanarchevents.di.module.UserModule;
import com.javirock.cleanarchevents.di.scope.PerActivity;
import com.javirock.cleanarchevents.presentationlayer.ui.activities.UserActivity;

import dagger.Component;

@PerActivity
@Component(modules= UserModule.class, dependencies = ApplicationComponent.class)
public interface ListComponent {
    void inject(UserActivity activity);
}
