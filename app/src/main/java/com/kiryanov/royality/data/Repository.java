package com.kiryanov.royality.data;

import android.content.Context;

import com.kiryanov.royality.CurrentUser;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Repository {

    private Api api;

    public Repository(Api api, Context context) {
        this.api = api;
    }

    public Observable<Shop> loadShopList() {
        int userId = CurrentUser.getInstance().getCurrentUserId();

        Observable<Shop> observable1 = getShopObservable(api.connect1(), 0, userId);
        Observable<Shop> observable2 = getShopObservable(api.connect2(), 1, userId);
        Observable<Shop> observable3 = getShopObservable(api.connect3(), 2, userId);

        return Observable.concat(observable1, observable2, observable3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private Observable<Shop> getShopObservable(Observable<List<CordaUser>> connect, int num, int userId) {
        return connect
                .flatMap(Observable::fromIterable)
                .filter(cordaUser -> cordaUser.getCorId() == userId)
                .toList()
                .toObservable()
                .flatMap(Observable::fromIterable)
                .map(cordaUser -> {
                    Shop shop = MockData.getShopList().get(num);
                    shop.setBill(cordaUser.getBill());

                    return shop;
                });
    }

    public Observable<Coalition> loadCoalitionList() {
        int userId = CurrentUser.getInstance().getCurrentUserId();

        return Observable.just(MockData.getCoalition())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        /*return api.connectCoalition()
                .flatMap(Observable::fromIterable)
                .filter(cordaUser -> cordaUser.getCorId() == userId)
                .toList()
                .toObservable()
                .flatMap(Observable::fromIterable)
                .map(cordaUser -> {
                    CoalitionView coalition = MockData.getCoalition();
                    coalition.setBill(cordaUser.getBill());

                    return coalition;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());*/
    }
}
