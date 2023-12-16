package com.example.matikkapeli.screens.peli

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.RoomDatabase
import androidx.room.Update


class peliViewModel : ViewModel(){

    //var pisteet = 0

    //var secondscount = 0

    private val _pisteet = MutableLiveData<Int>()
    val pisteet: LiveData<Int>
        get() = _pisteet



    val currentNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val numero1: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val numero2: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }


    val secondscount: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    //private var handler = Handler()
    //private lateinit var runnable: Runnable


    fun setQuestion() {
        numero1.value = (0..10).random()
        numero2.value = (0..10).random()
    }

    fun savePisteet(result: RoomDatabase) {
        //Tähän funktio jolla voi tallentaa dataan
        database.update(_pisteet)
    }


    fun startTimer() {

    }

    fun stopTimer() {

    }





        fun checkAnswer(testi: String) {
            try {
                var final_ansver = testi.toInt()
                if ((numero1.value!! + numero2.value!!) == final_ansver) {
                    if (_pisteet.value == null) {
                        _pisteet.value = 1
                    } else {
                        _pisteet.value = _pisteet.value?.plus(1);
                    }
                }
            } catch (e: Exception) {
                //Probably not int value in testi
            }

            setQuestion()
        }


    }
