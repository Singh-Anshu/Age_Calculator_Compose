package com.example.agecalculator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.agecalculator.R

@Composable
fun ListViewItem(number: Int, index: Int){

    val color = if(index % 2 == 0) colorResource(R.color.white) else colorResource(R.color.gray)

    Column(
        modifier = Modifier.fillMaxWidth()
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