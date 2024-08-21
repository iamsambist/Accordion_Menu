package com.example.accordionsdemo.test.viewmodeldemo.model

import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    private val _itemsFlow = MutableStateFlow<List<String>>(emptyList())
    val itemsFlow: StateFlow<List<String>> = _itemsFlow

    fun loadItems() {
        viewModelScope.launch {
            // Simulate loading items from a repository
            val items = listOf("Item 1", "Item 2", "Item 3")
            _itemsFlow.value = items
        }
    }
}