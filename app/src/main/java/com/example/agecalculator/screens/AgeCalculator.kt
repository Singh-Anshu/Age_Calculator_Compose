package com.example.agecalculator.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agecalculator.components.CustomText

@Composable
fun AgeCalculator() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        Column(
            modifier = Modifier.fillMaxSize().background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomText(
                text = "Age",
                textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp, textAlign = TextAlign.Center),
                modifier = Modifier.
                fillMaxWidth(),
                color = Color.Black,
            ) {

            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top

                ) {
                    CustomText(
                        text = "Date of Birth",
                        textStyle = TextStyle(
                            fontWeight = FontWeight.Normal, fontSize = 20.sp,
                            textAlign = TextAlign.Start
                        ),
                        modifier = Modifier.weight(1f),
                        color = Color.LightGray

                    ){

                    }
                }

            }
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAgeCalculator() {
    AgeCalculator()
}
