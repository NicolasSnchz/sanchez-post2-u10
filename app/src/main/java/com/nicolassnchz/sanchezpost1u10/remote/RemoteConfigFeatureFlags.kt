package com.nicolassnchz.sanchezpost1u10.remote

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

class RemoteConfigFeatureFlags : FeatureFlags {
    private val remoteConfig = Firebase.remoteConfig

    init {
        val settings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }

        remoteConfig.setConfigSettingsAsync(settings)
        remoteConfig.setDefaultsAsync(
            mapOf(NEW_HOME_SCREEN_ENABLED to false)
        )
        remoteConfig.fetchAndActivate()
    }

    override val isNewHomeEnabled: Boolean
        get() = remoteConfig.getBoolean(NEW_HOME_SCREEN_ENABLED)

    companion object {
        const val NEW_HOME_SCREEN_ENABLED = "new_home_screen_enabled"
    }
}
