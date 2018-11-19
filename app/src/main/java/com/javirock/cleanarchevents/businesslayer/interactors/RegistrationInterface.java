package com.javirock.cleanarchevents.businesslayer.interactors;


public interface RegistrationInterface {
    interface CallBack{
        void onRegistration(String user_id);
        void onRegistrationFailed(String error);
    }
}
