package com.example.accordionsdemo.test.viewmodeldemo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import com.example.accordionsdemo.test.viewmodeldemo.model.MyViewModel

@Composable
fun DemoViewModelScreen(viewModel: MyViewModel = viewModel()){
    val items by viewModel.itemsFlow.collectAsState()

    Column {
        items.forEach { item ->
            Text(text = item)
        }
    }
}