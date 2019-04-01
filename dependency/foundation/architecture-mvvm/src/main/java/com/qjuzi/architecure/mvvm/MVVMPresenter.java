/*
 * Copyright (C) 2019 Godya. All Rights Reserved.
 */
package com.qjuzi.architecure.mvvm;

import android.arch.lifecycle.LifecycleObserver;

public abstract class MVVMPresenter<S> implements LifecycleObserver {

    public S page;

    public void setComponent(S page) {
        this.page = page;
    }

}
