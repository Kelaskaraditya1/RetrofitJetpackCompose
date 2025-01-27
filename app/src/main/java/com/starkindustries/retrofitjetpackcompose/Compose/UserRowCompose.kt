package com.starkindustries.retrofitjetpackcompose.Compose

import android.widget.Space
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.starkindustries.retrofitjetpackcompose.Data.UserData

@Composable
fun UserRowCompose(user:UserData){

    Box(modifier = Modifier
        .fillMaxWidth()
        .size(150.dp)
        .padding(8.dp)){
        Card(modifier = Modifier
            .fillMaxSize()) {
            Column(modifier = Modifier
                .padding(10.dp)) {
                Text(text = user.name
                , fontWeight = FontWeight.W500
                , fontSize = 28.sp
                    , color = Color.Black)

                Spacer(modifier = Modifier
                    .height(5.dp))

                Text(text = user.username
                , fontWeight = FontWeight.W400
                , fontSize = 22.sp
                , color = Color.Black)

                Spacer(modifier = Modifier
                    .height(5.dp))

                Text(text = user.email
                , fontWeight = FontWeight.W400
                , fontSize = 18.sp
                    , color = Color.Black)
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Preview(){

}