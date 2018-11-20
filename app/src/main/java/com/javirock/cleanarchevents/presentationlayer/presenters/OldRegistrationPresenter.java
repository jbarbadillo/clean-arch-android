package com.javirock.cleanarchevents.presentationlayer.presenters;


import com.javirock.cleanarchevents.businesslayer.models.RegistrationModel;
import com.javirock.cleanarchevents.presentationlayer.views.RegistrationView;
import com.javirock.cleanarchevents.businesslayer.interactors.RegistrationInteractor;

public class OldRegistrationPresenter {
    private RegistrationView registrationView;
    private RegistrationInteractor registrationModel;

    public OldRegistrationPresenter(RegistrationView registrationView){
        this.registrationView = registrationView;
        this.registrationModel = new RegistrationInteractor();
    }
    public void onRegisterClicked(String userName, String password, String email){

        if(isValidFormat(userName,password, email)){
            requestRegistrationFromModel(new RegistrationModel(userName,password, email));
        }else{
            registrationView.showError("invalid data");
        }
    }
    private boolean isValidFormat(String userName, String password, String email){
        return true;
    }
    private void requestRegistrationFromModel(RegistrationModel data){

        registrationView.showProgress();

        registrationModel.requestRegistration(data);

        registrationView.hideProgress();

    }
}
