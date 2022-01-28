package com.emamagic.movie.contract

import com.emamagic.core.base.Action

sealed class MovieAction: Action {

    data class GetDetailMovie(val id: String): MovieAction()


    data class GetSeasons(val id: Long): MovieAction()


    data class PlayVideoClicked(val videoLink: String): MovieAction()


    data class SeasonClicked(val seasonId: Long): MovieAction()


}