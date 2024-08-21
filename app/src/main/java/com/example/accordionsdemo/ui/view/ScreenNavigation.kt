package com.example.accordionsdemo.ui.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@Composable
fun ScreenMain(){
    ScreenNavigationView()

}
@Composable
fun ScreenNavigationView(){
    var seletedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Songs","Artists","Playlists")
    val seletedIcons = listOf(Icons.Filled.Home,Icons.Filled.Favorite,Icons.Filled.Person)
    val unSeletedIcons = listOf(Icons.Outlined.Home,Icons.Outlined.FavoriteBorder,Icons.Outlined.Person)

    NavigationBar {
        items.forEachIndexed{index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if(seletedItem == index) seletedIcons[index] else unSeletedIcons[index],
                        contentDescription = item
                    )
                },
                label = { Text(text = item)},
                selected = seletedItem==index,
                onClick = {seletedItem=index}
            )
        }
    }


}