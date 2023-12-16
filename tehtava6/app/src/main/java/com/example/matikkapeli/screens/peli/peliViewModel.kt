package com.example.matikkapeli.screens.peli

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class peliViewModel : ViewModel() {

    var numero1 = 0
    var numero2 = 0

    var pisteet = 0

    val currentNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }





    fun lisaapiste(){
        pisteet++
    }




    fun setQuestion() {
        numero1 = (0..10).random()
        numero2 = (0..10).random()
    }


}