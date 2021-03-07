/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

val data = listOf(
    Puppy("Fiona", "Barcelona", "10", "Female"),
    Puppy("Rudolph", "London", "2", "Male"),
    Puppy("Bella", "Beijing", "4", "Female"),
    Puppy("Boo", "NYC", "7", "Male"),
    Puppy("Elsa", "Madrid", "14", "Female"),
    Puppy("Fiona", "Barcelona", "10", "Female"),
    Puppy("Rudolph", "London", "2", "Male"),
    Puppy("Bella", "Beijing", "4", "Female"),
    Puppy("Boo", "NYC", "7", "Male"),
    Puppy("Elsa", "Madrid", "14", "Female"),
    Puppy("Fiona", "Barcelona", "10", "Female"),
    Puppy("Rudolph", "London", "2", "Male"),
    Puppy("Bella", "Beijing", "4", "Female"),
    Puppy("Boo", "NYC", "7", "Male"),
    Puppy("Elsa", "Madrid", "14", "Female"),
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "puppies_list") {
        composable("puppies_list") { PuppiesListScreen(data, navController) }
        composable("details/{puppyIndex}") {
            val index = it.arguments?.getString("puppyIndex")!!.toInt()
            PuppyDetailScreen(data[index])
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

data class Puppy(
    val name: String,
    val location: String,
    val age: String,
    val gender: String,
)