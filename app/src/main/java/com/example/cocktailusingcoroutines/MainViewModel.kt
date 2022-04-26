package com.example.cocktailusingcoroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    var recyclerListLiveData = MutableLiveData<RecyclerListModel>()
    init {
        recyclerListLiveData= MutableLiveData()
    }
    fun getRecyclerListObserver():MutableLiveData<RecyclerListModel>{
        return  recyclerListLiveData
    }
    fun makeApiCall() {
        // Create a new coroutine to move the execution off the UI thread
        viewModelScope.launch(Dispatchers.IO) {
        val mainInstance=MainInstance.getRetroInstance().create(MainServices::class.java)
            val response= mainInstance.getList()
            recyclerListLiveData.postValue(response)
        }
    }
}


