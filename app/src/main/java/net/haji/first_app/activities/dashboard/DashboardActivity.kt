package net.haji.first_app.activities.dashboard

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.haji.first_app.R
import net.haji.first_app.activities.splash.StatusTopBarColor

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
@Preview
fun MainScreen() {
    StatusTopBarColor()

    Scaffold (bottomBar = { MyBottomMenu() }) {
        paddingValues ->
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.purple_700))
                .padding(paddingValues = paddingValues)
        ) {

        }
    }
}