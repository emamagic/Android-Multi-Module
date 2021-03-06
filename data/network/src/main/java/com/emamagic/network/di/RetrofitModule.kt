package com.emamagic.network.di

import com.emamagic.network.interceptor.ClientInterceptor
import com.emamagic.network.interceptor.ServerConnection
import com.emamagic.network.service.GenreService
import com.emamagic.network.service.MovieDetailsService
import com.emamagic.network.service.MovieService
import com.emamagic.network.util.Const
import dagger.Lazy
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object RetrofitModule {

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Singleton
    @Provides
    fun provideOkHttp(loggingInterceptor: HttpLoggingInterceptor, clientInterceptor: ClientInterceptor, serverInterceptor: ServerConnection): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(serverInterceptor)
            .addInterceptor(clientInterceptor)
            .readTimeout(8 , TimeUnit.SECONDS)
            .writeTimeout(8 , TimeUnit.SECONDS)
            .connectTimeout(5 , TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: Lazy<OkHttpClient>): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Const.BASE_URL)
            .callFactory { request ->
                // this bellow fun ,called in background thread
                client.get().newCall(request)
            }
            .build()
    }

    @Provides
    fun provideMovieService(retrofit: Retrofit): MovieService = retrofit.create(MovieService::class.java)

    @Provides
    fun provideMovieDetailsService(retrofit: Retrofit): MovieDetailsService = retrofit.create(MovieDetailsService::class.java)

    @Provides
    fun provideGenreService(retrofit: Retrofit): GenreService = retrofit.create(GenreService::class.java)


}
