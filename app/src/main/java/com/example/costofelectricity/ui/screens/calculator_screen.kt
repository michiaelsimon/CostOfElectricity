package com.example.costofelectricity.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.text.DecimalFormat

@Composable
fun calculator_screen(
    modifier: Modifier = Modifier
) {
    val df = DecimalFormat("#.##")

    var kWhInput by remember { mutableStateOf("") }
    var sliderPosition by remember { mutableStateOf(0f) }
    var checkboxVAT by remember { mutableStateOf(false)}

    val kWhFloat = kWhInput.toFloatOrNull() ?: 0f
    val roundedPrice = df.format(sliderPosition).toFloatOrNull() ?: 0f
    val cost = roundedPrice*kWhFloat
    val result = if(checkboxVAT) cost*1.1 else cost*1.24

    Column(
        modifier = modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Cost of electricity",
            style = MaterialTheme.typography.headlineSmall
        )
        OutlinedTextField(
            value = kWhInput,
            onValueChange = {kWhInput = it},
            label = {Text(text = "Consumption in kWh")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Price/kWh: "+df.format(sliderPosition)+"€",
            Modifier.padding(start = 10.dp)
        )
        Slider(
            value = sliderPosition,
            onValueChange = {sliderPosition = it},
            valueRange = 0f..1f,
            modifier = Modifier.padding(horizontal = 22.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkboxVAT,
                onCheckedChange = {checkboxVAT = it}
            )
            Text(
                text = "VAT 10%"
            )
        }
        Surface(
            shape = RectangleShape,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = df.format(result)+"€",
                modifier = Modifier.padding(6.dp)
            )
        }
    }
}