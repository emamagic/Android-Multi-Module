package com.emamagic.movie.contract

import com.emamagic.common_entity.Cast
import com.emamagic.common_entity.MovieDetail
import com.emamagic.common_entity.Season
import com.emamagic.core.base.Action

sealed class MovieAction: Action {

    data class GetMovieDetail(val movieId: String): MovieAction()
    data class MovieDetailLoaded(val movieDetail: MovieDetail): MovieAction()

    data class GetSeasons(val movieId: String): MovieAction()
    data class SeasonsLoaded(val seasons: List<Season>): MovieAction()

    data class GetCasts(val movieId: String): MovieAction()
    data class CastsLoaded(val casts: List<Cast>): MovieAction()


}