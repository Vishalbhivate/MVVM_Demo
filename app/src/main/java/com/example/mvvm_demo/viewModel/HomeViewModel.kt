package com.example.mvvm_demo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_demo.Model.UserData
import com.example.mvvm_demo.Model.UserRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val userRepository : UserRepository = UserRepository()
    private val _userData = MutableLiveData<UserData>()
    val userData : LiveData<UserData> = _userData

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading : LiveData<Boolean> = _isLoading

    fun getUserData(){
        _isLoading.postValue(true)
        viewModelScope.launch {
        val userResult = userRepository.fetchUserData()
            _userData.postValue(userResult)
            _isLoading.postValue(false)

        }
    }
}