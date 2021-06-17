package com.f4dplay.mobile.sd.kointest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> get() = _count

    init {
        _count.postValue(repository.count)
    }

    fun increaseCount() {
        _count.value = (count.value!! + 1)
    }

    fun decreaseCount() {
        _count.value = (count.value!! - 1)
    }
}