package com.nicolassnchz.sanchezpost1u10.remote

interface FeatureFlags {
    val isNewHomeEnabled: Boolean
}

class LocalFeatureFlags(
    override val isNewHomeEnabled: Boolean = false
) : FeatureFlags
