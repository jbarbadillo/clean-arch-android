package com.javirock.cleanarchevents.presentationlayer.presenters.impl;


import com.javirock.cleanarchevents.businesslayer.interactors.RegistrationInteractor;
import com.javirock.cleanarchevents.businesslayer.models.RegistrationModel;
import com.javirock.cleanarchevents.businesslayer.repositories.RegistrationRepository;
import com.javirock.cleanarchevents.presentationlayer.presenters.RegistrationPresenter;

public class RegistrationPresenterImpl implements RegistrationPresenter, RegistrationInteractor.CallBack{

    RegistrationPresenter.View view;
    RegistrationRepository registrationRepository;
    RegistrationInteractor registrationInteractor;

    public RegistrationPresenterImpl(View view, RegistrationRepository registrationRepository){
        this.view = view;
        this.registrationRepository = registrationRepository;
        this.registrationInteractor = new RegistrationInteractor(this, registrationRepository);
    }
    private boolean isValidFormat(String userName, String password, String email){
        return true;
    }
    @Override
    public void onRegisterClicked(String userName, String password, String email) {
        view.showProgress();
        if(isValidFormat(userName,password, email)){
            RegistrationModel data = new RegistrationModel(userName,password, email);
            registrationInteractor.requestRegistration(data);
        }else{
            view.showError("invalid data");
        }
    }

    @Override
    public void onRegistration(String user_id) {
        view.hideProgress();
        view.nextScreen();
    }

    @Override
    public void onRegistrationFailed(String error) {
        view.hideProgress();
        view.showError(error);
    }
}
