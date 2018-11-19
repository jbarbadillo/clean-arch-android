package com.javirock.cleanarchevents.ui.presenters;


import com.javirock.cleanarchevents.ui.views.RegistrationView;
import com.javirock.cleanarchevents.usecases.RegistrationModel;

public class RegistrationPresenter {
    private RegistrationView registrationView;
    private RegistrationModel registrationModel;

    public RegistrationPresenter(RegistrationView registrationView){
        this.registrationView = registrationView;
        this.registrationModel = new RegistrationModel();
    }
}
