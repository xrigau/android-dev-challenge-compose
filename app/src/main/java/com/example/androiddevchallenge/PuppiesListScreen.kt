package com.example.androiddevchallenge

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

@Composable
fun PuppiesListScreen(puppies: List<Puppy>, navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(text = "Puppies!")
            }
        }
    }) {
        LazyColumn {
            items(puppies) { puppy ->
                PuppyListItem(puppy) {
                    navController.navigate("details/${puppies.indexOf(it)}")
                }
            }
        }
    }
}

@Composable
fun PuppyListItem(puppy: Puppy, onClick: (Puppy) -> Unit) {
    Row(
        modifier = Modifier
            .clickable { onClick(puppy) }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(Color.Red)
                .padding(30.dp)
        )
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
        ) {
            Text(text = puppy.name)
            Text(text = puppy.location)
        }
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Text(text = "Age: ${puppy.age}")
            Text(text = puppy.gender)
        }
    }
}