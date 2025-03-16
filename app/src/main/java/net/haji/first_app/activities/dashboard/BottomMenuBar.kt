package net.haji.first_app.activities.dashboard

import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.haji.first_app.R

@Composable
fun prepareBottomMenu(): List<MyBottomMenuItem> {
    return listOf(
        MyBottomMenuItem(label = "Home", icon = painterResource(id = R.drawable.bottom_btn1)),
        MyBottomMenuItem(label = "Cart", icon = painterResource(id = R.drawable.bottom_btn2)),
        MyBottomMenuItem(label = "Favorite", icon = painterResource(id = R.drawable.bottom_btn3)),
        MyBottomMenuItem(label = "Order", icon = painterResource(id = R.drawable.bottom_btn4)),

        )
}

@Composable
@Preview
fun MyBottomMenu() {
    val bottomMenuItemsList = prepareBottomMenu()
    val context = LocalContext.current
    var selectedItem by remember {
        mutableStateOf("Home")
    }

    BottomAppBar(
       backroundColor = colorResource(id = R.color.purple_700),
        elevation = 3.dp

    ) {

    }
}