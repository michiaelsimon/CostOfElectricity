package com.example.costofelectricity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.costofelectricity.ui.screens.calculator_screen
import com.example.costofelectricity.ui.theme.CostOfElectricityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CostOfElectricityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    calculator_screen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}