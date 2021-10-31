package com.example.myapplication.ui.parametres

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ParametreViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "commande de la semaine"
    }
    val text: LiveData<String> = _text
}