package com.kiryanov.royality.mvp;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public class BasePresenter<View extends MvpView> extends MvpPresenter<View> {

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    protected void unsubscribeOnDestroy(@NonNull Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        mCompositeDisposable.clear();
        super.onDestroy();
    }
}
