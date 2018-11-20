package com.javirock.cleanarchevents.presentationlayer.presenters.impl;


import com.javirock.cleanarchevents.businesslayer.interactors.RegistrationInteractor;
import com.javirock.cleanarchevents.businesslayer.repositories.RegistrationRepository;
import com.javirock.cleanarchevents.presentationlayer.presenters.RegistrationPresenter;

public class RegistrationPresenterImpl implements RegistrationPresenter, RegistrationInteractor.CallBack{

    RegistrationPresenter.View view;
    RegistrationRepository registrationRepository;
    RegistrationInteractor registrationInteractor;

    RegistrationPresenterImpl(View view, RegistrationRepository registrationRepository){
        this.view = view;
        this.registrationRepository = registrationRepository;
        this.registrationInteractor = new RegistrationInteractor(this, registrationRepository);
    }
    @Override
    public void onRegisterClicked(String userName, String password, String email) {

    }

    @Override
    public void onRegistration(String user_id) {

    }

    @Override
    public void onRegistrationFailed(String error) {

    }
}
