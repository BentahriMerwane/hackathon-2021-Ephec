package com.example.myapplication.ui.parametres

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ParametreViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Ttestt"
    }
    val text: LiveData<String> = _text
}