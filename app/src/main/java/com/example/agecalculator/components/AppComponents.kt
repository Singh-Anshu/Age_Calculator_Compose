package com.example.agecalculator.components

import android.icu.util.Calendar
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
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
}