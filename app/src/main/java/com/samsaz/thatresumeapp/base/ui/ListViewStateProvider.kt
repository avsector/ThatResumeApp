package com.samsaz.thatresumeapp.base.ui

import androidx.lifecycle.MutableLiveData

interface ListViewStateProvider<T> {
    val liveData: MutableLiveData<List<T>>
    val loadingLiveData: MutableLiveData<ViewLoadingState>

    fun refresh()
}