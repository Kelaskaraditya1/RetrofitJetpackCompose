package com.starkindustries.retrofitjetpackcompose.Api

import android.provider.ContactsContract.CommonDataKinds.Note
import com.starkindustries.retrofitjetpackcompose.Data.Notes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface NotesApi {
    @GET("/get-notes")
    suspend fun getNotes(): Response<List<Notes>>

    @POST("/insert")
    suspend fun addNote(@Body note:Notes):Response<Notes>

    @PUT("/update/{id}")
    suspend fun updateNote(@Body note:Notes,@Path("id") noteId:Int):Response<Notes>

    @DELETE("delete/{noteId}")
    suspend fun deleteNote(@Path("noteId") noteId:Int):Response<String>
}