package com.example.viewmodelexample2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel:ViewModel() {
    var counter = MutableLiveData<Int>(0)

    fun add() {
        var cnt:Int = counter.value ?: 0
        counter.value = cnt + 1
    }

    fun reset() {
        counter.value = 0
    }

}
