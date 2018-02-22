package com.example.tae.myflavoursapp.free.simpsons;

import android.util.Log;

import com.example.tae.myflavoursapp.R;
import com.example.tae.myflavoursapp.data.network.DataManager;
import com.example.tae.myflavoursapp.data.network.model.CharactersModel;
import com.example.tae.myflavoursapp.data.network.model.RelatedTopic;
import com.example.tae.myflavoursapp.ui.base.BasePresenter;
import com.example.tae.myflavoursapp.ui.utils.rx.SchedulerProvider;

import butterknife.BindView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by TAE on 21-Feb-18.
 */

public class SimpsonsPresenterImpl <V extends ISimpsonsMvpView>
extends BasePresenter<V>
implements ISimpsonsPresenter<V>{


    public SimpsonsPresenterImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadCharacters() {

        getCompositeDisposable()
                .add(getDataManager().getCharactersList()
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(new Consumer<CharactersModel>() {
                            @Override
                            public void accept(CharactersModel charactersModel) throws Exception {

                                getMvpView().onFetchDataSuccess(charactersModel);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.i("error", throwable.getMessage());
                            }
                        })
                );

    }
}
