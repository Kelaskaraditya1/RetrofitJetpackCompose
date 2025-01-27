package com.starkindustries.retrofitjetpackcompose.Api

import com.starkindustries.retrofitjetpackcompose.Data.UserData
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {

    @GET("/users")
    suspend fun getUsers(): Response<List<UserData>>
}