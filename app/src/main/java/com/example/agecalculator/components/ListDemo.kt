package com.example.agecalculator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.agecalculator.R

@Composable
fun ListDemo() {

    val value = generatedNumber()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        itemsIndexed(value) { index, number ->

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


@Composable
fun ListViewItem(number: Int, index: Int){

    val color = if(index % 2 == 0) colorResource(R.color.white) else colorResource(R.color.gray)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color)
            .padding(all = 12.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hello Item $number",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black
        )
    }
}