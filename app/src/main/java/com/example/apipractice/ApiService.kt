package com.example.apipractice

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users") // This is a GET request to fetch dummy users
    fun getUsers(): Call<List<User>> // Using Retrofit's Call type, not Android telecom Call
}