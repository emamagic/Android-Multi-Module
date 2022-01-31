package com.emamagic.repository.repository

import com.emamagic.common_entity.Genre
import com.emamagic.common_jvm.ResultWrapper
import com.emamagic.domain.GenreRepository
import com.emamagic.network.dto.GenreDto
import com.emamagic.network.service.GenreService
import com.emamagic.repository.mapper.DataClassMapper
import com.emamagic.safe.SafeApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GenreRepositoryImpl @Inject constructor(
    private val genreService: GenreService
) : GenreRepository, SafeApi() {

    override suspend fun getAllGenre(): ResultWrapper<List<Genre>> = getSafe(
        remoteFetch = { genreService.getAllGenre() },
        mapping = { response -> response.genres.map { DataClassMapper<GenreDto, Genre>()(it) } }
    )
}