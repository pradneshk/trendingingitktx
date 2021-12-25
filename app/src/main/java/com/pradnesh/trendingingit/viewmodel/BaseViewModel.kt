package com.pradnesh.trendingingit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {

    private val _isEmpty: MutableLiveData<Boolean> = MutableLiveData(true)
    val isEmpty: LiveData<Boolean> get() = _isEmpty

    private val _dataLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val dataLoading: LiveData<Boolean> get() = _dataLoading

    private val _toastMessage: MutableLiveData<String> = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage

}