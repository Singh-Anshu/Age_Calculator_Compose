package com.example.agecalculator.components

import android.app.DatePickerDialog
import android.graphics.drawable.PaintDrawable
import android.icu.util.Calendar
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agecalculator.R
import com.example.agecalculator.ui.theme.Orange
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.time.LocalDate
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
                color = Orange,
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
