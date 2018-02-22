package com.example.tae.myflavoursapp.free.simpsons;

import com.example.tae.myflavoursapp.data.network.model.CharactersModel;
import com.example.tae.myflavoursapp.data.network.model.RelatedTopic;
import com.example.tae.myflavoursapp.ui.base.MvpView;

/**
 * Created by TAE on 21-Feb-18.
 */

public interface ISimpsonsMvpView extends MvpView{

    void onFetchDataProgress();
    void onFetchDataSuccess(CharactersModel charactersModel);
    void onFetchDataError(String error);
}
