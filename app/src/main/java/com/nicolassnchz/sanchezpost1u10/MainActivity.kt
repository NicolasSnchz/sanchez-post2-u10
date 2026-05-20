package com.nicolassnchz.sanchezpost1u10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nicolassnchz.sanchezpost1u10.remote.HomeRouteSelector
import com.nicolassnchz.sanchezpost1u10.remote.RemoteConfigFeatureFlags
import com.nicolassnchz.sanchezpost1u10.ui.theme.SanchezPost1U10Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val selector = HomeRouteSelector(RemoteConfigFeatureFlags())

        setContent {
            SanchezPost1U10Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (selector.selectedRoute() == HomeRouteSelector.NEW_HOME) {
                        NewHomeScreen()
                    } else {
                        LegacyHomeScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun LegacyHomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Legacy Home Screen")
        Text(text = "Feature flag new_home_screen_enabled = false")
    }
}

@Composable
fun NewHomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "New Home Screen")
        Text(text = "Feature flag new_home_screen_enabled = true")
    }
}
