package com.test.testtasklighted.ui.contribution

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContributionViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is contribution Fragment"
    }
    val text: LiveData<String> = _text
}