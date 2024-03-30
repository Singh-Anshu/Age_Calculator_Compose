package com.example.agecalculator.screens

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agecalculator.components.BoxLayout
import com.example.agecalculator.components.CustomText
import com.example.agecalculator.components.DatePickerDateOfBirth

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AgeCalculator() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header Text
            CustomText(
                text = "Age",
                textStyle = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black,
            ) {

            }

            Spacer(modifier = Modifier.height(10.dp))

            // Date Of Birth Component
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp, bottom = 12.dp, top = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                CustomText(
                    text = "Date of Birth",
                    textStyle = TextStyle(
                        fontWeight = FontWeight.Normal, fontSize = 20.sp,
                        textAlign = TextAlign.Start
                    ),
                    modifier = Modifier.weight(1f),
                    color = Color.Black

                ) {

                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    DatePickerDateOfBirth()
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Today Date
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {

                CustomText(
                    text = "Today",
                    textStyle = TextStyle(
                        fontWeight = FontWeight.Normal, fontSize = 18.sp,
                        textAlign = TextAlign.Start
                    ),
                    modifier = Modifier.weight(1f),
                    color = Color.Black

                ) {

                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    DatePickerDateOfBirth()
                }
            }


            BoxLayout()
        }

    }
}

@Composable
fun TopAppBarDemo() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {

            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Centered Top App Bar",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                IconButton(onClick = { /* do something */ }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            },
        },
    )
}


@Composable
fun PreviewAgeCalculator() {
    AgeCalculator()
}

