package com.starkindustries.retrofitjetpackcompose.Screens

import android.provider.ContactsContract.CommonDataKinds.Note
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.starkindustries.retrofitjetpackcompose.Api.RetrofitInstance
import com.starkindustries.retrofitjetpackcompose.Compose.UserRowCompose
import com.starkindustries.retrofitjetpackcompose.Data.Notes
import com.starkindustries.retrofitjetpackcompose.Data.UserData
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(){

    var coRoutineScope = rememberCoroutineScope()
    var notesList by remember{
        mutableStateOf<List<Notes?>>(emptyList())
    }

    var list = listOf<String>("Ironman","Batman","OptimusPrime","Red Ranger","DeadPool")

    LaunchedEffect(Unit) {
        try {
            val response = RetrofitInstance.api.getNotes()
            if (response.isSuccessful) {
                Log.d("API_RESPONSE", "Data: ${response.body()}")
                notesList = response.body() ?: emptyList()
            } else {
                Log.e("API_ERROR", "Error: ${response.errorBody()?.string()}")
            }
        } catch (e: Exception) {
            Log.e("API_EXCEPTION", "Exception: ${e.message}")
        }
    }


        Box(modifier = Modifier
            .fillMaxSize()
        , contentAlignment = Alignment.Center){
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp, start = 10.dp)
            , horizontalAlignment = Alignment.CenterHorizontally) {
                items(notesList){item->
                    if (item != null) {
                        Text(text = item.title, fontSize = 20.sp, fontWeight = FontWeight.W500, modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp)
                            .clickable {

                            })
                    }
                }
            }
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
            , contentAlignment = Alignment.BottomEnd){
                Column(modifier =Modifier
                    .padding(10.dp)) {
                    Button(onClick = {
                        var note = Notes(7,"Prime Optimus Prime","We Will Kill them all!!","26/01/2025")
                        coRoutineScope.launch {
                            try{
                                val response = RetrofitInstance.api.addNote(note)
                                if(response.isSuccessful)
                                    Log.d("API_RESPONSE", "Data: ${response.body()}")
                                else
                                    Log.e("API_ERROR", "Error: ${response.errorBody()?.string()}")
                            }catch (e:Exception){
                                e.printStackTrace()
                            }
                        }
                    }) {
                        Text(text = "Insert Note"
                            , fontSize = 18.sp
                            , fontWeight = FontWeight.W500)
                    }

                    Spacer(modifier = Modifier
                        .height(10.dp))

                    Button(onClick = {
                        var note=Notes(5,"Optimus Prime","We will kill them all!!","26/01/2025")
                        coRoutineScope.launch {
                            try{
                                var response = RetrofitInstance.api.updateNote(note,5)
                                if(response.isSuccessful)
                                    Log.d("update","updated Successfully!! "+response.body().toString())
                                else
                                    Log.d("update_error", response.errorBody().toString())
                            }catch (e:Exception){
                                e.printStackTrace()
                            }
                        }
                    }) {
                        Text(text = "Update Note"
                            , fontSize = 18.sp
                            ,fontWeight = FontWeight.W500)
                    }

                    Spacer(modifier = Modifier
                        .height(10.dp))

                    Button(onClick = {
                        coRoutineScope.launch {
                            try {
                                var response = RetrofitInstance.api.deleteNote(6)
                                if(response.isSuccessful)
                                    response?.body()?.let { Log.d("delete", it) }
                                else
                                    Log.d("delete_error", response.errorBody().toString())
                            }catch (e:Exception){
                                e.printStackTrace()
                            }
                        }
                    }) {
                        Text(text = "Delete Note"
                            , fontSize = 18.sp
                            ,fontWeight = FontWeight.W500)
                    }

                }

            }

        }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreenPreview(){
    HomeScreen()
}