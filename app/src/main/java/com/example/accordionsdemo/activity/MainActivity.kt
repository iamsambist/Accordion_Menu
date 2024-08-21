package com.example.accordionsdemo.activity

import AccordionGroupView
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.accordionsdemo.model.AccordionGroup
import com.example.accordionsdemo.ui.theme.AccordionsDemoTheme

class MainActivity : ComponentActivity() {
    val group = AccordionGroup.getList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AccordionsDemoTheme {
                AccordionGroupView(modifier = Modifier.padding(top = 8.dp), group = group)
            }
        }
    }
}
