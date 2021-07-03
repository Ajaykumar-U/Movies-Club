package com.android.moviesClub.ui.base;

public interface BaseContractPresenter<T> {

    void attachView(T view);

    void dropView();
}
