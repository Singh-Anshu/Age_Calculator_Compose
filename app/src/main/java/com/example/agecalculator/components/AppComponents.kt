package com.example.agecalculator.components

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agecalculator.R
import com.example.agecalculator.ui.theme.Orange
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun CustomText(
    text: String,
    modifier: Modifier,
    color: Color = Color.Black,
    textStyle: TextStyle = TextStyle(),
    onclick: () -> Unit
) {

    Text(
        text = text,
        color = color,
        modifier = modifier.clickable { onclick() },
        style = textStyle,
    )

}

@Composable
fun CustomDivider(
    modifier: Modifier
) {
    Divider(
        modifier = modifier,
        color = colorResource(id = R.color.light_gray),
        thickness = 1.dp
    )
}

@Composable
fun BoxLayout(){
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(12.dp)
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(16.dp),
                color = colorResource(id = R.color.light_gray)
            ),
    ){


            Row (

               // horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
            ){

                // Section 1
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ){

                    CustomText(
                        text = "Age",
                        textStyle = TextStyle(
                            fontWeight = FontWeight.Normal, fontSize = 38.sp,
                            textAlign = TextAlign.Start
                        ),
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(start = 10.dp, top = 20.dp),
                        color = Color.Black

                    ){

                    }


                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        CustomText(
                            text = "13",
                            textStyle = TextStyle(
                                fontWeight = FontWeight.Normal, fontSize = 56.sp,
                            ),
                            modifier = Modifier
                                .wrapContentWidth()
                                .padding(start = 10.dp),
                            color = colorResource(id = R.color.orange)

                        ) {

                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        CustomText(
                            text = "years",
                            textStyle = TextStyle(
                                fontWeight = FontWeight.Normal, fontSize = 20.sp,
                            ),
                            modifier = Modifier
                                .wrapContentWidth()
                                .padding(top = 16.dp),
                            color = Color.Black

                        ) {

                        }

                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                    ) {

                        CustomText(
                            text = "6 Months",
                            textStyle = TextStyle(
                                fontWeight = FontWeight.Normal, fontSize = 16.sp,
                            ),
                            modifier = Modifier
                                .wrapContentWidth(),
                            color = Color.LightGray

                        ) {

                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        CustomDivider(
                            modifier = Modifier
                                .height(15.dp)
                                .width(1.dp)
                                .padding(vertical = 0.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        CustomText(
                            text = "28 Day",
                            textStyle = TextStyle(
                                fontWeight = FontWeight.Normal, fontSize = 16.sp,
                            ),
                            modifier = Modifier
                                .wrapContentWidth(),
                            color = Color.LightGray

                        ) {

                        }

                    }

                }

                // Divider
                CustomDivider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .padding(vertical = 10.dp),
                )

                // Section 2
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    CustomText(
                        text = "Next BirthDay",
                        textStyle = TextStyle(
                            fontWeight = FontWeight.Normal, fontSize = 20.sp,
                        ),
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(top = 20.dp),
                        color = colorResource(id = R.color.orange)

                    ){

                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Surface(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(color = colorResource(id = R.color.orange)),
                        color = colorResource(id = R.color.orange)

                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.cake),
                                contentDescription = "BirthDay",
                                modifier = Modifier
                                    .size(24.dp),
                                tint = colorResource(id = R.color.white),
                            )

                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    CustomText(
                        text = "Friday",
                        textStyle = TextStyle(
                            fontWeight = FontWeight.Normal, fontSize = 16.sp,
                        ),
                        modifier = Modifier
                            .wrapContentWidth(),
                        color = Color.LightGray

                    ){

                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        CustomText(
                            text = "5 Months",
                            textStyle = TextStyle(
                                fontWeight = FontWeight.Normal, fontSize = 16.sp,
                            ),
                            modifier = Modifier
                                .wrapContentWidth(),
                            color = Color.LightGray

                        ) {

                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        CustomDivider(
                            modifier = Modifier
                                .height(15.dp)
                                .width(1.dp)
                                .padding(vertical = 0.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        CustomText(
                            text = "1 Day",
                            textStyle = TextStyle(
                                fontWeight = FontWeight.Normal, fontSize = 16.sp,
                            ),
                            modifier = Modifier
                                .wrapContentWidth(),
                            color = Color.LightGray

                        ) {

                        }

                    }


                }

            }


    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatePickerDateOfBirth() {
    val dateFormatter = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    val initialDate = dateFormatter.format(Date())
    val date = remember { mutableStateOf(initialDate) }

    val context = LocalContext.current
    Column {

        Row (
            verticalAlignment = Alignment.CenterVertically
        ){

            Text(
                text = date.value,
                modifier = Modifier .clickable {
                    val calendar = Calendar.getInstance()
                    DatePickerDialog(
                        context,
                        { _, year, month, dayOfMonth ->
                            // Handle the date selected
                            calendar.set(year, month, dayOfMonth)
                            val selectedDate = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(calendar.time)
                            date.value = selectedDate
                            // You can use this dateString as needed
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                    ).show()
                },
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.orange),
                fontSize = 18.sp,
            )

            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "ArrowDropDown", tint = colorResource(
                id = R.color.black
            ) )
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatePickerToday() {
    val dateFormatter = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
    val initialDate = dateFormatter.format(Date())
    val date = remember { mutableStateOf(initialDate) }

    val context = LocalContext.current
    Column {
        Text(
            text = date.value,
            modifier = Modifier.clickable {
                val calendar = Calendar.getInstance()
                DatePickerDialog(
                    context,
                    { _, year, month, dayOfMonth ->
                        // Handle the date selected
                        calendar.set(year, month, dayOfMonth)
                        val selectedDate = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(calendar.time)
                        date.value = selectedDate
                        // You can use this dateString as needed
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            },
            fontWeight = FontWeight.Bold,
            color = Orange,
            fontSize = 21.sp
        )
    }
}

/*
@Composable
fun DatePickerBottomSheet(
    selectedDate: MutableState<String>,
    onDateSelected: (String) -> Unit
) {
    var selectedDateValue by remember { mutableStateOf(Calendar.getInstance()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        // Display the selected date
        Text(
            text = "Selected Date: ${selectedDate.value}",
            modifier = Modifier.padding(top = 16.dp)
        )

        // Date Picker
        Spacer(modifier = Modifier.height(16.dp))
        DatePicker(
            selectedDate = selectedDateValue,
            onDateSelected = {
                selectedDate.value = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(it.time)
                onDateSelected(selectedDate.value)
            }
        )
    }
}

@Composable
fun DatePicker(
    selectedDate: Calendar,
    onDateSelected: (Calendar) -> Unit
) {
    val datePickerDialog = remember { MaterialDatePicker.Builder.datePicker().build() }

    datePickerDialog.addOnPositiveButtonClickListener { timestamp ->
        val selectedCalendar = Calendar.getInstance()
        selectedCalendar.timeInMillis = timestamp
        onDateSelected(selectedCalendar)
    }

    val onClick = remember {
        {
           // datePickerDialog.show(LocalContext.current as FragmentActivity)
        }
    }

    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
    ) {
        Text(text = "Select Date", color = Color.White)
    }
}*/
