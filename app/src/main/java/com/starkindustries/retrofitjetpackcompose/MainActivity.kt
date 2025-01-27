package com.starkindustries.retrofitjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.starkindustries.retrofitjetpackcompose.Api.RetrofitInstance
import com.starkindustries.retrofitjetpackcompose.Data.UserData
import com.starkindustries.retrofitjetpackcompose.Screens.HomeScreen
import com.starkindustries.retrofitjetpackcompose.Screens.HomeScreenPreview
import com.starkindustries.retrofitjetpackcompose.ui.theme.RetrofitJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetrofitJetpackComposeTheme {
                HomeScreen()
            }
        }
    }
}
