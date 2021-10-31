package com.example.myapplication.ui.choix

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChoixViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "votre commande de la semaine"
    }
    val text: LiveData<String> = _text
}