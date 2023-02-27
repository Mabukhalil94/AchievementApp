package com.example.achievement.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.achievement.data.RepositoryRecord
import com.example.achievement.data.model.AchievementResponseModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = RepositoryRecord()

    private val _successLiveData: MutableLiveData<List<AchievementResponseModel>> = MutableLiveData()
    val successLiveData: LiveData<List<AchievementResponseModel>> =_successLiveData

    private val _errorLiveData: MutableLiveData<Exception> = MutableLiveData()
    val errorLiveData: LiveData<Exception> = _errorLiveData

    private val _loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val loadingLiveData: LiveData<Boolean> = _loadingLiveData

    init{
        getWrapperRecord()
    }

    private fun getWrapperRecord(){
        viewModelScope.launch {
            _loadingLiveData.postValue(true)
            try {
                val response = repository.getWrapperAchieve()
                _successLiveData.postValue(response)
            }catch (e: Exception){
                Log.d("TAG", "getWrapperRecord:${e.localizedMessage} ")
                _errorLiveData.postValue(e)
            }
            _loadingLiveData.postValue(false)
        }
    }

}