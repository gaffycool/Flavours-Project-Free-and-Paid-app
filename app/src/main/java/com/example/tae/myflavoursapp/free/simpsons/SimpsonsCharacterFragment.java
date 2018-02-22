package com.example.tae.myflavoursapp.free.simpsons;


import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tae.myflavoursapp.BuildConfig;
import com.example.tae.myflavoursapp.MainActivity;
import com.example.tae.myflavoursapp.R;
import com.example.tae.myflavoursapp.data.network.AppDataManager;
import com.example.tae.myflavoursapp.data.network.model.CharactersModel;
import com.example.tae.myflavoursapp.data.network.model.RelatedTopic;
import com.example.tae.myflavoursapp.ui.base.BaseFragment;
import com.example.tae.myflavoursapp.ui.utils.rx.AppSchedulerProvider;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpsonsCharacterFragment extends BaseFragment implements ISimpsonsMvpView {

    //@BindView(R.id.recycler)
    private RecyclerView recyclerView;
    private SimpsonsPresenterImpl<SimpsonsCharacterFragment> simpsonsCharacterFragmentSimpsonsPresenter;

    public SimpsonsCharacterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        simpsonsCharacterFragmentSimpsonsPresenter = new SimpsonsPresenterImpl<>(new AppDataManager(),
                new AppSchedulerProvider(), new CompositeDisposable());
        simpsonsCharacterFragmentSimpsonsPresenter.onAttach(this);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simpsons_character, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //refreshLayout = view.findViewById(R.id.swiperefresh);

        simpsonsCharacterFragmentSimpsonsPresenter.loadCharacters();
    }


    @Override
    public void onFetchDataProgress() {

    }

    @Override
    public void onFetchDataSuccess(CharactersModel charactersModel) {

        recyclerView.setAdapter(new SimpsonsAdapter(getActivity(), charactersModel.getRelatedTopics(), R.layout.row));
        Toast.makeText(getActivity(), "App version: " + BuildConfig.APP_VERSION, Toast.LENGTH_LONG).show();


    }


    @Override
    public void onFetchDataError(String error) {
        Toast.makeText(getActivity(), "error: " + error.toString(), Toast.LENGTH_LONG).show();

    }
}

