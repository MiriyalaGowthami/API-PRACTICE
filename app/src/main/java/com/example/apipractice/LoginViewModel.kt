package com.example.apipractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel:ViewModel() {
    private val repository=UserRepository()
    val users=MutableLiveData<List<User>>()
    val errorMessage = MutableLiveData<String>()

    fun fetchUsers() {
        val response = repository.getUsers()
        response.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    users.postValue(response.body())
                } else {
                    errorMessage.postValue("Failed to load users")
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
    fun validateUser(email: String, password: String): User? {
        val userList = users.value ?: return null
        for (user in userList) {
            if (user.email == email && user.name == password) { // Simplified validation
                return user
            }
        }
        return null
    }


}