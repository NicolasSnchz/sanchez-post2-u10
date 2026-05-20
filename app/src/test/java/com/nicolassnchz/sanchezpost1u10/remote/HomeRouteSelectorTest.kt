package com.nicolassnchz.sanchezpost1u10.remote

import org.junit.Assert.assertEquals
import org.junit.Test

class HomeRouteSelectorTest {
    @Test
    fun selectedRouteReturnsLegacyHomeWhenFlagIsFalse() {
        val selector = HomeRouteSelector(LocalFeatureFlags(isNewHomeEnabled = false))

        assertEquals(HomeRouteSelector.LEGACY_HOME, selector.selectedRoute())
    }

    @Test
    fun selectedRouteReturnsNewHomeWhenFlagIsTrue() {
        val selector = HomeRouteSelector(LocalFeatureFlags(isNewHomeEnabled = true))

        assertEquals(HomeRouteSelector.NEW_HOME, selector.selectedRoute())
    }
}
