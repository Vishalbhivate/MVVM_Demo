package com.example.mvvm_demo.Model

import kotlinx.coroutines.delay

class UserRepository {
   suspend fun fetchUserData() : UserData {
       //mock api
        delay(2000)
        return UserData("John",25)


    }
}