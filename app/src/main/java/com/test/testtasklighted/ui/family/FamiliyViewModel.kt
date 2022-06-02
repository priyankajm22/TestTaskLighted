package com.test.testtasklighted.ui.family

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FamiliyViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is family Fragment"
    }
    val text: LiveData<String> = _text
}