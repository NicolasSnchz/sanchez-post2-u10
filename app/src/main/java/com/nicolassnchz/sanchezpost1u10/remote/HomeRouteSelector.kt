package com.nicolassnchz.sanchezpost1u10.remote

class HomeRouteSelector(
    private val featureFlags: FeatureFlags
) {
    fun selectedRoute(): String {
        return if (featureFlags.isNewHomeEnabled) {
            NEW_HOME
        } else {
            LEGACY_HOME
        }
    }

    companion object {
        const val LEGACY_HOME = "legacy_home"
        const val NEW_HOME = "new_home"
    }
}
