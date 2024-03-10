package com.example.agecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.agecalculator.components.ListViewItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            List()
        }
    }
}

@Composable
fun List(){

    val value = generatedNumber()

    LazyColumn(modifier = Modifier.fillMaxSize().background(color = Color.LightGray),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        itemsIndexed(value){ index , number ->

            ListViewItem(number, index)

           /* if (index !=  value.size - 1) {
                Divider(
                )
            }*/
        }
    }
}

fun generatedNumber(): ArrayList<Int> {
    val value = ArrayList<Int>()

    for (i in 1..100) {
        value.add(i)
    }

    return value
}
