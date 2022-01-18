package com.emamagic.repository.repository

import com.emamagic.common_entity.Genre
import com.emamagic.common_jvm.ResultWrapper
import com.emamagic.domain.GenreRepository
import com.emamagic.network.service.GenreService
import com.emamagic.safe.SafeApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GenreRepositoryImpl @Inject constructor(
    private val genreService: GenreService
) : GenreRepository, SafeApi() {

    override suspend fun getAllGenre(): ResultWrapper<List<Genre>> {
        TODO("Not yet implemented")
    }
}