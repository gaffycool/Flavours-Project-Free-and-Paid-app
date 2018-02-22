package com.example.tae.myflavoursapp.free.simpsons;

import com.example.tae.myflavoursapp.ui.base.MvpPresenter;

/**
 * Created by TAE on 21-Feb-18.
 */

public interface ISimpsonsPresenter <V extends ISimpsonsMvpView> extends MvpPresenter<V>{

    void loadCharacters();

}
