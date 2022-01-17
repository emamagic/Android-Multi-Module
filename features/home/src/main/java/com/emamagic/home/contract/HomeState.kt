package com.emamagic.home.contract

import com.emamagic.common_entity.Genre
import com.emamagic.common_entity.Slider
import com.emamagic.core.base.BaseState

data class HomeState(
    val sliders: List<Slider>,
    val genres: List<Genre>,
    val closeApp: Boolean,
) : BaseState {
    companion object {
        fun initialize() = HomeState (
            sliders = emptyList(),
            genres = emptyList(),
            closeApp = false
        )
    }
}