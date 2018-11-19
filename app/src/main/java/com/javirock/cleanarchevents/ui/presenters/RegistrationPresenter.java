package com.javirock.cleanarchevents.ui.presenters;


import com.javirock.cleanarchevents.entities.RegistrationData;
import com.javirock.cleanarchevents.ui.views.RegistrationView;
import com.javirock.cleanarchevents.usecases.RegistrationModel;

public class RegistrationPresenter {
    private RegistrationView registrationView;
    private RegistrationModel registrationModel;

    public RegistrationPresenter(RegistrationView registrationView){
        this.registrationView = registrationView;
        this.registrationModel = new RegistrationModel();
    }
    public void onRegisterClicked(String userName, String password, String email){

        if(isValidFormat(userName,password, email)){
            requestRegistrationFromModel(new RegistrationData(userName,password, email));
        }else{
            registrationView.showError("invalid data");
        }
    }
    private boolean isValidFormat(String userName, String password, String email){
        return true;
    }
    private void requestRegistrationFromModel(RegistrationData data){

        registrationView.showProgress();

        registrationModel.requestRegistration(data);

        registrationView.hideProgress();

    }
}
