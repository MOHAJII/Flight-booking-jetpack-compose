package net.haji.first_app.activities.dashboard

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.DropdownMenu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.haji.first_app.R
import net.haji.first_app.activities.splash.StatusTopBarColor
import net.haji.first_app.domain.LocationModal
import net.haji.first_app.viewmodel.MainViewModel

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

    val locations = remember { mutableStateListOf<LocationModal>() }
    val viewModal = MainViewModel()
    var showLocationLoading by remember { mutableStateOf(true) }
    var from: String=""
    var to: String=""
    var classes: String=""

    StatusTopBarColor()

    LaunchedEffect(Unit) {
        viewModal.loadLocations().observeForever { result ->
            locations.clear()
            locations.addAll(result)
            showLocationLoading = false
        }
    }
    
    Scaffold (bottomBar = { MyBottomMenu() }) {
        paddingValues ->
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.dark_purple))
                .padding(paddingValues = paddingValues)
        ) {
            item {
                TopBar()
            }
            item {
                Column (modifier = Modifier
                    .padding(32.dp)
                    .background(
                        colorResource(id = R.color.white_),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 24.dp)
                ) {
                    YellowTitle(text = "From")
                    val locationNames : List<String> = locations.map { it.name }
                    
                    DropDownList(
                        items = locationNames,
                        loadingIcon = painterResource(id = R.drawable.from_ic),
                        hint = "Select origin",
                        showLocationLoading = showLocationLoading
                    ) {
                        selectedItem -> from = selectedItem //
                    }
                }
            }
        }
    }
}

@Composable
fun YellowTitle(text: String, modifier: Modifier = Modifier) {
    Text(text = text,
        fontWeight = FontWeight.SemiBold,
        color = colorResource(id = R.color.yellow),
        modifier = modifier
    )
}