package com.android.moviesClub.base;

public interface BaseContractPresenter<T> {

    void attachView(T view);

    void dropView();
}
