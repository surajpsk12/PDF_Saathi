package com.surajvanshsv.pdfsaathinew.ui.home

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel



@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel(){

    val title = "PDF Saathi"
}