package com.example.apipractice

import retrofit2.Call

class UserRepository {
    fun getUsers(): Call<List<User>>{
        return RetrofitInstance.api.getUsers()

    }

}